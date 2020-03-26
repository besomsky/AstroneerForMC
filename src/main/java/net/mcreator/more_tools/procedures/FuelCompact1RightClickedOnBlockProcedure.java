package net.mcreator.more_tools.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.mcreator.more_tools.item.FuelCompact1Item;
import net.mcreator.more_tools.block.MalachiteOreBlockBlock;
import net.mcreator.more_tools.MoreToolsElements;

@MoreToolsElements.ModElement.Tag
public class FuelCompact1RightClickedOnBlockProcedure extends MoreToolsElements.ModElement {
	public FuelCompact1RightClickedOnBlockProcedure(MoreToolsElements instance) {
		super(instance, 135);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FuelCompact1RightClickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure FuelCompact1RightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure FuelCompact1RightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure FuelCompact1RightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure FuelCompact1RightClickedOnBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(FuelCompact1Item.block, (int) (1)).getItem())
				&& (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == MalachiteOreBlockBlock.block.getDefaultState()
						.getBlock()) == (true)))) {
			if (!world.isRemote && world.getServer() != null) {
				world.getServer().getCommandManager()
						.handleCommand(
								new CommandSource(ICommandSource.field_213139_a_, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), world.getServer(), null).withFeedbackDisabled(),
								"summon more_tools:Portaltestnur1");
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(FuelCompact1Item.block, (int) (1)).getItem() == p.getItem(),
						(int) 1);
		}
	}
}
