package dev.tuca.command;

import lombok.RequiredArgsConstructor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RequiredArgsConstructor
public class MessageListCommand implements CommandExecutor {

    private final Plugin plugin;
    private List<String> messages = new ArrayList<>();
    private int round = 0;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        FileConfiguration config = plugin.getConfig();
        Player p = (Player) sender;
        ConfigurationSection section = config.getConfigurationSection("messages");
        messages.addAll(section.getKeys(false));

        if(round == messages.size()) round = 0;
        System.out.println(messages.get(round));
        return false;
    }
}






        /*for (String list : section.getKeys(false)) {
            teste.addAll(section.getStringList(list));
            System.out.println(teste);
            Iterator<String> iteraror = list.
            System.out.println(iteraror.hasNext());
            System.out.println(iteraror.next());
            p.sendMessage("teste" + teste);
        }
        return false;
    }
}
*/