
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

public class WatermeterBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public WatermeterBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.ANVIL).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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
			default -> Shapes.or(box(5, 3, 11.5, 8.5, 6, 15), box(4.8, 6, 11.3, 8.8, 7, 15.3), box(5.1, 7, 14.7, 8.5, 10.4, 15), box(11, 5.8, 12.7, 12, 6.9, 13.7), box(12, 5.98, 12.85, 14, 6.78, 13.55), box(8.5, 4, 12.5, 10.5, 5.5, 14),
					box(10.5, 3.8, 12.2, 12.5, 5.8, 14.2), box(3, 4, 12.5, 5, 5.5, 14), box(12.5, 4, 12.5, 13.5, 5.5, 14), box(1.5, 4, 12.5, 3, 5.5, 16), box(13.5, 4, 12.5, 15, 5.5, 16));
			case NORTH -> Shapes.or(box(7.5, 3, 1, 11, 6, 4.5), box(7.2, 6, 0.7, 11.2, 7, 4.7), box(7.5, 7, 1, 10.9, 10.4, 1.3), box(4, 5.8, 2.3, 5, 6.9, 3.3), box(2, 5.98, 2.45, 4, 6.78, 3.15), box(5.5, 4, 2, 7.5, 5.5, 3.5),
					box(3.5, 3.8, 1.8, 5.5, 5.8, 3.8), box(11, 4, 2, 13, 5.5, 3.5), box(2.5, 4, 2, 3.5, 5.5, 3.5), box(13, 4, 0, 14.5, 5.5, 3.5), box(1, 4, 0, 2.5, 5.5, 3.5));
			case EAST -> Shapes.or(box(11.5, 3, 7.5, 15, 6, 11), box(11.3, 6, 7.2, 15.3, 7, 11.2), box(14.7, 7, 7.5, 15, 10.4, 10.9), box(12.7, 5.8, 4, 13.7, 6.9, 5), box(12.85, 5.98, 2, 13.55, 6.78, 4), box(12.5, 4, 5.5, 14, 5.5, 7.5),
					box(12.2, 3.8, 3.5, 14.2, 5.8, 5.5), box(12.5, 4, 11, 14, 5.5, 13), box(12.5, 4, 2.5, 14, 5.5, 3.5), box(12.5, 4, 13, 16, 5.5, 14.5), box(12.5, 4, 1, 16, 5.5, 2.5));
			case WEST -> Shapes.or(box(1, 3, 5, 4.5, 6, 8.5), box(0.7, 6, 4.8, 4.7, 7, 8.8), box(1, 7, 5.1, 1.3, 10.4, 8.5), box(2.3, 5.8, 11, 3.3, 6.9, 12), box(2.45, 5.98, 12, 3.15, 6.78, 14), box(2, 4, 8.5, 3.5, 5.5, 10.5),
					box(1.8, 3.8, 10.5, 3.8, 5.8, 12.5), box(2, 4, 3, 3.5, 5.5, 5), box(2, 4, 12.5, 3.5, 5.5, 13.5), box(0, 4, 1.5, 3.5, 5.5, 3), box(0, 4, 13.5, 3.5, 5.5, 15));
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
