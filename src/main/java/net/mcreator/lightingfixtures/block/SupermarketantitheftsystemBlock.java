
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

public class SupermarketantitheftsystemBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public SupermarketantitheftsystemBlock() {
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
			default -> Shapes.or(box(-1, -14, 7, 17, -3, 9), box(-1, -3, 7, 0, 31, 9), box(16, -3, 7, 17, 31, 9), box(0, 29, 7, 16, 32, 9), box(0, 14, 7, 16, 15, 9), box(0, 12, 7, 16, 13, 9), box(0, -16, 6, 16, -4, 10));
			case NORTH -> Shapes.or(box(-1, -14, 7, 17, -3, 9), box(16, -3, 7, 17, 31, 9), box(-1, -3, 7, 0, 31, 9), box(0, 29, 7, 16, 32, 9), box(0, 14, 7, 16, 15, 9), box(0, 12, 7, 16, 13, 9), box(0, -16, 6, 16, -4, 10));
			case EAST -> Shapes.or(box(7, -14, -1, 9, -3, 17), box(7, -3, 16, 9, 31, 17), box(7, -3, -1, 9, 31, 0), box(7, 29, 0, 9, 32, 16), box(7, 14, 0, 9, 15, 16), box(7, 12, 0, 9, 13, 16), box(6, -16, 0, 10, -4, 16));
			case WEST -> Shapes.or(box(7, -14, -1, 9, -3, 17), box(7, -3, -1, 9, 31, 0), box(7, -3, 16, 9, 31, 17), box(7, 29, 0, 9, 32, 16), box(7, 14, 0, 9, 15, 16), box(7, 12, 0, 9, 13, 16), box(6, -16, 0, 10, -4, 16));
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
