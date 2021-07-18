package org.xerapvp.essentials.manager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.xerapvp.essentials.Core;

/**
 * @author RetroRPC
 * Copyright @ RetroRPC
 */

public class SpawnManager {
    public static void onEnable() {
        Core.instance.saveDefaultConfig();
        Core.instance.setSpawnLocation(SpawnManager.buildLocationFromSection(Core.instance.getConfig().getConfigurationSection("spawn")));
    }

    public static Location buildLocationFromSection(ConfigurationSection section) {
        Location toReturn = new Location(Bukkit.getWorld(section.getString("world")), section.getDouble("x"), section.getDouble("y"), section.getDouble("z"));
        toReturn.setYaw((float) section.getDouble("yaw"));
        toReturn.setPitch((float) section.getDouble("pitch"));
        return toReturn;
    }

    public static ConfigurationSection saveLocationToSection(Location location, ConfigurationSection section) {
        section.set("world", location.getWorld().getName());
        section.set("x", location.getX());
        section.set("y", location.getY());
        section.set("z", location.getZ());
        section.set("yaw", location.getYaw());
        section.set("pitch", location.getPitch());
        return section;
    }
}
