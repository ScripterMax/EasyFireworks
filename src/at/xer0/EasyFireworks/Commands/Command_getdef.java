package at.xer0.EasyFireworks.Commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import at.xer0.EasyFireworks.util.RocketProvider;

public class Command_getdef {

	public static void fire(Player p,String[] args) //fw give 32 b-y s 0
	{

			p.getInventory().addItem(RocketProvider.getPredefinedRocket(args[2], args[3], args[4], p, args[1]));
			p.sendMessage(ChatColor.GREEN + "You gave yourself some firework rockets!");
		
		
	}
	
}
