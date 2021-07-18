package org.xerapvp.essentials.commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.xerapvp.essentials.utils.ChatUtils;

/**
 * @author RetroRPC
 * Copyright @ RetroRPC
 */

public class TopCommand {

    public Location location(Location location) {
        return new Location(location.getWorld(), location.getX(), location.getWorld().getHighestBlockYAt(location.getBlockX(), location.getBlockZ()), location.getZ(), location.getYaw(), location.getPitch());
    }

    @Command(name = "top", inGameOnly = true, permission = "core.top")
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        if (player.getLocation().getY() > 255) {
            player.sendMessage(ChatUtils.translate("&cInvalid Location."));
        } else {
            player.teleport(location(player.getLocation()));
            player.sendMessage(ChatUtils.translate("&6&L/Top:&6 You have teleported to the highest point."));
        }
    }
}
