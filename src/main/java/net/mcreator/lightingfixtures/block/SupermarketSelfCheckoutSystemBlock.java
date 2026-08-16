
package net.mcreator.lightingfixtures.block;

import org.checkerframework.checker.units.qual.s;

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

public class SupermarketSelfCheckoutSystemBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public SupermarketSelfCheckoutSystemBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(1f, 10f).lightLevel(s -> 15).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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
			default -> Shapes.or(box(0, -16, 0, 16, 2, 16), box(16, -3, 0.44, 26.5, 0, 15.44), box(-10.5, -3, 0.5, 0, 0, 15.5), box(0, 2, 0, 16, 29, 5), box(0, 2, 4.9, 2, 29, 5.2), box(2, 27, 4.9, 14, 29, 5.2), box(2, 2, 4.9, 14, 10, 5.2),
					box(14, 2, 4.9, 16, 29, 5.2), box(0, 29, 0, 16, 32, 8), box(2, 10, 5, 14, 27, 5.1));
			case NORTH -> Shapes.or(box(0, -16, 0, 16, 2, 16), box(-10.5, -3, 0.56, 0, 0, 15.56), box(16, -3, 0.5, 26.5, 0, 15.5), box(0, 2, 11, 16, 29, 16), box(14, 2, 10.8, 16, 29, 11.1), box(2, 27, 10.8, 14, 29, 11.1),
					box(2, 2, 10.8, 14, 10, 11.1), box(0, 2, 10.8, 2, 29, 11.1), box(0, 29, 8, 16, 32, 16), box(2, 10, 10.9, 14, 27, 11));
			case EAST -> Shapes.or(box(0, -16, 0, 16, 2, 16), box(0.44, -3, -10.5, 15.44, 0, 0), box(0.5, -3, 16, 15.5, 0, 26.5), box(0, 2, 0, 5, 29, 16), box(4.9, 2, 14, 5.2, 29, 16), box(4.9, 27, 2, 5.2, 29, 14), box(4.9, 2, 2, 5.2, 10, 14),
					box(4.9, 2, 0, 5.2, 29, 2), box(0, 29, 0, 8, 32, 16), box(5, 10, 2, 5.1, 27, 14));
			case WEST -> Shapes.or(box(0, -16, 0, 16, 2, 16), box(0.56, -3, 16, 15.56, 0, 26.5), box(0.5, -3, -10.5, 15.5, 0, 0), box(11, 2, 0, 16, 29, 16), box(10.8, 2, 0, 11.1, 29, 2), box(10.8, 27, 2, 11.1, 29, 14), box(10.8, 2, 2, 11.1, 10, 14),
					box(10.8, 2, 14, 11.1, 29, 16), box(8, 29, 0, 16, 32, 16), box(10.9, 10, 2, 11, 27, 14));
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
