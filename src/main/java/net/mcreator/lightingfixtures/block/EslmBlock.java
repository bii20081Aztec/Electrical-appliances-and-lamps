
package net.mcreator.lightingfixtures.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class EslmBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final EnumProperty<AttachFace> FACE = FaceAttachedHorizontalDirectionalBlock.FACE;

	public EslmBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.WOOD).strength(1f, 10f).lightLevel(s -> 15).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(FACE, AttachFace.WALL));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			default -> switch (state.getValue(FACE)) {
				case FLOOR -> box(4.72, 5, 4.72, 10.22, 16, 10.22);
				case WALL -> box(4.72, 5.78, 5, 10.22, 11.28, 16);
				case CEILING -> box(5.78, 0, 4.72, 11.28, 11, 10.22);
			};
			case NORTH -> switch (state.getValue(FACE)) {
				case FLOOR -> box(5.78, 5, 5.78, 11.28, 16, 11.28);
				case WALL -> box(5.78, 5.78, 0, 11.28, 11.28, 11);
				case CEILING -> box(4.72, 0, 5.78, 10.22, 11, 11.28);
			};
			case EAST -> switch (state.getValue(FACE)) {
				case FLOOR -> box(4.72, 5, 5.78, 10.22, 16, 11.28);
				case WALL -> box(5, 5.78, 5.78, 16, 11.28, 11.28);
				case CEILING -> box(4.72, 0, 4.72, 10.22, 11, 10.22);
			};
			case WEST -> switch (state.getValue(FACE)) {
				case FLOOR -> box(5.78, 5, 4.72, 11.28, 16, 10.22);
				case WALL -> box(0, 5.78, 4.72, 11, 11.28, 10.22);
				case CEILING -> box(5.78, 0, 5.78, 11.28, 11, 11.28);
			};
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, FACE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return super.getStateForPlacement(context).setValue(FACE, faceForDirection(context.getNearestLookingDirection())).setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	private AttachFace faceForDirection(Direction direction) {
		if (direction.getAxis() == Direction.Axis.Y)
			return direction == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR;
		else
			return AttachFace.WALL;
	}
}
