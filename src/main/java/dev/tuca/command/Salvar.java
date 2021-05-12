package dev.tuca.command;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.Plugin;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class Salvar implements CommandExecutor {

    private final Plugin plugin;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        plugin.saveConfig();
        return false;
    }
}
