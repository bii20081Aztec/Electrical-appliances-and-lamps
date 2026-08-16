
package net.mcreator.lightingfixtures.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
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

public class FluorescentluminairesBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public FluorescentluminairesBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.WOOD).strength(1f, 10f).lightLevel(s -> 15).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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
			default -> Shapes.or(box(7, 13, 7, 9, 30, 9), box(0, 12, 6, 16, 13, 10), box(1, 9, 6.5, 15, 12, 9.5), box(-7, 1.8, 7.2, 23, 3.3, 8.7), box(-9, 1.5, 7, -7, 3.5, 9), box(23, 1.5, 7, 25, 3.5, 9));
			case NORTH -> Shapes.or(box(7, 13, 7, 9, 30, 9), box(0, 12, 6, 16, 13, 10), box(1, 9, 6.5, 15, 12, 9.5), box(-7, 1.8, 7.3, 23, 3.3, 8.8), box(23, 1.5, 7, 25, 3.5, 9), box(-9, 1.5, 7, -7, 3.5, 9));
			case EAST -> Shapes.or(box(7, 13, 7, 9, 30, 9), box(6, 12, 0, 10, 13, 16), box(6.5, 9, 1, 9.5, 12, 15), box(7.2, 1.8, -7, 8.7, 3.3, 23), box(7, 1.5, 23, 9, 3.5, 25), box(7, 1.5, -9, 9, 3.5, -7));
			case WEST -> Shapes.or(box(7, 13, 7, 9, 30, 9), box(6, 12, 0, 10, 13, 16), box(6.5, 9, 1, 9.5, 12, 15), box(7.3, 1.8, -7, 8.8, 3.3, 23), box(7, 1.5, -9, 9, 3.5, -7), box(7, 1.5, 23, 9, 3.5, 25));
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
