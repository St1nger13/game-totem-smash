package me.st1nger13.gametotemsmash.game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import me.st1nger13.gametotemsmash.Game;

public class Levels 
{
	public static final int[] LEVEL_1 = generateLevel(1) ;
	public static final int[] LEVEL_2 = generateLevel(2) ;
	public static final int[] LEVEL_3 = generateLevel(3) ;
	public static final int[] LEVEL_4 = generateLevel(4) ;
	public static final int[] LEVEL_5 = generateLevel(5) ;
	public static final int[] LEVEL_6 = generateLevel(6) ;
	public static final int[] LEVEL_7 = generateLevel(7) ;
	public static final int[] LEVEL_8 = generateLevel(8) ;
	public static final int[] LEVEL_9 = generateLevel(9) ;
	
	
	public static int[] getLevel(int levelID)
	{
		switch(levelID)
		{
			case 1 : return LEVEL_1 ;
			case 2 : return LEVEL_2 ;
			case 3 : return LEVEL_3 ;
			case 4 : return LEVEL_4 ;
			case 5 : return LEVEL_5 ;
			case 6 : return LEVEL_6 ;
			case 7 : return LEVEL_7 ;
			case 8 : return LEVEL_8 ;
			case 9 : return LEVEL_9 ;
			default : return LEVEL_1 ;
		}
	}
	
	private static int[] generateLevel(int levelID)
	{
		int[] levelMask = new int[Game.PILLAR_MAX_HEIGHT] ;
		levelMask[0] = 1 ;
		Random rnd = new Random(System.currentTimeMillis()) ;
		BufferedImage imgMap = null ;
		try 
		{
			imgMap = ImageIO.read(new File("textures/levelsMap.png"));
		} catch (IOException e) { System.err.println("Can't read levels Map image") ; }
		
		for (int i = 1; i < Game.PILLAR_MAX_HEIGHT; i++)
		{
			levelMask[i] = (isWing((levelID - 1) * 2, i, imgMap)) ? -1 : (isWing((levelID) * 2, i, imgMap)) ? 1 : 0 ;
			switch(levelMask[i-1])
			{
				case 0 : levelMask[i] = rnd.nextInt(3) - 1 ; break ;
				case -1 : levelMask[i] = (rnd.nextBoolean()) ? -1 : 0 ; break ;
				case 1 : levelMask[i] = (rnd.nextBoolean()) ? 1 : 0 ; break ;
			}
			
			System.out.println(levelMask[i]);
		}
		
		return levelMask ;
	}
	
	private static boolean isWing(int x, int y, BufferedImage imgMap)
	{
		if((imgMap.getRGB(x,y) >> 24) == 0x00)
			return true;
		return false ;
	}
}
