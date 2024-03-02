package me.ash.deathshuffle.Commands;

import me.ash.deathshuffle.DeathShuffle;
import me.ash.deathshuffle.Deaths;
import me.ash.deathshuffle.Listeners.Listen;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

public class StartDeathShuffle implements CommandExecutor {

    private final DeathShuffle plugin;

    public StartDeathShuffle(DeathShuffle plugin) {
        this.plugin = plugin;
        plugin.getCommand("startDeathShuffle").setExecutor(this);
    }

    public static String die = "";
    Deaths deaths = new Deaths();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        BukkitScheduler sched = p.getServer().getScheduler();
        p.sendMessage("");

        for (int i = 0; i < args.length; i++) {
            this.plugin.mapDie.put(args[i], null);
            p.getServer().getPlayer(args[i]).setGameMode(GameMode.SURVIVAL);
            p.getServer().getPlayer(args[i]).setHealth(20);
            p.getServer().getPlayer(args[i]).setFoodLevel(20);
        }
        plugin.mapDie.forEach((key, value) -> {
            die = deaths.death(key);
            this.plugin.mapDie.replace(key, die);
            p.getServer().getPlayer(key).sendMessage(ChatColor.YELLOW +"You have 5 minutes to get this death message: \n" +ChatColor.GOLD+""+ key + " " + die);
        });

        sched.scheduleSyncRepeatingTask(plugin, new Runnable() {//1s repeating task
            int cnt = 300;//300

            @Override
            public void run() {
                if (cnt==240){
                    p.getServer().broadcastMessage(ChatColor.RED+"4 minutes left");
                } else if (cnt==180) {
                    p.getServer().broadcastMessage(ChatColor.RED+"3 minutes left");
                } else if (cnt==120) {
                    p.getServer().broadcastMessage(ChatColor.RED+"2 minutes left");
                } else if (cnt==60) {
                    p.getServer().broadcastMessage(ChatColor.RED+"1 minute left");
                } else if (cnt==10) {
                    p.getServer().broadcastMessage(ChatColor.RED+"10 seconds left");
                } else if (cnt < 10) {
                    p.getServer().broadcastMessage(ChatColor.RED+""+cnt);
                }
                cnt--;
                if (cnt == 0) {
                    plugin.mapDie.forEach((key, value) -> {
                        if (value != null) {
                            p.getServer().broadcastMessage(ChatColor.RED + key + " is dumb and didn't die the way they were supposed to in time " + ChatColor.GRAY + "(" + value + ")");
                        } else {
                            p.getServer().broadcastMessage(ChatColor.AQUA + key + " is obedient and died the way they were supposed to " + ChatColor.GRAY + "(" + Listen.mapDeaths.get(key) + ")");
                        }
                    });
                    p.getServer().broadcastMessage(ChatColor.GOLD + "The round has ended");
                    sched.cancelTasks(plugin);
                }
            }
        }, 0L, 20L);

        return true;
    }
}
