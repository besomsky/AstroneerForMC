package net.mcreator.more_tools.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.more_tools.item.TankfuelItem;
import net.mcreator.more_tools.item.TankemptyItem;
import net.mcreator.more_tools.block.FuelBlock;
import net.mcreator.more_tools.MoreToolsElements;

@MoreToolsElements.ModElement.Tag
public class TankfuelRightClickedOnBlockProcedure extends MoreToolsElements.ModElement {
	public TankfuelRightClickedOnBlockProcedure(MoreToolsElements instance) {
		super(instance, 134);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TankfuelRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure TankfuelRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure TankfuelRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure TankfuelRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure TankfuelRightClickedOnBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(TankfuelItem.block, (int) (1)).getItem())
				&& (!((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == FuelBlock.block.getDefaultState()
						.getBlock())))) {
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), FuelBlock.block.getDefaultState(), 3);
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(TankfuelItem.block, (int) (1)).getItem() == p.getItem(),
						(int) 1);
			if (entity instanceof PlayerEntity)
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), new ItemStack(TankemptyItem.block, (int) (1)));
		}
	}
}
