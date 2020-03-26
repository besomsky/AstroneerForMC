
package net.mcreator.more_tools.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.world.IWorldReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.BlockState;

import net.mcreator.more_tools.procedures.Portaltestnur1PlayerCollidesWithThisEntityProcedure;
import net.mcreator.more_tools.itemgroup.AstroneerItemGroup;
import net.mcreator.more_tools.MoreToolsElements;

@MoreToolsElements.ModElement.Tag
public class Portaltestnur1Entity extends MoreToolsElements.ModElement {
	public static EntityType entity = null;
	public Portaltestnur1Entity(MoreToolsElements instance) {
		super(instance, 126);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.AMBIENT).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire().size(0.1f, 10f))
						.build("portaltestnur1").setRegistryName("portaltestnur1");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -27534, -65452, new Item.Properties().group(AstroneerItemGroup.tab))
				.setRegistryName("portaltestnur1"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(CustomEntity.class, renderManager -> {
			return new MobRenderer(renderManager, new ModelPortal(), 0.4f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("more_tools:textures/finalstage.png");
				}
			};
		});
	}
	public static class CustomEntity extends CreatureEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 5;
			setNoAI(true);
			enablePersistence();
			this.moveController = new FlyingMovementController(this);
			this.navigator = new FlyingPathNavigator(this, this.world);
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("more_tools:sylvaportalsound"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public void fall(float l, float d) {
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof ArrowEntity)
				return false;
			if (source.getImmediateSource() instanceof PotionEntity)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			if (source == DamageSource.LIGHTNING_BOLT)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public void onCollideWithPlayer(PlayerEntity entity) {
			super.onCollideWithPlayer(entity);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				Portaltestnur1PlayerCollidesWithThisEntityProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
			this.getAttributes().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
			this.getAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0);
		}

		@Override
		public boolean canBreatheUnderwater() {
			return true;
		}

		@Override
		public boolean isNotColliding(IWorldReader worldreader) {
			return worldreader.checkNoEntityCollision(this);
		}

		@Override
		public boolean isPushedByWater() {
			return false;
		}

		@Override
		protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
		}

		public void livingTick() {
			super.livingTick();
			this.setNoGravity(true);
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	// Make sure to generate all required imports
	public static class ModelPortal extends EntityModel<Entity> {
		private final RendererModel bone;
		private final RendererModel bone2;
		public ModelPortal() {
			textureWidth = 64;
			textureHeight = 64;
			bone = new RendererModel(this);
			bone.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone.cubeList.add(new ModelBox(bone, 0, 0, -2.0F, -1.0F, -6.0F, 3, 1, 11, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 0, -2.0F, -8.0F, 5.0F, 3, 7, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 17, 0, -2.0F, -13.0F, 6.0F, 3, 5, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 34, 18, -2.0F, -24.0F, 7.0F, 3, 11, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 22, 18, -2.0F, -4.0F, -7.0F, 3, 3, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 8, 37, -2.0F, -25.0F, 3.0F, 3, 1, 4, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 36, 12, -2.0F, -24.0F, -1.0F, 3, 1, 4, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 17, 6, -2.0F, -23.0F, -3.0F, 3, 1, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 18, 12, -2.0F, -22.0F, -4.0F, 3, 3, 1, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 0, 8, -2.0F, -19.0F, -6.0F, 3, 1, 2, 0.0F, false));
			bone.cubeList.add(new ModelBox(bone, 26, 26, -2.0F, -18.0F, -7.0F, 3, 14, 1, 0.0F, false));
			bone2 = new RendererModel(this);
			bone2.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone2.cubeList.add(new ModelBox(bone2, 0, 12, -1.0F, -23.0F, 0.0F, 1, 22, 5, 0.0F, false));
			bone2.cubeList.add(new ModelBox(bone2, 26, 22, -1.0F, -24.0F, 3.0F, 1, 1, 2, 0.0F, false));
			bone2.cubeList.add(new ModelBox(bone2, 18, 18, -1.0F, -23.0F, -1.0F, 1, 22, 1, 0.0F, false));
			bone2.cubeList.add(new ModelBox(bone2, 12, 12, -1.0F, -22.0F, -3.0F, 1, 21, 2, 0.0F, false));
			bone2.cubeList.add(new ModelBox(bone2, 22, 22, -1.0F, -19.0F, -4.0F, 1, 18, 1, 0.0F, false));
			bone2.cubeList.add(new ModelBox(bone2, 28, 0, -1.0F, -18.0F, -5.0F, 1, 17, 1, 0.0F, false));
			bone2.cubeList.add(new ModelBox(bone2, 32, 0, -1.0F, -18.0F, -6.0F, 1, 17, 1, 0.0F, false));
			bone2.cubeList.add(new ModelBox(bone2, 38, 38, -1.0F, -24.0F, 6.0F, 1, 11, 1, 0.0F, false));
			bone2.cubeList.add(new ModelBox(bone2, 34, 34, -1.0F, -24.0F, 5.0F, 1, 16, 1, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			bone.render(f5);
			bone2.render(f5);
		}

		public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}
