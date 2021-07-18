package org.xerapvp.essentials.commands.tpa;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import org.bukkit.entity.Player;

/**
 * @author RetroRPC
 * Copyright @ RetroRPC
 */

public class TpaDenyCommand {

    @Command(name = "tpadeny", aliases = "tpdeny", inGameOnly = true)
    public void onComamnd(CommandArgs command) {
        Player player = command.getPlayer();


    }
}
