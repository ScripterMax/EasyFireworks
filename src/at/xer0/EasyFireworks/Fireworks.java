package at.xer0.EasyFireworks;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import at.xer0.EasyFireworks.Dispenser.FileManager;
import at.xer0.EasyFireworks.Manager.CommandManager;
import at.xer0.EasyFireworks.Manager.ConfigManager;
import at.xer0.EasyFireworks.Manager.EventManager;
import at.xer0.EasyFireworks.util.GlobalVars;
import at.xer0.EasyFireworks.util.Logger;


public class Fireworks extends JavaPlugin implements Listener
{
	
	public void onEnable()
	{

		getCommand("fw").setExecutor(new CommandManager());
		FileManager.loadDispensers();
		getServer().getPluginManager().registerEvents(new EventManager(), this);
		
		ConfigManager.loadConfig();
		
		if(GlobalVars.checkForUpdate)
		{
			Logger.info("Checking for update...");
			
			if(!getDescription().getVersion().equals(getRemoteVersion()))
			{
				GlobalVars.updateAvariable = true;
				Logger.info("Update available! New Version: " + getRemoteVersion());
				
			}else
			{
				Logger.info("Version up to date!");
			}
		}

	}
	
	public void onDisable()
	{
		GlobalVars.updateAvariable = false;
		GlobalVars.notifiedPlayers.clear();
	}
	
	  private static String getRemoteVersion() {
		  
		  try{
		        URL website = new URL("http://www.xeroserver.bplaced.net/bukkit/easy-fireworks/version");
		        
		        URLConnection connection = website.openConnection();
		        
		        BufferedReader in = new BufferedReader(
		                                new InputStreamReader(
		                                    connection.getInputStream()));

		        StringBuilder response = new StringBuilder();
		        String inputLine;

		        while ((inputLine = in.readLine()) != null) 
		        {
		            response.append(inputLine);
		        }

		        in.close();
		        
		        return response.toString();

		  }catch(Exception e){e.printStackTrace();}
		  
		  return "ERROR";


	    }
	
}



