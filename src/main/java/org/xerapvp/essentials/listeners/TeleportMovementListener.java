package org.xerapvp.essentials.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.xerapvp.essentials.Core;
import org.xerapvp.essentials.utils.ChatUtils;
import org.xerapvp.essentials.utils.Title;

/**
 * @author RetroRPC
 * Copyright @ RetroRPC
 */

public class TeleportMovementListener implements Listener {


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (Core.instance.player_teleport.containsKey(player.getUniqueId())) {
            if (Core.instance.player_teleport.get(player.getUniqueId()) == null && player.getLocation() == null) {
                Core.instance.player_teleport.remove(player.getUniqueId());
                Title.playTitle(player);

                player.sendMessage(ChatUtils.translate("&c&l(!) &cYour teleport request has been canceled due to movement."));
                return;
            }
            if (Core.instance.player_teleport.get(player.getUniqueId()).distance(player.getLocation()) > 2.0) {
                Core.instance.player_teleport.remove(player.getUniqueId());
                Title.playTitle(player);
                player.sendMessage(ChatUtils.translate("&c&l(!) &cYour teleport request has been canceled due to movement."));
            }
        }
    }

    /*@EventHandler
    public void onPlayerDamage (EntityDamageEvent event) {
        Player player = (Player) event.getEntity();
        if (event.getEntity() instanceof Player && Core.player_teleport.containsKey(player.getUniqueId()) && event.getDamage() > 0.0) {
            Core.player_teleport.remove(player.getUniqueId());
            Title.playTitle(player);

            player.sendMessage(ChatUtils.translate("&c&L(!) &CYour teleport request has been canceled due to combat."));
        }*/

}
