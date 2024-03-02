package me.ash.deathshuffle.Listeners;

import me.ash.deathshuffle.Commands.StartDeathShuffle;
import me.ash.deathshuffle.DeathShuffle;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.HashMap;

public class Listen implements Listener {

    public static final HashMap<String, String> mapDeaths = new HashMap<>();
    private final DeathShuffle plugin;
    public static String winDie;

    public Listen(DeathShuffle plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void event(PlayerDeathEvent e) {
        e.setKeepInventory(true);
        e.getDrops().clear();
        e.setDroppedExp(0);
        String death = e.getDeathMessage();
        Player p = e.getEntity();
        String name = p.getName();

        if (death.contains(plugin.mapDie.get(name))) {
            p.getServer().broadcastMessage(ChatColor.GOLD + "" + name + " has died the way they were supposed to");
            winDie = plugin.mapDie.get(p.getName());
            mapDeaths.put(p.getName(), StartDeathShuffle.die);
            plugin.mapDie.replace(p.getName(), null);
            p.getServer().broadcastMessage(ChatColor.GRAY + e.getDeathMessage());
            e.setDeathMessage("");

            boolean noEnd = plugin.mapDie.values().stream().anyMatch(value -> value != null);
            if (!noEnd) {
                plugin.mapDie.forEach((key, value) -> {
                    p.getServer().broadcastMessage(ChatColor.AQUA + key + " is obedient and died the way they were supposed to " + ChatColor.GRAY + "(" + mapDeaths.get(p.getName()) + ")");
                });
                p.getServer().broadcastMessage(ChatColor.GOLD + "The round has ended");
                p.getServer().getScheduler().cancelTasks(plugin);
            }
            e.setDeathMessage("");
        } else {
            p.sendMessage("We're no strangers to love You know the rules and so do I A full commitment's what I'm thinking of You wouldn't get this from any other guy I just wanna tell you how I'm feeling Gotta make you understand \nNever gonna give you up \nNever gonna let you down");
        }
    }
}
