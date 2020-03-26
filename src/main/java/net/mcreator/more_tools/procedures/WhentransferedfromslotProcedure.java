package net.mcreator.more_tools.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.more_tools.MoreToolsElements;

@MoreToolsElements.ModElement.Tag
public class WhentransferedfromslotProcedure extends MoreToolsElements.ModElement {
	public WhentransferedfromslotProcedure(MoreToolsElements instance) {
		super(instance, 20);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Whentransferedfromslot!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).giveExperiencePoints((int) 5);
	}
}
