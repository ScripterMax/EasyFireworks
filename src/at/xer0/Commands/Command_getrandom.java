package at.xer0.Commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import at.xer0.util.RocketProvider;

public class Command_getrandom {
	
	public static void fire(Player p,String[] args) //fw get 29 random
	{
		
		p.getInventory().addItem(RocketProvider.getRandomRocket(p, args[1]));
		p.sendMessage(ChatColor.GREEN + "You gave yourself some random firework rockets!");
		
	}


}
