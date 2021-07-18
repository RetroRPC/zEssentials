package org.xerapvp.essentials.commands.tpa;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.xerapvp.essentials.Core;

import java.util.UUID;

/**
 * @author RetroRPC
 * Copyright @ RetroRPC
 */

public class TpaAcceptCommand {

    @Command(name = "tpaccept", inGameOnly = true)
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();
        Player target = Bukkit.getPlayer(args[0]);


        if (Core.instance.tpa_request.containsKey(player.getUniqueId())) {


        }


    }

}
