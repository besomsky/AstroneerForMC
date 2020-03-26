
package net.mcreator.more_tools.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.Entity;

import net.mcreator.more_tools.itemgroup.AstroneerItemGroup;
import net.mcreator.more_tools.MoreToolsElements;

@MoreToolsElements.ModElement.Tag
public class Copper_ArmorArmorItem extends MoreToolsElements.ModElement {
	@ObjectHolder("more_tools:copper_armorarmorhelmet")
	public static final Item helmet = null;
	@ObjectHolder("more_tools:copper_armorarmorbody")
	public static final Item body = null;
	@ObjectHolder("more_tools:copper_armorarmorlegs")
	public static final Item legs = null;
	@ObjectHolder("more_tools:copper_armorarmorboots")
	public static final Item boots = null;
	public Copper_ArmorArmorItem(MoreToolsElements instance) {
		super(instance, 23);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 17;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 7, 6, 2}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 12;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(MalachiteIngotItem.block, (int) (1)));
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "copper_armorarmor";
			}

			public float getToughness() {
				return 0.5f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(AstroneerItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "more_tools:textures/models/armor/copper_armor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("copper_armorarmorhelmet"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(AstroneerItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "more_tools:textures/models/armor/copper_armor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("copper_armorarmorbody"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(AstroneerItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "more_tools:textures/models/armor/copper_armor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("copper_armorarmorlegs"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(AstroneerItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "more_tools:textures/models/armor/copper_armor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("copper_armorarmorboots"));
	}
}
