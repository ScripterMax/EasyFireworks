package at.xer0.EasyFireworks.Manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import at.xer0.EasyFireworks.util.GlobalVars;

public class ConfigManager {
	
	public static File configFile = new File(FileManager.dir,"config.txt");	
	
	public static void createConfig()
	{
		
		try {
			configFile.createNewFile();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
		BufferedWriter out;
		
		try
		{
			out = new BufferedWriter(new FileWriter(configFile));
			
			out.write("checkForUpdate:true");

			out.flush();
			out.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void loadConfig()
	{
		if(!configFile.exists())
		{
			createConfig();
		}
		
		BufferedReader reader;
		
		try
		{
			reader = new BufferedReader(new FileReader(configFile));
			
			while(reader.ready())
			{
				String line = reader.readLine();
				
				String[] args = line.split(":");
				
				if(args[0].equalsIgnoreCase("checkForUpdate"))
				{
					GlobalVars.checkForUpdate = Boolean.parseBoolean(args[1]);
				}
				

			}
			
			reader.close();
			
		}
		catch(Exception e)
		{
			
		}
	}
	

}
