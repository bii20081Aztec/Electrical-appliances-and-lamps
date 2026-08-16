
package net.mcreator.lightingfixtures.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class FireAlarmButtonBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public FireAlarmButtonBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
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
			default -> Shapes.or(box(4.5, 4.5, 0, 9.5, 9.5, 1.5), box(4.5, 8, 1.5, 9.5, 9.5, 1.8), box(4.5, 4.5, 1.5, 9.5, 6, 1.8), box(4.5, 6, 1.5, 5, 8, 1.8), box(9, 6, 1.5, 9.5, 8, 1.8));
			case NORTH -> Shapes.or(box(6.5, 4.5, 14.5, 11.5, 9.5, 16), box(6.5, 8, 14.2, 11.5, 9.5, 14.5), box(6.5, 4.5, 14.2, 11.5, 6, 14.5), box(11, 6, 14.2, 11.5, 8, 14.5), box(6.5, 6, 14.2, 7, 8, 14.5));
			case EAST -> Shapes.or(box(0, 4.5, 6.5, 1.5, 9.5, 11.5), box(1.5, 8, 6.5, 1.8, 9.5, 11.5), box(1.5, 4.5, 6.5, 1.8, 6, 11.5), box(1.5, 6, 11, 1.8, 8, 11.5), box(1.5, 6, 6.5, 1.8, 8, 7));
			case WEST -> Shapes.or(box(14.5, 4.5, 4.5, 16, 9.5, 9.5), box(14.2, 8, 4.5, 14.5, 9.5, 9.5), box(14.2, 4.5, 4.5, 14.5, 6, 9.5), box(14.2, 6, 4.5, 14.5, 8, 5), box(14.2, 6, 9, 14.5, 8, 9.5));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}
}
