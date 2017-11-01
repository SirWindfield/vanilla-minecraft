package de.zerotask.minecraft.vanillatools.handler;

import mcjty.lib.tools.ItemStackTools;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * The event handler used to disable vanilla bows.
 *
 * @author Sven Lechner (SirWindfield)
 * @version 1.0
 */
public class BowHandler {

    /**
     * Gets called each time a player starts to use a bow.
     *
     * @param event The event.
     */
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onItemUsage(PlayerInteractEvent.RightClickItem event) {
        // TODO: not sure if machines can trigger this event
        EntityPlayer player = event.getEntityPlayer();
        if (player != null) {
            ItemStack bow = player.getHeldItemMainhand();
            if (!ItemStackTools.isEmpty(bow)) {
                if (bow.getItem() instanceof ItemBow) {
                    event.setCanceled(true);
                }
            }
        }
    }
}