package at.xer0.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import at.xer0.util.RocketProvider;

public class Command_giverandom {
	
	//fw give iXer0 23 random
	
	public static void fire(Player p,String[] args)
	{
		if(args[3].equalsIgnoreCase("random"))
		{
			Player target = Bukkit.getPlayer(args[1]);

			if(target != null)
			{
				target.getInventory().addItem(RocketProvider.getRandomRocket(p,args[2]));
				if(target == p)
				{
					p.sendMessage(ChatColor.GREEN + "You gave yourself " + args[2] + " random firework rockets!");
				}
				else
				{
					p.sendMessage(ChatColor.GREEN + "You gave " + args[1] + " "+args[2]+ " of random firework rockets!");
					target.sendMessage(ChatColor.GREEN + "You have recived "+args[2]+" of random firework rockets from " + p.getDisplayName() + "!");
				}

			}
			else
			{
				p.sendMessage(ChatColor.RED +"Player not found");
			}
		}
	}

}
