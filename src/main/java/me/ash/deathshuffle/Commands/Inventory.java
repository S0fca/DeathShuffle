package me.ash.deathshuffle.Commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Inventory implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        Location l = p.getLocation();
        for (int i = 0; i < args.length; i++) {
            Player player = p.getServer().getPlayer(args[i]);
            player.teleport(l);
            player.getInventory().clear();
            ItemStack pickaxe = new ItemStack(Material.STONE_PICKAXE);
            ItemStack axe = new ItemStack(Material.STONE_AXE);
            ItemStack food = new ItemStack(Material.COOKED_BEEF, 64);
            player.getInventory().setItem(1,pickaxe);
            player.getInventory().setItem(0,axe);
            player.getInventory().setItem(8,food);
        }
        return true;
    }
}
