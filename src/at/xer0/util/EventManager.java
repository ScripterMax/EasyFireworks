package at.xer0.util;

import org.bukkit.ChatColor;
import org.bukkit.block.Dispenser;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;

import at.xer0.Dispenser.Blocks;
import at.xer0.Dispenser.FileManager;

public class EventManager implements Listener{
	
	@EventHandler
	public void onBlockDispens(BlockDispenseEvent event)
	{
		Dispenser disp = null;
		try{
		 disp = (Dispenser)event.getBlock().getState();
		}catch(Exception e){}
		
		if(disp != null)
		{
			for(Dispenser d:Blocks.dispensers)
			{
				
				if(disp.getLocation().toString().equalsIgnoreCase(d.getLocation().toString()))
				{
					
					Inventory inv = disp.getInventory();
					inv.clear();
					
					for(int i = 1;i<=inv.getSize();i++)
			        {
			        	inv.addItem(RocketProvider.getRandomRocket(null,"64"));
			        }
					break;
				}
			}
		}
		
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event)
	{
			Dispenser d = null;
			try{
			d = (Dispenser)event.getBlock().getState();
			}catch(Exception e){}
			
			if(d != null)
			{
				
				for(Dispenser di : Blocks.dispensers)
				{
					try {
						if (di.getLocation().toString().equalsIgnoreCase(d.getLocation().toString())) {
							
							if(event.getPlayer().hasPermission("firework.*")||event.getPlayer().hasPermission("firework.fillup"))
							{
								d.getInventory().clear();
								Blocks.dispensers.remove(di);
								event.getPlayer().sendMessage(ChatColor.RED+ "You have destroyed an auto-refill dispenser!");
								FileManager.saveDispensers();
								break;
							}else
							{
								event.setCancelled(true);
								event.getPlayer().sendMessage(ChatColor.RED + "You don't have permission to destroy this dispenser!");
							}
							
						}
					} catch (Exception e) {
					}
				}
			}
			
		
	}
	
	@EventHandler
	public void onPlayerJoin (PlayerJoinEvent e)
	{
		if(e.getPlayer().isOp()&&GlobalVars.updateAvariable)
		{
			boolean ok = true;
						
			for(Player p : GlobalVars.notifiedPlayers)
			{
				if(e.getPlayer().getDisplayName().equalsIgnoreCase(p.getDisplayName()))
				{
					ok = false;
					break;
				}
			}
			
			if(ok)
			{
				e.getPlayer().sendMessage(ChatColor.RED +"An update for " + ChatColor.GREEN + "EasyFireworks " + ChatColor.RED + "is available! You can get it here:");
				e.getPlayer().sendMessage(ChatColor.RED + "http://dev.bukkit.org/server-mods/easy-fireworks/");
				GlobalVars.notifiedPlayers.add(e.getPlayer());
			}
		}
	}

}
