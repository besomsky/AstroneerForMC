
package net.mcreator.more_tools.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.more_tools.block.CombinerBlock;
import net.mcreator.more_tools.MoreToolsElements;

@MoreToolsElements.ModElement.Tag
public class AstroneerItemGroup extends MoreToolsElements.ModElement {
	public AstroneerItemGroup(MoreToolsElements instance) {
		super(instance, 116);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabastroneer") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(CombinerBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
