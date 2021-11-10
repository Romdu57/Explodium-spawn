package fr.explodium;

import fr.explodium.Commands.explo;
import fr.explodium.Commands.spawn;
import org.bukkit.plugin.java.JavaPlugin;

public class Explodium extends JavaPlugin {

    @Override
    public void onEnable(){
        saveDefaultConfig();
        System.out.println("Explodium: Le plgins vient de se lancer !");
        this.getServer().getPluginManager().registerEvents(new Jointp(this), this);
        getCommand("spawn").setExecutor(new spawn(this));
        getCommand("explo").setExecutor(new explo(this));
    }

    @Override
    public void onDisable(){
        System.out.println("Explodium: Le plugins vient de se fermer !");
    }
}
