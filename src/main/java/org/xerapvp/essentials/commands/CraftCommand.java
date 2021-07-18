package org.xerapvp.essentials.commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import org.bukkit.entity.Player;
import org.xerapvp.essentials.utils.ChatUtils;

/**
 * @author RetroRPC
 * Copyright @ RetroRPC
 */

public class CraftCommand {


    @Command(name = "craft", inGameOnly = true)

    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        player.openWorkbench(player.getLocation(), true);

    }
}
