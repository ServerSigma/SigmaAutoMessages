package com.serversigma;

import com.serversigma.schedulers.MessagesScheduler;
import org.bukkit.plugin.java.JavaPlugin;

public class SigmaAutoMessages extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        MessagesScheduler messagesScheduler = new MessagesScheduler(this);
        messagesScheduler.startAutoMessage();
    }

}