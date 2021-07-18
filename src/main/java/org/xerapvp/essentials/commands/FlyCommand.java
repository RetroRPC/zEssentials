package org.xerapvp.essentials.commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import org.bukkit.entity.Player;
import org.xerapvp.essentials.utils.ChatUtils;

/**
 * @author RetroRPC
 * Copyright @ RetroRPC
 */

public class FlyCommand {

    @Command(name = "fly", inGameOnly = true, permission = "core.fly")

    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        boolean newFlight = !player.getAllowFlight();
        player.setAllowFlight(newFlight);
        if(newFlight){
            player.setFlying(true);
        }

            player.sendMessage(ChatUtils.translate("&6Your flight has been set to &f" + newFlight +"&6."));
        }

    }

