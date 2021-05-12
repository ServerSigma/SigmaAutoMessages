package dev.tuca.manager;

import lombok.RequiredArgsConstructor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

@RequiredArgsConstructor
public class MessageLoader {

    //private final Map<ArrayList<String>, Double> messages = new HashMap<>();

    public void loadAllMessages(Plugin plugin) {
        FileConfiguration config = plugin.getConfig();

        for (String message : config.getConfigurationSection("messages").getKeys(false)) {
            System.out.println(message);
        }
    }
}
