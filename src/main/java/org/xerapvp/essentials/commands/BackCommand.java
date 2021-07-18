package org.xerapvp.essentials.commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.xerapvp.essentials.Core;
import org.xerapvp.essentials.utils.ChatUtils;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author RetroRPC
 * Copyright @ RetroRPC
 */

public class BackCommand {

    @Command(name = "back", aliases = {"deathpoint", "dp"}, inGameOnly = true, permission = "core.back")
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        if (Core.instance.death_locations.containsKey(player.getUniqueId())) {
            Location location = Core.instance.death_locations.get(player.getUniqueId());


            if (!location.getWorld().getName().equals("world")) {
                player.sendMessage(ChatUtils.translate("&c&l(!) &cYou cannot return back to your deathpoint."));
                return;
            }
            if (location.getBlock().getType() == Material.WATER || location.getBlock().getType() == Material.LAVA || location.getBlock().getType() == Material.STATIONARY_WATER) {
                player.sendMessage(ChatUtils.translate("&c&l(!) &cSomething is blocking your deathpoint."));
                return;
            }
            if (player.teleport(location, PlayerTeleportEvent.TeleportCause.PLUGIN)) {
                Core.instance.death_locations.remove(player.getUniqueId());
                player.sendMessage(ChatUtils.translate("&6&L/Back: &6You have returned to your last point of death."));
                return;
            }
        } else {
            player.sendMessage(ChatUtils.translate("&c&l(!) &cYou cannot /back since your deathpoint is invalid."));
        }
    }
}
