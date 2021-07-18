package org.xerapvp.essentials.commands.tpa;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import org.bukkit.entity.Player;
import org.xerapvp.essentials.Core;
import org.xerapvp.essentials.utils.ChatUtils;

/**
 * @author RetroRPC
 * Copyright @ RetroRPC
 */

public class TpaCancelCommand {

    @Command(name = "tpacancel", aliases = { "tpcancel"}, inGameOnly = true)

    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();


        if (Core.instance.tpa_request.containsKey(player.getUniqueId())) {
            player.sendMessage(ChatUtils.translate("&a&l(!) &AYour tpa request has been canceled."));
            Core.instance.tpa_request.remove(player.getUniqueId());
        } else {
            player.sendMessage(ChatUtils.translate("&c&l(!) &cYou have no outgoing tpa requests."));
        }

    }
}
