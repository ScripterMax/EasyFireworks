package at.xer0.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Builder;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

public class RocketProvider {
	
	
	//This Method by http://cnapagoda.blogspot.co.at/2011/03/java-hex-color-code-generator.html
	private static HashMap<Integer, String> randomCodeGenerator(){
		  HashMap<Integer, String> hexColorMap = new HashMap<Integer, String>();
		  for(int a=0;a < 1; a++){
		   String code = ""+(int)(Math.random()*256);
		   code = code+code+code;
		   int  i = Integer.parseInt(code);
		 
		    
		   hexColorMap.put(1,Integer.toHexString( 0x1000000 | i).substring(1).toUpperCase());
		  }
		 return hexColorMap;
		 }
	//End
	
	
	public static ItemStack getPredefinedRocket(String color,String effect,String power,Player p,String ammount)
	{
		ItemStack i = new ItemStack(Material.FIREWORK, Integer.parseInt(ammount));
        FireworkMeta fm = (FireworkMeta) i.getItemMeta();
        
        List<Color> c = new ArrayList<Color>();
        List<Type> fx = new ArrayList<Type>(); 
        

        
		for (String cr : color.split("-"))
		{
			if(cr.equalsIgnoreCase("r"))
			{
				c.add(Color.RED);
			}else
				if(cr.equalsIgnoreCase("g"))
				{
					c.add(Color.GREEN);
				}else
					if(cr.equalsIgnoreCase("y"))
					{
						c.add(Color.YELLOW);
					}else
						if(cr.equalsIgnoreCase("b"))
						{
							c.add(Color.BLUE);
						}else
							if(cr.equalsIgnoreCase("w"))
							{
								c.add(Color.WHITE);
							}else
								if(cr.equalsIgnoreCase("bl"))
								{
									c.add(Color.BLACK);
								}
								else
									if(cr.substring(0,1).equalsIgnoreCase("#"))
									        {
									        	String hexCode = cr.substring(1);
									        	
									        	try{
									        		
										        	int rgb = Integer.parseInt(hexCode, 16);
										        	c.add(Color.fromRGB(rgb));
										        	
									        	}catch(Exception e){
									        		
													p.sendMessage(ChatColor.RED + "You didn't input a valid HEX code. Use format: #FFFF00");
													c.add(Color.WHITE);

									        		
									        	}
									        	

									        }
			
						
						
						else
						{
							p.sendMessage(ChatColor.RED + "Found a known color! Using White instead!");
							c.add(Color.WHITE);
						}
		}
		
		boolean creeper = false;
		boolean ball = false;
		boolean bigball = false;
		boolean burst = false;
		boolean star = false;
		boolean trail = false;
		boolean flicker = false;


		for(String efx : effect.split("-"))
		{
			if(efx.equalsIgnoreCase("c") && !creeper)
			{
				fx.add(Type.CREEPER);
				creeper = true;
			}else
				if(efx.equalsIgnoreCase("s") && !star)
				{
					fx.add(Type.STAR);
					star = true;

				}else
					if(efx.equalsIgnoreCase("x") && !burst)
					{
						fx.add(Type.BURST);
						burst = true;

					}else
						if(efx.equalsIgnoreCase("b") && !bigball)
						{
							fx.add(Type.BALL_LARGE);
							bigball = true;

						}else
							if(efx.equalsIgnoreCase("n") && !ball)
							{
								fx.add(Type.BALL);
								ball = true;

							}else
								if(efx.equalsIgnoreCase("f") && !flicker)
								{
									flicker = true;

								}else
									if(efx.equalsIgnoreCase("t") && !trail)
									{
										fx.add(Type.BALL);
										trail = true;
										
									}
							
		}

	
		 Builder eff = FireworkEffect.builder();

		 for(Type t : fx)
		 {
			 eff.with(t);
		 }
		 
		 eff.withColor(c);

		 
		 if(flicker)
		 {
			 eff.flicker(true);
			 eff.with(Type.BALL);
		 }
		 
		 if(trail)
		 {
			 eff.trail(true);
		 }
		 
		 
		 fm.addEffect(eff.build());

		 
		 
		 
		
        
        if(power.equalsIgnoreCase("0")
        		||power.equalsIgnoreCase("1")
        		||power.equalsIgnoreCase("2")
        		||power.equalsIgnoreCase("3"))
        {
        	fm.setPower(Integer.parseInt(power));
        	fm.setDisplayName("EasyFirework");

        }else
        {
			p.sendMessage(ChatColor.RED + "Not known power! Using smallest power instead!");
			fm.setPower(0);
        }

       
        i.setItemMeta(fm);
       
        return i;
		}
	

	
	public static ItemStack getRandomRocket(Player p,String ammount)
	{
		int power = (int) (Math.ceil(Math.random()*(0-3))+3);
		int colors = (int) (Math.ceil(Math.random()*(0-6))+6);
		String colorString = "";
		String effect = "";
		
		for(int x = 1;x<=colors;x++)
		{
			colorString += "#"+randomCodeGenerator().get(1).toString()+"-";
		}
		
		try{
		
		colorString = colorString.substring(0, colorString.length() - 1);
		
		}catch(Exception ex){}

		for(int x =1; x<= (int) (Math.ceil(Math.random()*(0-7))+7);x++)		
		{
			int effectRand = (int) (Math.ceil(Math.random()*(0-7))+7);
			switch(effectRand)
			{
			case 1: effect += "c-";
			break;
			case 2: effect += "x-";
			break;
			case 3: effect += "s-";
			break;
			case 4: effect += "b-";
			break;
			case 5: effect += "n-";
			break;
			case 6: effect += "f-";
			break;
			case 7: effect += "t-";
			break;
			}
		}

		effect = effect.substring(0, effect.length() - 1);

		
		return getPredefinedRocket(colorString,effect,""+power,p,ammount);
		
		
		
	}
}





