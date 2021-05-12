package dev.tuca.manager;

import lombok.RequiredArgsConstructor;
import org.bukkit.plugin.Plugin;

@RequiredArgsConstructor
public class FileManager {

    private final Plugin plugin;

    public void checkSection() {
        if (plugin.getConfig().getConfigurationSection("messages") == null)
            plugin.getConfig().createSection("messages");
            plugin.saveConfig();
    }
}
