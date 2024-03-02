package me.ash.deathshuffle;

import me.ash.deathshuffle.Commands.Inventory;
import me.ash.deathshuffle.Commands.StartDeathShuffle;
import me.ash.deathshuffle.Commands.StopDeathShuffle;
import me.ash.deathshuffle.Listeners.Listen;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class DeathShuffle extends JavaPlugin {

    public HashMap<String, String> mapDie = new HashMap<>();

    @Override
    public void onEnable() {
        System.out.println("plugin Death shuffle has started");
        new Listen(this);
        new StartDeathShuffle(this);
        new StopDeathShuffle(this);
        getCommand("inventory").setExecutor(new Inventory());
    }

    @Override
    public void onDisable() {
        System.out.println("plugin Death shuffle has stopped");
    }
}
