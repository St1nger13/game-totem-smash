package me.st1nger13.gametotemsmash.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import me.st1nger13.gametotemsmash.Game;

public class DesktopLauncher 
{
	public static void main (String[] arg) 
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration() ;
			config.width = Game.WIDTH ;
			config.height = Game.HEIGHT ;
		new LwjglApplication(new Game(), config) ;
	}
}
