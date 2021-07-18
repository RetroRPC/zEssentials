package org.xerapvp.essentials.commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.xerapvp.essentials.utils.ChatUtils;

import java.lang.annotation.Target;

/**
 * @author RetroRPC
 * Copyright @ RetroRPC
 */

public class FeedCommand {

    @Command(name = "feed", aliases = {"feedme", "eat"}, permission = "core.feed")
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();


        if (args.length == 0) {
            player.setFoodLevel(20);
            player.sendMessage(ChatUtils.translate("&6&L/Feed: &6You have successfully fed your self."));
            player.playSound(player.getLocation(), Sound.EAT, 1.0f, 1.0f);
            return;
        }

        if (player.hasPermission("core.feed.other")) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == player) {
                player.sendMessage(ChatUtils.translate("&cYou cannot feed this player."));
                return;
            }
            if (target != null) {
                target.setFoodLevel(20);
                player.sendMessage(ChatUtils.translate("&6&l(!) &6You have fed &f" + target.getName() + "&6."));
                target.sendMessage(ChatUtils.translate("&6&L/Feed: &6You have successfully fed your self."));
                target.playSound(player.getLocation(), Sound.EAT, 1.0f, 1.0f);

            } else {
                player.sendMessage(ChatUtils.translate(ChatUtils.exist));
            }

        }
    }
}
