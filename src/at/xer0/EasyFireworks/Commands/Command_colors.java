package at.xer0.EasyFireworks.Commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Command_colors {
	
	public static void fire(Player p)
	{
		p.sendMessage(ChatColor.DARK_PURPLE + "#####Colors:#####");
		p.sendMessage(ChatColor.BLUE + "b = Blue");
		p.sendMessage(ChatColor.YELLOW + "y = Yellow");
		p.sendMessage(ChatColor.GREEN + "g = Green");
		p.sendMessage(ChatColor.RED + "r = Red");
		p.sendMessage(ChatColor.WHITE + "w = White");
		p.sendMessage(ChatColor.BLACK + "bl = Black");
		p.sendMessage(ChatColor.GREEN + "#FFFFFF = White (HEX)");
		p.sendMessage(ChatColor.DARK_PURPLE + "#################");

	}

}
