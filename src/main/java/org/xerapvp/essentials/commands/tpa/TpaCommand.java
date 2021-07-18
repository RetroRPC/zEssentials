package org.xerapvp.essentials.commands.tpa;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.happy.core.CoreAPI;
import me.happy.core.rank.Rank;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.xerapvp.essentials.Core;
import org.xerapvp.essentials.utils.ChatUtils;

/**
 * @author RetroRPC
 * Copyright @ RetroRPC
 */

public class TpaCommand {

    @Command(name = "tpa", inGameOnly = true)
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();


        if (args.length > 0) {
            Player target = Bukkit.getPlayer(args[0]);

            if (target != null) {
                if (target == player) {
                    player.sendMessage(ChatUtils.translate("&C&l(!) &CYou cannot send a teleport request to that player."));
                    return;
                }

                if (!Core.instance.tpa_request.containsKey(player.getUniqueId())) {
                    Rank rank = CoreAPI.getRank(player.getUniqueId());
                    player.sendMessage(ChatUtils.translate("&a&l(!) &aYou have sent a tpa request to &f" + target.getName() + "&a."));
                    Core.instance.tpa_request.put(player.getUniqueId(), target.getUniqueId());

                    target.sendMessage(ChatUtils.translate("&6&l[/TPA] " + "&7&l(&r" + rank.getPrefix() + " " + player.getName()  + "&7&l) &6Has sent a teleport request."));
                    target.sendMessage(ChatUtils.translate("&eTo Accept, type: &a/tpaccept " + player.getName()));
                    target.sendMessage(ChatUtils.translate("&eTo deny, type: &c/tpadeny " + player.getName()));
                    target.sendMessage(ChatUtils.translate("&eThis tp request will expire in &f10 seconds&e."));

                    Bukkit.getScheduler().runTaskLater(Core.instance, new Runnable() {
                        @Override
                        public void run() {
                            if (Core.instance.tpa_request.containsKey(player.getUniqueId())) {
                                Core.instance.tpa_request.remove(player.getUniqueId());
                                player.sendMessage(ChatUtils.translate("&c&l(!) &cYour tpa request has expired."));
                            }
                        }
                    }, 200L);

                } else {
                    player.sendMessage(ChatUtils.translate("&C&l(!) &cYou already have a outgoing tpa request, type /tpacancel to remove it."));
                }

            }
        } else {
            player.sendMessage(ChatUtils.translate("&6&l(!) &6Request to teleport to a specific player."));
            player.sendMessage(ChatUtils.translate("&6/tpa <player>"));
        }



    }
}
