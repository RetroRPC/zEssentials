package org.xerapvp.essentials.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Hopper;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftItem;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.world.PortalCreateEvent;
import org.bukkit.inventory.ItemStack;
import org.xerapvp.essentials.Core;
import org.xerapvp.essentials.utils.ChatUtils;

/**
 * @author RetroRPC
 * Copyright @ RetroRPC
 */

public class WorldListener implements Listener {

    /*@EventHandler
    public void onTntExplode(BlockIgniteEvent event) {
        event.setCancelled(true);
        event.getPlayer().sendMessage(ChatUtils.translate("&c&l(!) &cYou cannot ignite blocks."));
    }*/

    @EventHandler
    public void onEntityAttack(EntityTargetEvent event) {
        Entity entity = event.getEntity();

        if (!event.getEntity().hasMetadata("mob") && entity instanceof Creeper || entity instanceof Zombie || entity instanceof Skeleton || entity instanceof Blaze || entity instanceof  Spider) {
            event.setCancelled(true);
        }
    }


    @EventHandler
    public void onPortalCreate (PortalCreateEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onPortalEnter (PlayerTeleportEvent event) {
        Player player = event.getPlayer();
        if (event.getCause().equals(PlayerTeleportEvent.TeleportCause.NETHER_PORTAL)) {
            event.setCancelled(true);
            player.sendMessage(ChatUtils.translate("&c&l(!) &cYou cannot travel through portals"));
        }
    }

    @EventHandler
    public void onPlayerSleep (PlayerBedEnterEvent event) {
        event.setCancelled(true);
        Player player = event.getPlayer();
        player.sendMessage(ChatUtils.translate("&c&l(!) &cYou cannot sleep on this server."));
    }

    @EventHandler
    public void onPlayerCraft (CraftItemEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getRecipe().getResult().getType() == Material.HOPPER) {
            event.setCancelled(true);
            player.sendMessage(ChatUtils.translate("&c&l(!) &cYou cannot craft Hoppers."));
        }
    }

    @EventHandler
    public void onPlayerVoidFall (PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (player.getLocation().getY() < 0 && player.getLocation().getWorld().getName().equals("world")) {
            player.teleport(Core.instance.getSpawnLocation());
            player.sendMessage(ChatUtils.translate("&a&l(!) &aYou have been saved from the void"));
            player.playSound(player.getLocation(), Sound.WITHER_IDLE, 1.0f, 1.0f);
        }
    }


    @EventHandler
    public void onBoatInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.hasItem() && event.getItem().getType() == Material.BOAT && (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            player.sendMessage(ChatUtils.translate("&c&l(!) &CYou cannot interact with boats."));
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerFall (EntityDamageEvent event) {
        if (event.getCause().equals(EntityDamageEvent.DamageCause.FALL) && event.getEntity() instanceof Player) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerPlace (BlockPlaceEvent event) {
        Player player = event.getPlayer();

        Location location = event.getPlayer().getLocation();

        if (!player.isOp() && location.getWorld().equals("world") || location.getWorld().equals("world_nether") || location.getWorld().equals("world_the_end")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerBreak (BlockBreakEvent event) {
        Player player = event.getPlayer();

        Location location = event.getPlayer().getLocation();

        if (!player.isOp() && location.getWorld().equals("world") || location.getWorld().equals("world_nether") || location.getWorld().equals("world_the_end")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void antiNether (PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (player.getLocation().getWorld().equals("world_nether")) {
            player.teleport(Core.instance.getSpawnLocation());
            player.sendMessage(ChatUtils.translate("&c&l(!) You are not allowed in the nether"));
        }
    }






}
