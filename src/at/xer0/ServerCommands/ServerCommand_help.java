package at.xer0.ServerCommands;

import at.xer0.util.Logger;


public class ServerCommand_help {
	
	public static void fire()
	{
		Logger.info("You can only use this commands with the console:");
		Logger.info("fw give <player> <ammount> {random | (<colors> <effect> <power>)}");
		Logger.info("##############################################");
	}

}
