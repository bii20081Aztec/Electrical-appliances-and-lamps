
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

public class FireemergencylightBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public FireemergencylightBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(1f, 10f).lightLevel(s -> 10).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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
			default -> Shapes.or(box(3, 0, 0, 13, 6, 2), box(3, 7, 0.5, 7, 11, 1.5), box(3.25, 7.6, 0.25, 6.75, 11.1, 1.75), box(9.25, 7.6, 0.25, 12.75, 11.1, 1.75), box(9, 7, 0.5, 13, 11, 1.5), box(10.5, 6, 0.7, 11.5, 8, 1.7),
					box(4.5, 6, 0.7, 5.5, 8, 1.7));
			case NORTH -> Shapes.or(box(3, 0, 14, 13, 6, 16), box(9, 7, 14.5, 13, 11, 15.5), box(9.25, 7.6, 14.25, 12.75, 11.1, 15.75), box(3.25, 7.6, 14.25, 6.75, 11.1, 15.75), box(3, 7, 14.5, 7, 11, 15.5), box(4.5, 6, 14.3, 5.5, 8, 15.3),
					box(10.5, 6, 14.3, 11.5, 8, 15.3));
			case EAST -> Shapes.or(box(0, 0, 3, 2, 6, 13), box(0.5, 7, 9, 1.5, 11, 13), box(0.25, 7.6, 9.25, 1.75, 11.1, 12.75), box(0.25, 7.6, 3.25, 1.75, 11.1, 6.75), box(0.5, 7, 3, 1.5, 11, 7), box(0.7, 6, 4.5, 1.7, 8, 5.5),
					box(0.7, 6, 10.5, 1.7, 8, 11.5));
			case WEST -> Shapes.or(box(14, 0, 3, 16, 6, 13), box(14.5, 7, 3, 15.5, 11, 7), box(14.25, 7.6, 3.25, 15.75, 11.1, 6.75), box(14.25, 7.6, 9.25, 15.75, 11.1, 12.75), box(14.5, 7, 9, 15.5, 11, 13), box(14.3, 6, 10.5, 15.3, 8, 11.5),
					box(14.3, 6, 4.5, 15.3, 8, 5.5));
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
