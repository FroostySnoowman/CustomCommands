package xyz.nexusservices.customCommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class DiscordCommand implements CommandExecutor {
    private final JavaPlugin plugin;

    public DiscordCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String discordMessage = plugin.getConfig().getString("DiscordMessage");

        if (discordMessage != null && !discordMessage.isEmpty()) {
            String formattedMessage = ChatColor.translateAlternateColorCodes('&', discordMessage.replace("\\n", "\n"));
            sender.sendMessage(formattedMessage);
        } else {
            sender.sendMessage(ChatColor.RED + "Discord message not set in the config!");
        }

        return true;
    }
}