package org.xerapvp.essentials.commands.economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.xerapvp.essentials.Core;

public class EconomyCommands implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (command.getName().equalsIgnoreCase("econo")) {

                if (!Core.instance.playerBank.containsKey(player.getUniqueId())) {
                    Core.instance.playerBank.put(player.getUniqueId(), 0.0);
                }

                int balance = (int) Core.instance.economyImplementer.getBalance(player);
                player.sendMessage(ChatColor.GREEN + player.getName() + " §7has §a$" + balance + "§7 in their account");

            return true;
            }
        }
        return true;

    }
}
