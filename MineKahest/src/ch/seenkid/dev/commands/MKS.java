package ch.seenkid.dev.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MKS implements CommandExecutor {

    private final String prefix = "§f[§cMineKahest§f]§a ";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(prefix + "Cette commande ne peut être utilisée que par un joueur.");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("minekahest.survival")) {
            player.sendMessage(prefix + "Vous n'avez pas la permission d'utiliser cette commande.");
            return true;
        }

        player.setGameMode(GameMode.SURVIVAL);
        player.sendMessage(prefix + "Vous êtes maintenant en mode survie.");
        
        return true;
    }
}
