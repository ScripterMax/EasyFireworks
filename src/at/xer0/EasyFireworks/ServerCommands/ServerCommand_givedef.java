package at.xer0.EasyFireworks.ServerCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import at.xer0.EasyFireworks.util.Logger;
import at.xer0.EasyFireworks.util.RocketProvider;

public class ServerCommand_givedef {
	
	//fw give iXer0 33 y-ma c 0

	public static void fire(String[] args) {
		if (args[4].length() != 1) {
			Logger.info("Effect argument too long!");
		} else {
			Player target = Bukkit.getPlayer(args[1]);

			if (target != null) {
				target.getInventory().addItem(
						RocketProvider.getPredefinedRocket(args[3], args[4],args[5], null,args[2]));
				Logger.info("You gave " + args[1]
						+ " one stack of firework rockets!");
				target.sendMessage(ChatColor.GREEN
						+ "You have recived one stack of firework rockets from the server!");
			} else {
				Logger.info("Player not found");
			}
		}
	}

}
