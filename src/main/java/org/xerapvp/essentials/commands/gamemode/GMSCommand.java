package org.xerapvp.essentials.commands.gamemode;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

/**
 * @author RetroRPC
 * Copyright @ RetroRPC
 */

public class GMSCommand {

    @Command(name = "gms", inGameOnly = true, permission = "core.gmc")

    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        player.setGameMode(GameMode.SURVIVAL);
    }
}
