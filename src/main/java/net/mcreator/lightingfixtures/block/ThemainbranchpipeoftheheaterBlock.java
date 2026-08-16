
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

public class ThemainbranchpipeoftheheaterBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public ThemainbranchpipeoftheheaterBlock() {
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
			default -> Shapes.or(box(0, 11.1, 11.6, 13.6, 12.9, 13.4), box(13.6, 0, 11.6, 15.4, 11, 13.4), box(13.6, 13, 11.6, 15.4, 18, 13.4), box(13.5, 11, 11.5, 15.5, 13, 13.5));
			case NORTH -> Shapes.or(box(2.4, 11.1, 2.6, 16, 12.9, 4.4), box(0.6, 0, 2.6, 2.4, 11, 4.4), box(0.6, 13, 2.6, 2.4, 18, 4.4), box(0.5, 11, 2.5, 2.5, 13, 4.5));
			case EAST -> Shapes.or(box(11.6, 11.1, 2.4, 13.4, 12.9, 16), box(11.6, 0, 0.6, 13.4, 11, 2.4), box(11.6, 13, 0.6, 13.4, 18, 2.4), box(11.5, 11, 0.5, 13.5, 13, 2.5));
			case WEST -> Shapes.or(box(2.6, 11.1, 0, 4.4, 12.9, 13.6), box(2.6, 0, 13.6, 4.4, 11, 15.4), box(2.6, 13, 13.6, 4.4, 18, 15.4), box(2.5, 11, 13.5, 4.5, 13, 15.5));
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
