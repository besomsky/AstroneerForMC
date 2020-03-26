
package net.mcreator.more_tools.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.more_tools.itemgroup.AstroneerItemGroup;
import net.mcreator.more_tools.MoreToolsElements;

@MoreToolsElements.ModElement.Tag
public class LateritePickaxeItem extends MoreToolsElements.ModElement {
	@ObjectHolder("more_tools:lateritepickaxe")
	public static final Item block = null;
	public LateritePickaxeItem(MoreToolsElements instance) {
		super(instance, 34);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 500;
			}

			public float getEfficiency() {
				return 6.5f;
			}

			public float getAttackDamage() {
				return 0f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(LateriteIngotItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(AstroneerItemGroup.tab)) {
		}.setRegistryName("lateritepickaxe"));
	}
}
