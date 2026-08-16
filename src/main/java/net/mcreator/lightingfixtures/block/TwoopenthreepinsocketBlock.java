
package net.mcreator.lightingfixtures.block;

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

public class TwoopenthreepinsocketBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final EnumProperty<AttachFace> FACE = FaceAttachedHorizontalDirectionalBlock.FACE;

	public TwoopenthreepinsocketBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.WOOD).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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
				case FLOOR -> Shapes.or(box(15.5, 4.5, 5.5, 16, 9.5, 10.5), box(16, 7.5, 8.5, 18, 10.5, 10.3));
				case WALL -> Shapes.or(box(15.5, 5.5, 4.5, 16, 10.5, 9.5), box(16, 5.7, 7.5, 18, 7.5, 10.5));
				case CEILING -> Shapes.or(box(0, 6.5, 5.5, 0.5, 11.5, 10.5), box(-2, 5.5, 8.5, 0, 8.5, 10.3));
			};
			case NORTH -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(0, 4.5, 5.5, 0.5, 9.5, 10.5), box(-2, 7.5, 5.7, 0, 10.5, 7.5));
				case WALL -> Shapes.or(box(0, 5.5, 6.5, 0.5, 10.5, 11.5), box(-2, 5.7, 5.5, 0, 7.5, 8.5));
				case CEILING -> Shapes.or(box(15.5, 6.5, 5.5, 16, 11.5, 10.5), box(16, 5.5, 5.7, 18, 8.5, 7.5));
			};
			case EAST -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(5.5, 4.5, 0, 10.5, 9.5, 0.5), box(8.5, 7.5, -2, 10.3, 10.5, 0));
				case WALL -> Shapes.or(box(4.5, 5.5, 0, 9.5, 10.5, 0.5), box(7.5, 5.7, -2, 10.5, 7.5, 0));
				case CEILING -> Shapes.or(box(5.5, 6.5, 15.5, 10.5, 11.5, 16), box(8.5, 5.5, 16, 10.3, 8.5, 18));
			};
			case WEST -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(5.5, 4.5, 15.5, 10.5, 9.5, 16), box(5.7, 7.5, 16, 7.5, 10.5, 18));
				case WALL -> Shapes.or(box(6.5, 5.5, 15.5, 11.5, 10.5, 16), box(5.5, 5.7, 16, 8.5, 7.5, 18));
				case CEILING -> Shapes.or(box(5.5, 6.5, 0, 10.5, 11.5, 0.5), box(5.7, 5.5, -2, 7.5, 8.5, 0));
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
