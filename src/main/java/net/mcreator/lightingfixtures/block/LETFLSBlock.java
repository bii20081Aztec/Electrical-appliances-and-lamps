
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
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.List;

public class LETFLSBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public LETFLSBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(1f, 10f).lightLevel(s -> 15).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, BlockGetter level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.translatable("block.lightingfixtures.letfls.description_0"));
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
			default -> Shapes.or(box(1, 15, 7, 15, 16, 8), box(15, 15, 7, 16, 16, 8), box(0, 15, 7, 1, 16, 8), box(1, 14.1, 7.2, 15, 14.7, 7.8), box(0, 14, 7.15, 1, 15, 7.85), box(15, 14, 7.15, 16, 15, 7.85));
			case NORTH -> Shapes.or(box(1, 15, 8, 15, 16, 9), box(0, 15, 8, 1, 16, 9), box(15, 15, 8, 16, 16, 9), box(1, 14.1, 8.2, 15, 14.7, 8.8), box(15, 14, 8.15, 16, 15, 8.85), box(0, 14, 8.15, 1, 15, 8.85));
			case EAST -> Shapes.or(box(7, 15, 1, 8, 16, 15), box(7, 15, 0, 8, 16, 1), box(7, 15, 15, 8, 16, 16), box(7.2, 14.1, 1, 7.8, 14.7, 15), box(7.15, 14, 15, 7.85, 15, 16), box(7.15, 14, 0, 7.85, 15, 1));
			case WEST -> Shapes.or(box(8, 15, 1, 9, 16, 15), box(8, 15, 15, 9, 16, 16), box(8, 15, 0, 9, 16, 1), box(8.2, 14.1, 1, 8.8, 14.7, 15), box(8.15, 14, 0, 8.85, 15, 1), box(8.15, 14, 15, 8.85, 15, 16));
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
