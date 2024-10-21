package xyz.nexusservices.customCommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class VoteCommand implements CommandExecutor {
    private final JavaPlugin plugin;

    public VoteCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String voteMessage = plugin.getConfig().getString("VoteMessage");

        if (voteMessage != null && !voteMessage.isEmpty()) {
            String formattedMessage = ChatColor.translateAlternateColorCodes('&', voteMessage.replace("\\n", "\n"));
            sender.sendMessage(formattedMessage);
        } else {
            sender.sendMessage(ChatColor.RED + "Store message not set in the config!");
        }

        return true;
    }
}