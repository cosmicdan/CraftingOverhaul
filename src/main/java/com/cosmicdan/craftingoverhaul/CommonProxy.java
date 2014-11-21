package com.cosmicdan.craftingoverhaul;

import com.cosmicdan.craftingoverhaul.Data.CraftingType;
import com.cosmicdan.craftingoverhaul.eventhandlers.EntityEvents;
import com.cosmicdan.craftingoverhaul.eventhandlers.PlayerEvents;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class CommonProxy {
    
    public void preInit(FMLPreInitializationEvent event) {
        
    }
    
    public void init(FMLInitializationEvent event) {
        
    }
    
    public void postInit(FMLPostInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new EntityEvents());
        MinecraftForge.EVENT_BUS.register(new PlayerEvents());
    }
    
    public void buildRecipeData(EntityPlayer player) {}
    
    public void openCraftingGui(EntityPlayer player, CraftingType craftingType) {}
    
    public EntityPlayer getPlayerFromMessageContext(MessageContext ctx) {
        switch(ctx.side) {
            case CLIENT:
                assert false : "Message for CLIENT received on dedicated server";
                break;
            case SERVER:
                EntityPlayer entityPlayerMP = ctx.getServerHandler().playerEntity;
                return entityPlayerMP;
            default:
                assert false : "Invalid side in TestMsgHandler: " + ctx.side;
        }
        return null;
    }
}