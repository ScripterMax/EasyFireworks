package at.xer0.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import at.xer0.util.RocketProvider;

public class Command_givedef {
	
	//fw give iXer0 14 r-b c 1
	
	public static void fire(Player p,String[] args)
	{

			Player target = Bukkit.getPlayer(args[1]);
			
			if(target != null)
			{
				target.getInventory().addItem(RocketProvider.getPredefinedRocket(args[3], args[4], args[5], p,args[2]));
				
				if(target == p)
				{
					p.sendMessage(ChatColor.GREEN + "You gave yourself " + args[2] + " firework rockets!");
				}
				else
				{
					p.sendMessage(ChatColor.GREEN + "You gave " + args[1] + " "+args[2]+ " of firework rockets!");
					target.sendMessage(ChatColor.GREEN + "You have recived "+args[2]+" of firework rockets from " + p.getDisplayName() + "!");
				}

			}
			else
			{
				p.sendMessage(ChatColor.RED +"Player not found");
			}
		
		
	}
}
