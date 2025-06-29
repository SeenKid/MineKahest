package ch.seenkid.dev.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class Shop implements CommandExecutor {

    private final String prefix = "§f[§cMineKahest§f]§a ";

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(prefix + "Cette commande ne peut être utilisée que par un joueur.");
            return true;
        }

        Player player = (Player) sender;
        openShop(player);
        return true;
    }

    private void openShop(Player player) {
        Inventory inv = Bukkit.createInventory(null, 54, "§l§2Boutique MineKahest");

        // Pomme dorée
        ItemStack gapple = createItem(Material.GOLDEN_APPLE, 16, 
            "§6✦ §ePomme Dorée §6✦", 
            Arrays.asList(
                "§7Prix: §e500 pièces",
                "§7Cliquez pour acheter",
                "",
                "§8➥ Régénération II (0:05)",
                "§8➥ Absorption II (2:00)"
            ));

        // Épée en diamant
        ItemStack sword = createItem(Material.DIAMOND_SWORD, 1,
            "§b✧ §bÉpée en Diamant §b✧",
            Arrays.asList(
                "§7Prix: §e1000 pièces",
                "§7Cliquez pour acheter",
                "",
                "§8➥ Tranchant III",
                "§8➥ Durabilité II"
            ));

        // Armure en diamant
        ItemStack chestplate = createItem(Material.DIAMOND_CHESTPLATE, 1,
            "§b❈ §bPlastron en Diamant §b❈",
            Arrays.asList(
                "§7Prix: §e1500 pièces",
                "§7Cliquez pour acheter",
                "",
                "§8➥ Protection III",
                "§8➥ Durabilité II"
            ));

        // Placement des items
        inv.setItem(11, gapple);
        inv.setItem(13, sword);
        inv.setItem(15, chestplate);

        // Bordure en verre
        ItemStack border = createItem(Material.BLACK_STAINED_GLASS_PANE, 1, "§r", null);
        for (int i = 0; i < 9; i++) {
            inv.setItem(i, border);
            inv.setItem(45 + i, border);
        }
        for (int i = 0; i < 6; i++) {
            inv.setItem(i * 9, border);
            inv.setItem(i * 9 + 8, border);
        }

        player.openInventory(inv);
    }

    private ItemStack createItem(Material material, int amount, String name, java.util.List<String> lore) {
        ItemStack item = new ItemStack(material, amount);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(name);
            if (lore != null) {
                meta.setLore(lore);
            }
            item.setItemMeta(meta);
        }
        return item;
    }
}
