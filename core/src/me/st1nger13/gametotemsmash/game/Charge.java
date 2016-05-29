package me.st1nger13.gametotemsmash.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import me.st1nger13.gametotemsmash.Assets;
import me.st1nger13.gametotemsmash.Game;

public class Charge 
{
	private Image bg ;
	private Image charge ;
	private float chargeVolume ;
	private long prevTime ;
	private int levelID ;
	
	
	public Charge(int levelID)
	{
		this.prevTime = System.currentTimeMillis() ;
		this.levelID = levelID * 2 ;
		bg = new Image(Assets.chargeBg) ;
		bg.setPosition(Game.SEMIWIDTH - 60, Game.HEIGHT - 270) ;
		bg.setSize(120, 70) ;
		charge = new Image(Assets.charge) ;
		charge.setPosition(Game.SEMIWIDTH - 50, Game.HEIGHT - 260) ;
		charge.setHeight(50) ;
		setFull() ;
	}
	
	public void setFull()
	{
		chargeVolume = 100 ;
		charge.setWidth(chargeVolume) ;
	}
	
	public void increaseVolume()
	{
		chargeVolume += 3 ;
		if(chargeVolume > 100)
			chargeVolume = 100 ;
		charge.setWidth(chargeVolume) ;
	}
	
	public float getVolume()
	{
		return chargeVolume ;
	}
	
	public void draw(SpriteBatch sb)
	{
		bg.draw(sb, 1f) ;
		charge.draw(sb, 1f) ;
	}
	
	public void update()
	{
		long currentTime = System.currentTimeMillis() ;
		if(currentTime - prevTime > 1000)
		{	
			chargeVolume -= levelID ;
			charge.setWidth(chargeVolume) ;
			prevTime = currentTime ;
			System.out.println(".");
		}
	}
}
