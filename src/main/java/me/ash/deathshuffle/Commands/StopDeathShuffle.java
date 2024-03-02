package me.ash.deathshuffle.Commands;

import me.ash.deathshuffle.DeathShuffle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StopDeathShuffle implements CommandExecutor {

    private final DeathShuffle plugin;

    public StopDeathShuffle(DeathShuffle plugin) {
        this.plugin = plugin;
        plugin.getCommand("stopDeathShuffle").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        p.sendMessage("Death Shuffle stopped");
        p.getServer().getScheduler().cancelTasks(this.plugin);

        return true;
    }
}
