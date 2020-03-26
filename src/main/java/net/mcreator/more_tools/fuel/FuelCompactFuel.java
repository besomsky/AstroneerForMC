
package net.mcreator.more_tools.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.more_tools.item.FuelCompact1Item;
import net.mcreator.more_tools.MoreToolsElements;

@MoreToolsElements.ModElement.Tag
public class FuelCompactFuel extends MoreToolsElements.ModElement {
	public FuelCompactFuel(MoreToolsElements instance) {
		super(instance, 124);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(FuelCompact1Item.block, (int) (1)).getItem())
			event.setBurnTime(2700);
	}
}
