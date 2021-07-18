package org.xerapvp.essentials.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.xerapvp.essentials.Core;

/**
 * @author RetroRPC
 * Copyright @ RetroRPC
 */

public class DeathListener implements Listener {


    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        Location location = player.getLocation();
        event.setDeathMessage(null);
        Core.instance.death_locations.put(player.getUniqueId(), location);


    }
}
