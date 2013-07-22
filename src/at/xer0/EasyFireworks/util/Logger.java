package at.xer0.EasyFireworks.util;

public class Logger {
	
	public static void info(String msg)
	{
		System.out.println("[Easy_Fireworks] "+msg);
	}
	
	public static void warning(String msg)
	{
		System.out.println("[Warning] [Easy_Fireworks] "+msg);
	}
	
	public static void error(String msg)
	{
		System.out.println("[Error] [Easy_Fireworks] "+msg);
	}
}
