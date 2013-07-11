package at.xer0.ServerCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import at.xer0.util.Logger;
import at.xer0.util.RocketProvider;

public class ServerCommand_giverandom {
	
	public static void fire(String[] args)
	{
		//fw give iXer0 20 random
		
		Player target = Bukkit.getPlayer(args[1]);

		if (target != null) {
			target.getInventory().addItem(
					RocketProvider.getRandomRocket(null,args[2]));
			Logger.info("You gave "
					+ args[1]
					+ " one stack of random firework rockets!");
			target.sendMessage(ChatColor.GREEN
					+ "You have recived one stack of random firework rockets from the server!");

		} else {
			Logger.error("Player not found");
		}
	}

}
