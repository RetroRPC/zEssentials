package org.xerapvp.essentials.commands.gamemode;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.xerapvp.essentials.utils.ChatUtils;

import java.util.Locale;

/**
 * @author RetroRPC
 * Copyright @ RetroRPC
 */

public class GamemodeCommand {


    @Command(name = "gamemode", aliases = {"gm", "mode"}, permission = "core.gamemode")
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();


        if (args.length < 1 && !player.hasPermission("core.gamemode")) {
            player.sendMessage(ChatUtils.no_perm);
            return;
        }

        if (args.length < 1 && player.hasPermission("core.gamemode")) {
            player.sendMessage(ChatUtils.translate("&cUsage: /gamemode <mode> <player>"));
            return;
        }

        if (args.length == 1) {
            switch (args[0].toLowerCase()) {
                case "0":
                case "survival": {
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(ChatUtils.translate("&6You have updated your gamemode to &f"+ player.getGameMode() + "&6."));
                    break;
                }
                case "1":
                case "creative": {
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(ChatUtils.translate("&6You have updated your gamemode to &f"+ player.getGameMode() + "&6."));
                    break;
                }
                case "2":
                case "adventure": {
                    player.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage(ChatUtils.translate("&6You have updated your gamemode to &f"+ player.getGameMode() + "&6."));
                    break;
                }
                case "3":
                case "spectator": {
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage(ChatUtils.translate("&6You have updated your gamemode to &f"+ player.getGameMode() + "&6."));
                    break;
                }
            }

        } else if (args.length == 2) {
            Player target = Bukkit.getPlayer(args[1]);
            if (target != null) {
                if (target == player) {
                    player.sendMessage(ChatUtils.translate("&cYou cannot set this players gamemode."));
                    return;
                }
                switch (args[0].toLowerCase()) {
                    case "0":
                    case "survival": {
                        target.setGameMode(GameMode.SURVIVAL);
                        target.sendMessage(ChatUtils.translate("&6Your gamemode has been updated to &f" + target.getGameMode() + "&6."));
                        player.sendMessage(ChatUtils.translate("&6You have updated " + target.getName() + "'s gamemode to &f" + target.getGameMode() + "&6."));
                        break;
                    }
                    case "1":
                    case "creative": {
                        target.setGameMode(GameMode.CREATIVE);
                        target.sendMessage(ChatUtils.translate("&6Your gamemode has been updated to &f" + target.getGameMode() + "&6."));
                        player.sendMessage(ChatUtils.translate("&6You have updated " + target.getName() + "'s gamemode to &f" + target.getGameMode() + "&6."));
                        break;
                    }
                    case "2":
                    case "adventure": {
                        target.setGameMode(GameMode.ADVENTURE);
                        target.sendMessage(ChatUtils.translate("&6Your gamemode has been updated to &f" + target.getGameMode() + "&6."));
                        player.sendMessage(ChatUtils.translate("&6You have updated " + target.getName() + "'s gamemode to &f" + target.getGameMode() + "&6."));
                        break;
                    }
                    case "3":
                    case "specator": {
                        target.setGameMode(GameMode.SPECTATOR);
                        target.sendMessage(ChatUtils.translate("&6Your gamemode has been updated to &f " + target.getGameMode() + "&6."));
                        player.sendMessage(ChatUtils.translate("&6You have updated " + target.getName() + "'s gamemode to &f" + target.getGameMode() + "&6."));
                        break;
                    }
                }
            } else {
                player.sendMessage(ChatUtils.translate(ChatUtils.exist));
            }
        }
    }
}

