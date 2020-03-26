
package net.mcreator.more_tools.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.more_tools.itemgroup.AstroneerItemGroup;
import net.mcreator.more_tools.MoreToolsElements;

@MoreToolsElements.ModElement.Tag
public class ZincSwordItem extends MoreToolsElements.ModElement {
	@ObjectHolder("more_tools:zincsword")
	public static final Item block = null;
	public ZincSwordItem(MoreToolsElements instance) {
		super(instance, 57);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 700;
			}

			public float getEfficiency() {
				return 7f;
			}

			public float getAttackDamage() {
				return 6f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(ZincIngotItem.block, (int) (1)));
			}
		}, 3, -2.3f, new Item.Properties().group(AstroneerItemGroup.tab)) {
		}.setRegistryName("zincsword"));
	}
}
