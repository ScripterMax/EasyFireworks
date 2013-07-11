package at.xer0.Commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Command_lists {
	
	public static void fire(Player p)
	{
		p.sendMessage(ChatColor.BLUE + "#####Lists:#####");
		p.sendMessage(ChatColor.YELLOW + "/fw colors");
		p.sendMessage(ChatColor.YELLOW + "/fw effects");
		p.sendMessage(ChatColor.YELLOW + "/fw power");
		p.sendMessage(ChatColor.BLUE + "################");
	}

}
