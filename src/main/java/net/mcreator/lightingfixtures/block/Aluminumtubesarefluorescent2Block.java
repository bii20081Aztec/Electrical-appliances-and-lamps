
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

public class Aluminumtubesarefluorescent2Block extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public Aluminumtubesarefluorescent2Block() {
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
			default -> Shapes.or(box(27, 4, 7, 28, 15, 8), box(-12, 4, 7, -11, 15, 8), box(-13, 3, 5, 29, 4, 10), box(-13, 0, 5, -7, 3, 10), box(23, 0, 5, 29, 3, 10));
			case NORTH -> Shapes.or(box(-12, 4, 8, -11, 15, 9), box(27, 4, 8, 28, 15, 9), box(-13, 3, 6, 29, 4, 11), box(23, 0, 6, 29, 3, 11), box(-13, 0, 6, -7, 3, 11));
			case EAST -> Shapes.or(box(7, 4, -12, 8, 15, -11), box(7, 4, 27, 8, 15, 28), box(5, 3, -13, 10, 4, 29), box(5, 0, 23, 10, 3, 29), box(5, 0, -13, 10, 3, -7));
			case WEST -> Shapes.or(box(8, 4, 27, 9, 15, 28), box(8, 4, -12, 9, 15, -11), box(6, 3, -13, 11, 4, 29), box(6, 0, -13, 11, 3, -7), box(6, 0, 23, 11, 3, 29));
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
