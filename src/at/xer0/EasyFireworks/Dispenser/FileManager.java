package at.xer0.EasyFireworks.Dispenser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.block.Dispenser;

import at.xer0.EasyFireworks.util.Logger;

public class FileManager {
	
	public static File dir = new File("plugins/EasyFireworks");
	public static File dispenserFile = new File(dir,"dispensers.data");


	
	public static void loadDispensers()
	{
	
		
		if(!dispenserFile.exists())
		{
			try
			{
				dir.mkdirs();
				dispenserFile.createNewFile();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}else
		{
			BufferedReader reader;
			
			try
			{
				reader = new BufferedReader(new FileReader(dispenserFile));
				
				while(reader.ready())
				{
					String line = reader.readLine();
					
					
						
					String[] args = line.split(",");
					
					Block b = Bukkit.getServer().getWorld(args[0]).getBlockAt(Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
					
					Dispenser dis = (Dispenser)b.getState();
					
					Blocks.dispensers.add(dis);
					
				}
				
				reader.close();
				
				Logger.info("Loaded " +Blocks.dispensers.size() + " auto-refill dispensers!");
			}
			catch(Exception e)
			{
				
			}
		}
	}
	
	public static void saveDispensers()
	{
		BufferedWriter out;
		
		try
		{
			out = new BufferedWriter(new FileWriter(dispenserFile));
			
			for(Dispenser dis:Blocks.dispensers)
			{
				Block b = dis.getBlock();
				String output = b.getWorld().getName() + "," + b.getLocation().getBlockX() + "," + b.getLocation().getBlockY() + "," + b.getLocation().getBlockZ();
				
				
				
				
				out.write(output+"\n");
			}
			
			out.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


}
