package net.mcreator.more_tools.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.more_tools.MoreToolsElements;

@MoreToolsElements.ModElement.Tag
public class TestMobplayerCollidesWithPlantProcedure extends MoreToolsElements.ModElement {
	public TestMobplayerCollidesWithPlantProcedure(MoreToolsElements instance) {
		super(instance, 119);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TestMobplayerCollidesWithPlant!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 20, (int) 2));
	}
}
