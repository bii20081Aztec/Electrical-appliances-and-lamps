
package net.mcreator.lightingfixtures.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
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

public class IodinetungstenlampBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final EnumProperty<AttachFace> FACE = FaceAttachedHorizontalDirectionalBlock.FACE;

	public IodinetungstenlampBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(1f, 10f).lightLevel(s -> 15).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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
				case FLOOR -> Shapes.or(box(11.5, 1, -2, 12, 23, 1), box(5.5, 1, 2, 8.5, 23, 2.5), box(6, 1, 0, 10, 23, 0.5), box(7.5, 2, 0.5, 8.5, 3.5, 1.5), box(7.6, 3.5, 0.6, 8.4, 20.5, 1.4), box(7.5, 20.5, 0.5, 8.5, 22, 1.5));
				case WALL -> Shapes.or(box(11.5, 15, 1, 12, 18, 23), box(5.5, 13.5, 1, 8.5, 14, 23), box(6, 15.5, 1, 10, 16, 23), box(7.5, 14.5, 2, 8.5, 15.5, 3.5), box(7.6, 14.6, 3.5, 8.4, 15.4, 20.5), box(7.5, 14.5, 20.5, 8.5, 15.5, 22));
				case CEILING -> Shapes.or(box(4, -7, -2, 4.5, 15, 1), box(7.5, -7, 2, 10.5, 15, 2.5), box(6, -7, 0, 10, 15, 0.5), box(7.5, 12.5, 0.5, 8.5, 14, 1.5), box(7.6, -4.5, 0.6, 8.4, 12.5, 1.4), box(7.5, -6, 0.5, 8.5, -4.5, 1.5));
			};
			case NORTH -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(4, 1, 15, 4.5, 23, 18), box(7.5, 1, 13.5, 10.5, 23, 14), box(6, 1, 15.5, 10, 23, 16), box(7.5, 2, 14.5, 8.5, 3.5, 15.5), box(7.6, 3.5, 14.6, 8.4, 20.5, 15.4), box(7.5, 20.5, 14.5, 8.5, 22, 15.5));
				case WALL -> Shapes.or(box(4, 15, -7, 4.5, 18, 15), box(7.5, 13.5, -7, 10.5, 14, 15), box(6, 15.5, -7, 10, 16, 15), box(7.5, 14.5, 12.5, 8.5, 15.5, 14), box(7.6, 14.6, -4.5, 8.4, 15.4, 12.5), box(7.5, 14.5, -6, 8.5, 15.5, -4.5));
				case CEILING -> Shapes.or(box(11.5, -7, 15, 12, 15, 18), box(5.5, -7, 13.5, 8.5, 15, 14), box(6, -7, 15.5, 10, 15, 16), box(7.5, 12.5, 14.5, 8.5, 14, 15.5), box(7.6, -4.5, 14.6, 8.4, 12.5, 15.4), box(7.5, -6, 14.5, 8.5, -4.5, 15.5));
			};
			case EAST -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(-2, 1, 4, 1, 23, 4.5), box(2, 1, 7.5, 2.5, 23, 10.5), box(0, 1, 6, 0.5, 23, 10), box(0.5, 2, 7.5, 1.5, 3.5, 8.5), box(0.6, 3.5, 7.6, 1.4, 20.5, 8.4), box(0.5, 20.5, 7.5, 1.5, 22, 8.5));
				case WALL -> Shapes.or(box(1, 15, 4, 23, 18, 4.5), box(1, 13.5, 7.5, 23, 14, 10.5), box(1, 15.5, 6, 23, 16, 10), box(2, 14.5, 7.5, 3.5, 15.5, 8.5), box(3.5, 14.6, 7.6, 20.5, 15.4, 8.4), box(20.5, 14.5, 7.5, 22, 15.5, 8.5));
				case CEILING -> Shapes.or(box(-2, -7, 11.5, 1, 15, 12), box(2, -7, 5.5, 2.5, 15, 8.5), box(0, -7, 6, 0.5, 15, 10), box(0.5, 12.5, 7.5, 1.5, 14, 8.5), box(0.6, -4.5, 7.6, 1.4, 12.5, 8.4), box(0.5, -6, 7.5, 1.5, -4.5, 8.5));
			};
			case WEST -> switch (state.getValue(FACE)) {
				case FLOOR -> Shapes.or(box(15, 1, 11.5, 18, 23, 12), box(13.5, 1, 5.5, 14, 23, 8.5), box(15.5, 1, 6, 16, 23, 10), box(14.5, 2, 7.5, 15.5, 3.5, 8.5), box(14.6, 3.5, 7.6, 15.4, 20.5, 8.4), box(14.5, 20.5, 7.5, 15.5, 22, 8.5));
				case WALL -> Shapes.or(box(-7, 15, 11.5, 15, 18, 12), box(-7, 13.5, 5.5, 15, 14, 8.5), box(-7, 15.5, 6, 15, 16, 10), box(12.5, 14.5, 7.5, 14, 15.5, 8.5), box(-4.5, 14.6, 7.6, 12.5, 15.4, 8.4), box(-6, 14.5, 7.5, -4.5, 15.5, 8.5));
				case CEILING -> Shapes.or(box(15, -7, 4, 18, 15, 4.5), box(13.5, -7, 7.5, 14, 15, 10.5), box(15.5, -7, 6, 16, 15, 10), box(14.5, 12.5, 7.5, 15.5, 14, 8.5), box(14.6, -4.5, 7.6, 15.4, 12.5, 8.4), box(14.5, -6, 7.5, 15.5, -4.5, 8.5));
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
