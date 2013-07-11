package at.xer0.util;

import org.bukkit.entity.Player;

import at.xer0.Commands.Command_colors;
import at.xer0.Commands.Command_effects;
import at.xer0.Commands.Command_fillup;
import at.xer0.Commands.Command_getdef;
import at.xer0.Commands.Command_getrandom;
import at.xer0.Commands.Command_givedef;
import at.xer0.Commands.Command_giverandom;
import at.xer0.Commands.Command_help;
import at.xer0.Commands.Command_lists;
import at.xer0.Commands.Command_power;
import at.xer0.Commands.Command_usage;
import at.xer0.ServerCommands.ServerCommand_givedef;
import at.xer0.ServerCommands.ServerCommand_giverandom;
import at.xer0.ServerCommands.ServerCommand_help;

public class CommandDistributer {
	
	private static Player p = null;
	private static String[] args = null;

	
	public CommandDistributer(Player pp,String[] argss)
	{
		p = pp;
		args = argss;
	}
	
	public void help()
	{
		Command_help.fire(p);
	}
	
	public void lists()
	{
		Command_lists.fire(p);
	}
	
	public void colors()
	{
		Command_colors.fire(p);
	}
	
	public void effects()
	{
		Command_effects.fire(p);
	}
	
	public void usage()
	{
		Command_usage.fire(p);
	}
	
	public void power()
	{
		Command_power.fire(p);
	}
	
	public void fillup()
	{
		Command_fillup.fire(p);
	}
	
	public void giverandom()
	{
		Command_giverandom.fire(p,args);
	}
	
	public void givedef()
	{
		Command_givedef.fire(p,args);
	}
	
	public void server_giverandom()
	{
		ServerCommand_giverandom.fire(args);
	}
	
	public void server_givedef()
	{
		ServerCommand_givedef.fire(args);
	}
	
	public void server_help()
	{
		ServerCommand_help.fire();
	}
	
	public void getdef()
	{
		Command_getdef.fire(p,args);
	}
	
	public void getrandom()
	{
		Command_getrandom.fire(p,args);
	}

}
