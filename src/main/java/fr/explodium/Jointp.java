package fr.explodium;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Jointp implements Listener {

    private Explodium explodium;

    public Jointp(Explodium explodium){
        this.explodium = explodium;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if(this.explodium.getConfig().getString("themes").equals("noel")){
            player.teleport(parseStringToLoc(this.explodium.getConfig().getString("locNoel")));
            //dans ton config, ton locNoel il faut que sa soit commme sa: x,y,z,,worldName,pitch,yaw
        }else if(this.explodium.getConfig().getString("themes").equals("halloween")){
            player.teleport(parseStringToLoc(this.explodium.getConfig().getString("locHalloween")));
            //dans ton config, ton locNoel il faut que sa soit commme sa: x,y,z,,worldName,pitch,yaw
        }else if(this.explodium.getConfig().getString("themes").equals("normal")){
            player.teleport(parseStringToLoc(this.explodium.getConfig().getString("locNormal")));
            //dans ton config, ton locNoel il faut que sa soit commme sa: x,y,z,,worldName,pitch,yaw

        }
    }

    public Location parseStringToLoc(String string) {
        String[] parsedLoc = string.split(", ");
        double x = Double.valueOf(parsedLoc[0]);
        double y = Double.valueOf(parsedLoc[1]);
        double z = Double.valueOf(parsedLoc[2]);
        String world = parsedLoc[3];
        float yaw = Float.valueOf(parsedLoc[4]);
        float pitch = Float.valueOf(parsedLoc[5]);
        return new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
    }

}