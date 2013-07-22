package at.xer0.EasyFireworks.Commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Command_power {
	
	public static void fire(Player p)
	{
		p.sendMessage(ChatColor.DARK_PURPLE + "#####Power:#####");
		p.sendMessage(ChatColor.WHITE + "0 = Not high");
		p.sendMessage(ChatColor.GREEN + "1 = Normal high");
		p.sendMessage(ChatColor.YELLOW + "2 = High");
		p.sendMessage(ChatColor.RED + "3 = Very high");
		p.sendMessage(ChatColor.DARK_PURPLE + "################");

	}

}
