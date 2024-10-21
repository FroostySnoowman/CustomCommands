package xyz.nexusservices.customCommands;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.nexusservices.customCommands.commands.*;
import xyz.nexusservices.customCommands.utils.DataManager;

public final class CustomCommands extends JavaPlugin {
    private static CustomCommands instance;
    public DataManager config;

    @Override
    public void onEnable() {
        // General Initializers
        if (instance == null) instance = this;

        // Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        this.config = new DataManager(this, "config.yml");

        // Commands
        this.getCommand("discord").setExecutor(new DiscordCommand(this));
        this.getCommand("store").setExecutor(new StoreCommand(this));
        this.getCommand("vote").setExecutor(new VoteCommand(this));

        // Fancy Enable Message
        getLogger().info(ChatColor.GREEN + "------------------------------");
        getLogger().info(ChatColor.AQUA + "CustomCommands Plugin Enabled!");
        getLogger().info(ChatColor.GOLD + "Version: " + getDescription().getVersion());
        getLogger().info(ChatColor.LIGHT_PURPLE + "Developed by: NexusServices");
        getLogger().info(ChatColor.GREEN + "------------------------------");
    }

    @Override
    public void onDisable() {
        // Fancy Disable Message
        getLogger().info(ChatColor.RED + "------------------------------");
        getLogger().info(ChatColor.DARK_RED + "CustomCommands Plugin Disabled!");
        getLogger().info(ChatColor.GOLD + "We hope to see you again soon!");
        getLogger().info(ChatColor.RED + "------------------------------");
    }
}