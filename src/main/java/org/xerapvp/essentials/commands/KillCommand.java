package org.xerapvp.essentials.commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.xerapvp.essentials.utils.ChatUtils;

/**
 * @author RetroRPC
 * Copyright @ RetroRPC
 */

public class KillCommand {

    @Command(name = "kill", permission = "core.kill")

    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();


        if (args.length < 1 ) {
            player.sendMessage(ChatUtils.translate("&cUsage: /kill <player>"));
            return;
        }


        Player target = Bukkit.getPlayer(args[0]);

        if (target != null) {
            target.setHealth(0.0);
            player.sendMessage(ChatUtils.translate("&a&l(!) &AYou killed " + player.getName() + "."));
        } else {
            player.sendMessage(ChatUtils.exist);
        }

    }
}
