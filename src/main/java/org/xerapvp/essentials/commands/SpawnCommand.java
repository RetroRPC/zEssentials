package org.xerapvp.essentials.commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.xerapvp.essentials.Core;
import org.xerapvp.essentials.utils.ChatUtils;
import org.xerapvp.essentials.utils.Title;

/**
 * @author RetroRPC
 * Copyright @ RetroRPC
 */

public class SpawnCommand {

    @Command(name = "spawn", inGameOnly = true)

    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        if (player.hasPermission("core.spawnbypass")) {
            player.sendMessage(ChatUtils.translate("&6&l(!) &6Please wait while we teleport you. &7[Bypassing]"));
            player.teleport(Core.instance.getSpawnLocation());
            Title.playSuccessful(player);

        } else {

            player.sendMessage(ChatUtils.translate("&6&l(!) &6Please wait while we teleport you. &7[7 Seconds]"));
            Core.instance.player_teleport.put(player.getUniqueId(), player.getLocation());


            Bukkit.getScheduler().runTaskLater(Core.instance, new Runnable() {
                @Override
                public void run() {
                    if (!Core.instance.player_teleport.containsKey(player.getUniqueId())) {
                        return;
                    } else {
                        Core.instance.player_teleport.remove(player.getUniqueId());
                        player.teleport(Core.instance.getSpawnLocation());
                        Title.playSuccessful(player);
                    }
                }
            }, 140L);
        }
    }
}
