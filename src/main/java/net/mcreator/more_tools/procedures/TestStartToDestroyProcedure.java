package net.mcreator.more_tools.procedures;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.more_tools.MoreToolsElements;

@MoreToolsElements.ModElement.Tag
public class TestStartToDestroyProcedure extends MoreToolsElements.ModElement {
	public TestStartToDestroyProcedure(MoreToolsElements instance) {
		super(instance, 118);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TestStartToDestroy!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure TestStartToDestroy!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		entity.attackEntityFrom(DamageSource.MAGIC, (float) 5);
		if (entity instanceof PlayerEntity && !world.isRemote) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Let me ALONE !!!"), (true));
		}
	}
}
