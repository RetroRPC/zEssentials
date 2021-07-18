package org.xerapvp.essentials.commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.xerapvp.essentials.Core;
import org.xerapvp.essentials.manager.SpawnManager;

/**
 * @author RetroRPC
 * Copyright @ RetroRPC
 */

public class SetSpawnCommand {


    @Command(name = "setspawn",permission = "core.setspawn",inGameOnly = true)
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        Core.instance.getConfig().set("spawn", SpawnManager.saveLocationToSection(player.getLocation(), Core.instance.getConfig().getConfigurationSection("spawn")));
        Core.instance.saveConfig();
        Core.instance.reloadConfig();
        SpawnManager.onEnable();
        player.sendMessage(ChatColor.GREEN + "You have successfully set the spawn point.");
    }
}
