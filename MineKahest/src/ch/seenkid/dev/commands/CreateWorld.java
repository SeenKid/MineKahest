package ch.seenkid.dev.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

public class CreateWorld extends JavaPlugin implements Listener {

    private final String prefix = "§f[§cMineKahest§f]§a ";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Check if player not console
        if (!(sender instanceof Player)) {
            sender.sendMessage(prefix + "Cette commande ne peut être utilisée que par un joueur.");
            return true;
        }

        // Variables
        Player player = (Player) sender;
        Location loc = player.getEyeLocation();
        Vector v = loc.getDirection().normalize();
        int maxDistance = 4;

        // Check if player is looking at sign
        for(int i = 1 ; i <= maxDistance ; i++) {
            loc.add(v);
            if (loc.getBlock().getType() != Material.OAK_SIGN) {
                sender.sendMessage(prefix + "Vous regardez un pannal.");
                break;
            }
        }

        // le joueur regarde un panneau en bois
        Block targetedBlock = loc.getBlock();
        if(targetedBlock.getType() == Material.OAK_SIGN) {
            sender.sendMessage(prefix + "Vous devez être admin et regarder un pannal en bois pour cela.");
        }


        return true;
    }
}
