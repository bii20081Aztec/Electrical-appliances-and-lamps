
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

public class DoubletubeceilinglightBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public DoubletubeceilinglightBlock() {
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
			default -> Shapes.or(box(-2.5, 14.5, 4.2, 18.5, 16, 12.2), box(16, 13.5, 5.4, 17.8, 14.5, 7.9), box(16, 13.5, 8.4, 17.8, 14.5, 10.9), box(-1.8, 13.5, 5.4, 0, 14.5, 7.9), box(-1.8, 13.5, 8.4, 0, 14.5, 10.9),
					box(0, 13.7, 9.7, 16, 14.5, 10.5), box(0, 13.7, 8.7, 16, 14.5, 9.5), box(0, 13.7, 6.7, 16, 14.5, 7.5), box(0, 13.7, 5.7, 16, 14.5, 6.5));
			case NORTH -> Shapes.or(box(-2.5, 14.5, 3.8, 18.5, 16, 11.8), box(-1.8, 13.5, 8.1, 0, 14.5, 10.6), box(-1.8, 13.5, 5.1, 0, 14.5, 7.6), box(16, 13.5, 8.1, 17.8, 14.5, 10.6), box(16, 13.5, 5.1, 17.8, 14.5, 7.6),
					box(0, 13.7, 5.5, 16, 14.5, 6.3), box(0, 13.7, 6.5, 16, 14.5, 7.3), box(0, 13.7, 8.5, 16, 14.5, 9.3), box(0, 13.7, 9.5, 16, 14.5, 10.3));
			case EAST -> Shapes.or(box(4.2, 14.5, -2.5, 12.2, 16, 18.5), box(5.4, 13.5, -1.8, 7.9, 14.5, 0), box(8.4, 13.5, -1.8, 10.9, 14.5, 0), box(5.4, 13.5, 16, 7.9, 14.5, 17.8), box(8.4, 13.5, 16, 10.9, 14.5, 17.8),
					box(9.7, 13.7, 0, 10.5, 14.5, 16), box(8.7, 13.7, 0, 9.5, 14.5, 16), box(6.7, 13.7, 0, 7.5, 14.5, 16), box(5.7, 13.7, 0, 6.5, 14.5, 16));
			case WEST -> Shapes.or(box(3.8, 14.5, -2.5, 11.8, 16, 18.5), box(8.1, 13.5, 16, 10.6, 14.5, 17.8), box(5.1, 13.5, 16, 7.6, 14.5, 17.8), box(8.1, 13.5, -1.8, 10.6, 14.5, 0), box(5.1, 13.5, -1.8, 7.6, 14.5, 0),
					box(5.5, 13.7, 0, 6.3, 14.5, 16), box(6.5, 13.7, 0, 7.3, 14.5, 16), box(8.5, 13.7, 0, 9.3, 14.5, 16), box(9.5, 13.7, 0, 10.3, 14.5, 16));
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
