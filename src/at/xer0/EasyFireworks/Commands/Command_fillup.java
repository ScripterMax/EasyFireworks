package at.xer0.EasyFireworks.Commands;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.block.Dispenser;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import at.xer0.EasyFireworks.Dispenser.Blocks;
import at.xer0.EasyFireworks.Manager.FileManager;
import at.xer0.EasyFireworks.util.RocketProvider;

public class Command_fillup {
	
	public static void fire(Player p)
	{
		Block disp = p.getTargetBlock(null, 20);
		if(disp.getTypeId() == 0)
		{
			p.sendMessage(ChatColor.RED +"This Block is too far away!");
		}else
		{
			if(disp.getTypeId() == 23)
			{
		    Dispenser dispenser = (Dispenser) disp.getState();
	        Inventory inv = dispenser.getInventory();
	        Blocks.dispensers.add(dispenser);
			FileManager.saveDispensers();
	        
	        for(int i = 1;i<=inv.getSize();i++)
	        {
	        	inv.addItem(RocketProvider.getRandomRocket(p,"64"));
	        }
	       
	        
			p.sendMessage(ChatColor.GREEN + "Created auto-refill firework rocket dispenser!");

			}else
			{
				p.sendMessage(ChatColor.RED +"This Block is not a dispenser!");
			}
		}
	}

}
