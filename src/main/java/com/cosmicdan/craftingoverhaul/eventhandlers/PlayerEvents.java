package com.cosmicdan.craftingoverhaul.eventhandlers;

import com.cosmicdan.craftingoverhaul.Data.CraftingType;
import com.cosmicdan.craftingoverhaul.Main;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.block.Block;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

// Player events
public class PlayerEvents {
    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent event) {
    	// check if override crafting table is enabled
        if (event.action == Action.RIGHT_CLICK_BLOCK) {
        	Block blockUsed = event.world.getBlock(event.x, event.y, event.z);
        	if (blockUsed instanceof net.minecraft.block.BlockWorkbench) {
        		//System.out.println("Player used crafting table!");
        	    Main.proxy.openCraftingGui(event.entityPlayer, CraftingType.VANILLA_WORKBENCH);
        		event.setCanceled(true);
        	}
        }
    }
}
