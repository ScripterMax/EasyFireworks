package at.xer0.EasyFireworks.Commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Command_help {
	
	public static void fire(Player p)
	{
		p.sendMessage(ChatColor.GREEN + "Xer0's Easy Fireworks Plugin");
		p.sendMessage(ChatColor.YELLOW + "/fw get <ammount> {random | <colors> <effects> <power>}");
		p.sendMessage(ChatColor.YELLOW + "/fw give <player> <ammount> ...");
		p.sendMessage(ChatColor.YELLOW + "/fw fillup - Fills dispenser you're pointing at");
		p.sendMessage(ChatColor.RED + "########HELP:########");
		p.sendMessage(ChatColor.YELLOW + "/fw usage - How to use the plugin");
		p.sendMessage(ChatColor.YELLOW + "/fw lists - List of arguments");
		p.sendMessage(ChatColor.GREEN + "##########################");
		
	}

}
