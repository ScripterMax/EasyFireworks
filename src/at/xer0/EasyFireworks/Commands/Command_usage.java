package at.xer0.EasyFireworks.Commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Command_usage {
	
	public static void fire(Player p)
	{
		p.sendMessage(ChatColor.DARK_PURPLE + "#####Usage:#####");
		p.sendMessage(ChatColor.YELLOW + "You can input multiple colors and effects!");
		p.sendMessage(ChatColor.YELLOW + "Seperate them with '-'");
		p.sendMessage(ChatColor.YELLOW + "For example: Color: g-y-#FF2222-r , Effect: b-x-s");
		p.sendMessage(ChatColor.YELLOW + "Example: /fw give iXer0 45 r-#FF2222 b-x 1");
		p.sendMessage(ChatColor.DARK_PURPLE + "################");
	}

}
