package org.xerapvp.essentials;

import com.minnymin.command.CommandFramework;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.xerapvp.essentials.commands.*;
import org.xerapvp.essentials.commands.economy.EconomyCommands;
import org.xerapvp.essentials.commands.gamemode.GMCCommand;
import org.xerapvp.essentials.commands.gamemode.GMSCommand;
import org.xerapvp.essentials.commands.gamemode.GMSPCommand;
import org.xerapvp.essentials.commands.gamemode.GamemodeCommand;
import org.xerapvp.essentials.commands.tpa.TpaCommand;
import org.xerapvp.essentials.commands.tpa.TpaCancelCommand;
import org.xerapvp.essentials.listeners.*;
import org.xerapvp.essentials.manager.SpawnManager;
import org.xerapvp.essentials.utils.EconomyImplementer;
import org.xerapvp.essentials.utils.VaultHook;

import java.util.*;

/**
 * @author RetroRPC
 * Copyright @ RetroRPC
 */

public class Core extends JavaPlugin {

    public static Core instance;
    private Location spawnLocation;
    public HashMap<UUID, Location> player_teleport;
    public HashMap<UUID, Location> death_locations;
    public  Map<UUID, UUID> tpa_request;
    public  ArrayList<UUID> tpa_toggled;
    public EconomyImplementer economyImplementer;
    public VaultHook vaultHook;
    public HashMap<UUID,Double> playerBank = new HashMap<>();

    public void onEnable() {




        instance = this;
        SpawnManager.onEnable();
        this.saveDefaultConfig();
        registerMaps();
        registerListeners();
        registerCommands();
        Bukkit.getConsoleSender().sendMessage("THIS IS WORKING");


        economyImplementer = new EconomyImplementer();
        vaultHook = new VaultHook();
        vaultHook.hook();

    }

    public void onDisable() {
        death_locations.clear();
        player_teleport.clear();
        tpa_request.clear();
        vaultHook.unhook();
    }

    public void registerMaps() {
        death_locations = new HashMap<>();
        player_teleport = new HashMap<>();
        tpa_request = new HashMap<>();
    }

    public void registerListeners() {
        PluginManager manager = getServer().getPluginManager();

        manager.registerEvents(new JoinListener(), this);

        manager.registerEvents(new WorldListener(), this);
        manager.registerEvents(new TeleportMovementListener(), this);
        manager.registerEvents(new ChatListener(), this);
        manager.registerEvents(new DeathListener(), this);
    }



    public void registerCommands() {

        getCommand("econo").setExecutor(new EconomyCommands());
        CommandFramework framework = new CommandFramework(this);
        Arrays.asList(
                 new GamemodeCommand(), new FlyCommand(), new BackCommand(), new TpaCommand(), new HealCommand(), new SpawnCommand(), new SetSpawnCommand(), new SuicideCommand(), new TopCommand(), new FeedCommand(), new CraftCommand(),
                new TpaCancelCommand(), new GMCCommand(), new GMSCommand(), new GMSPCommand(), new KillCommand()
        ).forEach(framework::registerCommands);
    }

    public Location getSpawnLocation() {
        return this.spawnLocation;
    }



    public void setSpawnLocation(Location spawnLocation) {
        this.spawnLocation = spawnLocation;
    }


}
