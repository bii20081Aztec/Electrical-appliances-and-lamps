
package net.mcreator.lightingfixtures.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class LampwarmthbathBlock extends Block {
	public LampwarmthbathBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.ANVIL).strength(1f, 10f).lightLevel(s -> 15).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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
		return Shapes.or(box(0.5, 1, 0.5, 15.5, 7, 15.5), box(0, 0, 0, 16, 1, 16), box(1, -0.5, 1, 6, 0.5, 6), box(10, -0.5, 1, 15, 0.5, 6), box(6.5, -0.5, 6.5, 9.5, 0.5, 9.5), box(10, -0.5, 10, 15, 0.5, 15), box(1, -0.5, 10, 6, 0.5, 15));
	}
}
