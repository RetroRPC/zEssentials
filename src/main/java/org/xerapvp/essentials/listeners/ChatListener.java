package org.xerapvp.essentials.listeners;

import me.happy.core.CoreAPI;
import me.happy.core.rank.Rank;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.xerapvp.essentials.utils.ChatUtils;

/**
 * @author RetroRPC
 * Copyright @ RetroRPC
 */

public class ChatListener implements Listener {


    @EventHandler(priority = EventPriority.MONITOR)
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        Rank rank = CoreAPI.getRank(player.getUniqueId());
        event.setFormat(ChatUtils.translate(rank.getPrefix() + " " + player.getName() + "&7: " + event.getMessage()));


    }
}
