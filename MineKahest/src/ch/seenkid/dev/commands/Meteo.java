package ch.seenkid.dev.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Meteo implements CommandExecutor {

    public String prefix = "§f[§cMineKahest§f]§a ";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Seuls les joueurs peuvent utiliser cette commande.");
            return true;
        }

        Player player = (Player) sender;
        World world = player.getWorld();

        if (args.length != 1) {
            player.sendMessage("Utilisation: /meteo jour|nuit|crepuscule|aube|pluie|orage|soleil");
            return true;
        }

        String arg = args[0].toLowerCase();

        switch (arg) {
            case "jour":
                world.setTime(1000); // 1000 ticks = matin
                player.sendMessage(prefix + "Il fait maintenant jour.");
                break;
            case "nuit":
                world.setTime(13000); // 13000 ticks = nuit
                player.sendMessage(prefix + "Il fait maintenant nuit.");
                break;
            case "crepuscule":
                world.setTime(12000); // crépuscule
                player.sendMessage(prefix + "Nous sommes désormais au crépuscule.");
                break;
            case "aube":
                world.setTime(23000); // aube
                player.sendMessage(prefix + "Nous sommes désormais à l'aube.");
                break;
            case "rain":
                world.setStorm(true);
                world.setThundering(false);
                player.sendMessage(prefix + "Il pleut.");
                break;
            case "orage":
                world.setStorm(true);
                world.setThundering(true);
                player.sendMessage(prefix + "Un orage éclate !");
                break;
            case "sun":
                world.setStorm(false);
                world.setThundering(false);
                player.sendMessage(prefix + "Le soleil brille à nouveau.");
                break;
            default:
                player.sendMessage(prefix + "Option invalide. Utilisation: /meteo jour|nuit|crepuscule|aube|pluie|orage|soleil");
                break;
        }

        return true;
    }

}
