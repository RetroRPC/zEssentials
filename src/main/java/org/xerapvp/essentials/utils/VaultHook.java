package org.xerapvp.essentials.utils;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.ServicePriority;
import org.xerapvp.essentials.Core;

/**
 * @author RetroRPC
 * Copyright @ RetroRPC
 */

public class VaultHook {


    private Economy provider;

    public void hook() {
        provider = Core.instance.economyImplementer;
        Bukkit.getServicesManager().register(Economy.class, this.provider, Core.instance, ServicePriority.Normal);
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "VaultAPI hooked into " + ChatColor.AQUA + Core.instance.getName());
    }

    public void unhook() {
        Bukkit.getServicesManager().unregister(Economy.class, this.provider);
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "VaultAPI unhooked from " + ChatColor.AQUA + Core.instance.getName());

    }
}