package dev.tuca.command;

import lombok.RequiredArgsConstructor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class MessageCreateCommand implements CommandExecutor {

    private final Plugin plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        FileConfiguration config = plugin.getConfig();

        List<String> lista = new ArrayList<>();
        if (hasLetter(args[0])) p.sendMessage("§cBugado");
        lista.add("");
        lista.add(args[0]);
        lista.add("");
        config.getConfigurationSection("messages").set(args[0], lista);
        plugin.saveConfig();

        return false;

    }
    public boolean hasLetter(String string) {
        try {
            Integer.parseInt(string);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}
