
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

public class HeatingbleedvalveBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public HeatingbleedvalveBlock() {
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
			default -> Shapes.or(box(6, 7, 11.7, 7.5, 11, 13.2), box(3.5, 7, 11.7, 6, 8.5, 13.2), box(5.7, 11, 11.5, 7.7, 13, 13.5), box(13, 11.1, 11.6, 16, 12.9, 13.4), box(7.3, 11.1, 11.6, 11, 12.9, 13.4));
			case NORTH -> Shapes.or(box(8.5, 7, 2.8, 10, 11, 4.3), box(10, 7, 2.8, 12.5, 8.5, 4.3), box(8.3, 11, 2.5, 10.3, 13, 4.5), box(0, 11.1, 2.6, 3, 12.9, 4.4), box(5, 11.1, 2.6, 8.7, 12.9, 4.4));
			case EAST -> Shapes.or(box(11.7, 7, 8.5, 13.2, 11, 10), box(11.7, 7, 10, 13.2, 8.5, 12.5), box(11.5, 11, 8.3, 13.5, 13, 10.3), box(11.6, 11.1, 0, 13.4, 12.9, 3), box(11.6, 11.1, 5, 13.4, 12.9, 8.7));
			case WEST -> Shapes.or(box(2.8, 7, 6, 4.3, 11, 7.5), box(2.8, 7, 3.5, 4.3, 8.5, 6), box(2.5, 11, 5.7, 4.5, 13, 7.7), box(2.6, 11.1, 13, 4.4, 12.9, 16), box(2.6, 11.1, 7.3, 4.4, 12.9, 11));
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
