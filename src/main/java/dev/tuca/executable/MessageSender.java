package dev.tuca.executable;

import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class MessageSender {

    private final Plugin plugin;
    private final List<List<String>> messages = new ArrayList<>();
    private int round = 0;

    public void startAutoMessage() {
        ConfigurationSection section = plugin.getConfig().getConfigurationSection("messages");
        boolean soundActive = plugin.getConfig().getBoolean("sound-active");
        Sound soundName = Sound.valueOf(plugin.getConfig().getString("sound-name"));
        boolean systemActive = plugin.getConfig().getBoolean("system-active");
        long delay = plugin.getConfig().getLong("system-delay");

        if (systemActive) {
            section.getKeys(false).forEach(msg -> {
                messages.add(section.getStringList(msg));
            });

            new BukkitRunnable() {

                public void run() {
                    if (round == messages.size()) round = 0;
                    List<String> list = new ArrayList<>(messages.get(round));
                    for (String msg : list) {
                        for(Player p : Bukkit.getOnlinePlayers()) {
                            if(soundActive) p.playSound(p.getLocation(), soundName, 0.25F, p.getLocation().getPitch());
                            p.sendMessage(msg);
                        }
                    }
                    round++;
                }

            }.runTaskTimerAsynchronously(plugin, delay * 20, delay * 20);
        }
    }
}