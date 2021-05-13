package dev.tuca;

import dev.tuca.executable.MessageSender;
import org.bukkit.plugin.java.JavaPlugin;


public class SigmaMessages extends JavaPlugin {


    @Override
    public void onEnable() {
        saveDefaultConfig();
        MessageSender messageSender = new MessageSender(this);
        messageSender.startAutoMessage();
    }
}
