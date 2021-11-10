package fr.explodium.Commands;

import fr.explodium.Explodium;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class spawn implements CommandExecutor {
    private Explodium explodium;

    public spawn(Explodium explodium){
        this.explodium = explodium;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (this.explodium.getConfig().getString("themes").equals("noel")) {
                player.teleport(parseStringToLoc(this.explodium.getConfig().getString("locNoel")));
                //dans ton config, ton locNoel il faut que sa soit commme sa: x,y,z,,worldName,pitch,yaw
            } else if (this.explodium.getConfig().getString("themes").equals("halloween")) {
                player.teleport(parseStringToLoc(this.explodium.getConfig().getString("locHalloween")));
                //dans ton config, ton locNoel il faut que sa soit commme sa: x,y,z,,worldName,pitch,yaw
            } else if (this.explodium.getConfig().getString("themes").equals("normal")) {
                player.teleport(parseStringToLoc(this.explodium.getConfig().getString("locNormal")));
                //dans ton config, ton locNoel il faut que sa soit commme sa: x,y,z,,worldName,pitch,yaw

            }
        }
        return false;
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
