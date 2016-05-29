package me.st1nger13.gametotemsmash.utils;

import java.util.Random;

public class GameUtils 
{
	public static final Random random = new Random(System.currentTimeMillis()) ;
	
	
	public static boolean checkPlayerName(String name)
	{
		if(name == null)
			return false ;
		if(name.length() < 3)
			return false ;
		
		return true ;
	}
}
