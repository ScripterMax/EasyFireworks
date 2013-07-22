package at.xer0.EasyFireworks.Commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Command_effects {
	
	public static void fire(Player p)
	{
		p.sendMessage(ChatColor.DARK_PURPLE + "#####Effects:#####");
		p.sendMessage(ChatColor.YELLOW + "c = Creeper");
		p.sendMessage(ChatColor.YELLOW + "s = Star");
		p.sendMessage(ChatColor.YELLOW + "b = Big ball");
		p.sendMessage(ChatColor.YELLOW + "x = Burst");
		p.sendMessage(ChatColor.YELLOW + "t = Trail");
		p.sendMessage(ChatColor.YELLOW + "f = Flicker");
		p.sendMessage(ChatColor.YELLOW + "n = Normal ball");
		p.sendMessage(ChatColor.DARK_PURPLE + "##################");

	}

}
