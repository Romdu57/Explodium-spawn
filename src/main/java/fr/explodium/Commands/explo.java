package fr.explodium.Commands;

import fr.explodium.Explodium;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class explo implements CommandExecutor {
    private Explodium explodium;

    public explo(Explodium explodium){
        this.explodium = explodium;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            if (cmd.getName().equalsIgnoreCase("explo")) {
                if (!player.hasPermission("explo.reload")) {
                    player.sendMessage("§4Vous n'avez pas la permission de faire cela !");
                    return true;
                }
                    if (args.length != 0 && args[0].equalsIgnoreCase("reload")) {
                        explodium.reloadConfig();
                        player.sendMessage("La config à bien été reload !");
                    } else {
                        player.sendMessage("/explo reload");
                    }

            }
        } else if (cmd.getName().equalsIgnoreCase("explo")) {
            if (args.length != 0 && args[0].equalsIgnoreCase("reload")) {
                explodium.reloadConfig();
                System.out.println("Le plugins à été reload");
            } else {
                System.out.println("/explo reload");
            }
        }
        return false;
    }
}
