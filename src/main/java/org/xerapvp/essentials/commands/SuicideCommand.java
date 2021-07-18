package org.xerapvp.essentials.commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import org.bukkit.entity.Player;
import org.xerapvp.essentials.utils.ChatUtils;

/**
 * @author RetroRPC
 * Copyright @ RetroRPC
 */

public class SuicideCommand {

    @Command(name = "suicide", inGameOnly = true)

    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        player.setHealth(0);
        player.sendMessage(ChatUtils.translate("&6&l/Suicide: &6You have killed your self."));

    }
}
