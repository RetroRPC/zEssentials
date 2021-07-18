package org.xerapvp.essentials.listeners;

import me.happy.core.CoreAPI;
import me.happy.core.rank.Rank;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.xerapvp.essentials.Core;
import org.xerapvp.essentials.utils.ChatUtils;
import org.xerapvp.essentials.utils.Title;
import sun.applet.Main;

/**
 * @author RetroRPC
 * Copyright @ RetroRPC
 */

public class JoinListener implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(null);

        for (int i = 0; i < 50; ++i) {
            player.sendMessage("");
        }


       ChatUtils.sendCenteredMessage(player, "&fWelcome to &6&lXeraPvP");
        ChatUtils.sendCenteredMessage(player, "&nCompete&7 to Become the &nRichest&7 Skyblock Island!");
        player.sendMessage(ChatUtils.translate(""));
        ChatUtils.sendCenteredMessage(player, "&6&lStore: &f&nbuy.xerapvp.org");
        ChatUtils.sendCenteredMessage(player, "&6&lDiscord: &f&ndiscord.xerapvp.org");
        player.sendMessage(ChatUtils.translate(""));
        ChatUtils.sendCenteredMessage(player, ("&e&lRecommended Version: &f&n1.8.8"));
        player.sendMessage(ChatUtils.translate(""));

        player.playSound(player.getLocation(), Sound.ENDERDRAGON_WINGS, 1.0f, 1.0f);

        Title title = new Title("&a&lCastaway Realm", "&7&o((You have connected to &fSkyblock&7&o))", 20, 40, 20);
        title.setTimingsToTicks();
        title.send(player);
    }


    @EventHandler
    public void onFirstJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Rank rank = CoreAPI.getRank(player.getUniqueId());

        if (!player.hasPlayedBefore()) {
            player.teleport(Core.instance.getSpawnLocation());
            Bukkit.broadcastMessage(ChatUtils.translate("&7Welcome " + rank.getPrefix() + " " + player.getName() + "&r &7to the &a&lCastaway Realm&7. &7(#" + (Bukkit.getOfflinePlayers().length) + ")"));
        }
    }

}
