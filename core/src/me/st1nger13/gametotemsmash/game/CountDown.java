package me.st1nger13.gametotemsmash.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import me.st1nger13.gametotemsmash.Assets;
import me.st1nger13.gametotemsmash.Game;

public class CountDown 
{
	public static int WAIT_IN_SEC = 5 ;
	private int counter ;
	private long delay = 1000l ;
	private long lastTime ;
	private TextureRegion label ;
	private boolean isStoped ;
	
	
	public CountDown()
	{
		counter = 0 ;
		lastTime = 0 ;
		stop() ;
	}
	
	public void start()
	{
		isStoped = false ;
		counter = 0 ;
	}
	
	public void stop()
	{
		isStoped = true ;
	}
	
	public boolean isStoped()
	{
		return isStoped ;
	}
	
	public void count()
	{
		if(counter < WAIT_IN_SEC)
		{
			long currentTime = System.currentTimeMillis() ;
			if(currentTime - delay >= lastTime)
			{
				lastTime = currentTime ;
				Assets.playSound(Assets.tickSound) ;
				counter++ ;
			}
		}
		else
		{
			//Assets.bgGameProcessMusic.play() ;
			stop() ;
		}
	}
	
	public void drawCounter(SpriteBatch sb)
	{
		count() ;
		
		switch(counter)
		{
			case 1 : label = Assets.three ; break ;
			case 2 : label = Assets.two ; break ;
			case 3 : label = Assets.one ; break ;
			case 4 : label = Assets.go ; break ;
		}
		
		sb.draw(label, Game.SEMIWIDTH - label.getRegionWidth(), 
				Game.SEMIHEIGHT - label.getRegionHeight(), label.getRegionWidth() * 2, label.getRegionHeight() * 2) ;
	}
	
	public int getCounter()
	{
		return WAIT_IN_SEC - 1 - counter ;
	}
}
