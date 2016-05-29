package me.st1nger13.gametotemsmash;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TEMP 
{
	public static void main(String[] args)
	{
		generate(0) ;
	}
	
	public static void generate(int lvlID)
	{
		BufferedImage imgMap = null ;
		try 
		{
			imgMap = ImageIO.read(new File("assets/textures/levelsMap.png"));
			StringBuilder s = new StringBuilder() ;
			s.append("{") ;
			
			for(int j = imgMap.getHeight() - 1; j > -1; j--)
			{
				s.append(isWing(lvlID, j, imgMap) ? -1 : isWing(lvlID + 1, j, imgMap) ? 1 : 0) ;
				s.append(", ") ;
			}
			s.append("}") ;
			
			System.out.println(s.toString()) ;
		} 
		catch(IOException e) 
		{ System.err.println("Can't read levels Map image") ; }
	}
	
	private static boolean isWing(int x, int y, BufferedImage imgMap)
	{
		if((imgMap.getRGB(x,y)) < 0xffffffff)
			return true;
		return false ;
	}
}
