
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

public class ESLSBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final EnumProperty<AttachFace> FACE = FaceAttachedHorizontalDirectionalBlock.FACE;

	public ESLSBlock() {
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
				case FLOOR -> Shapes.or(box(5, 15.8, 5, 10, 16.1, 10), box(6.25, 9, 6.25, 8.75, 16, 8.75));
				case WALL -> Shapes.or(box(5, 6, 15.8, 10, 11, 16.1), box(6.25, 7.25, 9, 8.75, 9.75, 16));
				case CEILING -> Shapes.or(box(6, -0.1, 5, 11, 0.2, 10), box(7.25, 0, 6.25, 9.75, 7, 8.75));
			};
			case NORTH -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(6, 15.8, 6, 11, 16.1, 11), box(7.25, 9, 7.25, 9.75, 16, 9.75));
				case WALL -> Shapes.or(box(6, 6, -0.1, 11, 11, 0.2), box(7.25, 7.25, 0, 9.75, 9.75, 7));
				case CEILING -> Shapes.or(box(5, -0.1, 6, 10, 0.2, 11), box(6.25, 0, 7.25, 8.75, 7, 9.75));
			};
			case EAST -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(5, 15.8, 6, 10, 16.1, 11), box(6.25, 9, 7.25, 8.75, 16, 9.75));
				case WALL -> Shapes.or(box(15.8, 6, 6, 16.1, 11, 11), box(9, 7.25, 7.25, 16, 9.75, 9.75));
				case CEILING -> Shapes.or(box(5, -0.1, 5, 10, 0.2, 10), box(6.25, 0, 6.25, 8.75, 7, 8.75));
			};
			case WEST -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(6, 15.8, 5, 11, 16.1, 10), box(7.25, 9, 6.25, 9.75, 16, 8.75));
				case WALL -> Shapes.or(box(-0.1, 6, 5, 0.2, 11, 10), box(0, 7.25, 6.25, 7, 9.75, 8.75));
				case CEILING -> Shapes.or(box(6, -0.1, 6, 11, 0.2, 11), box(7.25, 0, 7.25, 9.75, 7, 9.75));
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
