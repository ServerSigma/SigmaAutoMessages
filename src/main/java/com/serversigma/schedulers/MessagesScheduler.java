package com.serversigma.schedulers;

import lombok.RequiredArgsConstructor;
import org.bukkit.Sound;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class MessagesScheduler {

    private int round = 0;
    private final Plugin plugin;

    public void startAutoMessage() {

        List<List<String>> messages = new ArrayList<>();
        ConfigurationSection section = plugin.getConfig().getConfigurationSection("messages");
        section.getKeys(false).forEach(msg -> messages.add(section.getStringList(msg)));

        Sound sound = Sound.valueOf(plugin.getConfig().getString("configuration.sound"));
        int delay = plugin.getConfig().getInt("configuration.delay");

        if (messages.size() > 0) {
            BukkitScheduler scheduler = plugin.getServer().getScheduler();
            scheduler.scheduleSyncRepeatingTask(plugin, () -> {

                if (round == messages.size()) round = 0;
                List<String> messageList = new ArrayList<>(messages.get(round));

                for (Player p : plugin.getServer().getOnlinePlayers()) {
                    for (String msg : messageList) {
                        p.playSound(p.getLocation(), sound, 0.25F, p.getLocation().getPitch());
                        p.sendMessage(msg.replace("&", "§"));
                    }
                }
                round++;
            }, delay * 20L, delay * 20L);
        }
    }

}