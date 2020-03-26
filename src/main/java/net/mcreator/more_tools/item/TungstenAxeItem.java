
package net.mcreator.more_tools.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.more_tools.itemgroup.AstroneerItemGroup;
import net.mcreator.more_tools.MoreToolsElements;

@MoreToolsElements.ModElement.Tag
public class TungstenAxeItem extends MoreToolsElements.ModElement {
	@ObjectHolder("more_tools:tungstenaxe")
	public static final Item block = null;
	public TungstenAxeItem(MoreToolsElements instance) {
		super(instance, 77);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 1500;
			}

			public float getEfficiency() {
				return 8f;
			}

			public float getAttackDamage() {
				return 9f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(TungstenIngotItem.block, (int) (1)));
			}
		}, 1, -2.5f, new Item.Properties().group(AstroneerItemGroup.tab)) {
		}.setRegistryName("tungstenaxe"));
	}
}
