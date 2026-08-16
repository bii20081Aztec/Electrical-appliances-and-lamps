
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

public class HeatingmainvalveBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public HeatingmainvalveBlock() {
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
			default -> Shapes.or(box(13.6, 4, 11.6, 15.4, 16, 13.4), box(13.6, 0, 11.6, 15.4, 2, 13.4), box(13.5, 2, 11.5, 15.5, 4, 13.5), box(14, 2.5, 10.6, 15, 3.5, 11.7), box(14.15, 3, 10.7, 14.85, 5, 11.5));
			case NORTH -> Shapes.or(box(0.6, 4, 2.6, 2.4, 16, 4.4), box(0.6, 0, 2.6, 2.4, 2, 4.4), box(0.5, 2, 2.5, 2.5, 4, 4.5), box(1, 2.5, 4.3, 2, 3.5, 5.4), box(1.15, 3, 4.5, 1.85, 5, 5.3));
			case EAST -> Shapes.or(box(11.6, 4, 0.6, 13.4, 16, 2.4), box(11.6, 0, 0.6, 13.4, 2, 2.4), box(11.5, 2, 0.5, 13.5, 4, 2.5), box(10.6, 2.5, 1, 11.7, 3.5, 2), box(10.7, 3, 1.15, 11.5, 5, 1.85));
			case WEST -> Shapes.or(box(2.6, 4, 13.6, 4.4, 16, 15.4), box(2.6, 0, 13.6, 4.4, 2, 15.4), box(2.5, 2, 13.5, 4.5, 4, 15.5), box(4.3, 2.5, 14, 5.4, 3.5, 15), box(4.5, 3, 14.15, 5.3, 5, 14.85));
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
