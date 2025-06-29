package ch.seenkid.dev;

import ch.seenkid.dev.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin MineKahest activé");
        System.out.println("Plugin MineKahest activé");

        // commandes
        getCommand("meteo").setExecutor(new Meteo());
        getCommand("shop").setExecutor(new Shop());
        getCommand("mks").setExecutor(new MKS());
        getCommand("MKC").setExecutor(new MKC());
        getCommand("createworld").setExecutor(new CreateWorld());
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin MineKahest disabled");
        System.out.println("Plugin MineKahest disabled");
    }
}
