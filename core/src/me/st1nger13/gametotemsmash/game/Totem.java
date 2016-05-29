package me.st1nger13.gametotemsmash.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import me.st1nger13.gametotemsmash.Assets;
import me.st1nger13.gametotemsmash.Game;

public class Totem
{
	public static final int T1 = 0 ;
	public static final int T2 = 1 ;
	public static final int T3 = 2 ;
	public static final int T4 = 3 ;
	public static final int W1 = 0 ;
	public static final int W2 = 1 ;
	public static final int W3 = 2 ;
	
	private Image bodyImage ;
	private Image wingImage ;
	/** Wing position: -1 (left), 0 (no wing), +1 (right) */
	private int wingPosition ;
	
	public Totem(int type, int wingPosition, int wingType)
	{
		switch(type)
		{
			case T1 : bodyImage = new Image(Assets.totemT1) ; break ;
			case T2 : bodyImage = new Image(Assets.totemT2) ; break ;
			case T3 : bodyImage = new Image(Assets.totemT3) ; break ;
			case T4 : bodyImage = new Image(Assets.totemT4) ; break ;
			default : bodyImage = new Image(Assets.totemT1) ; break ;
		}
		this.bodyImage.setSize(Game.TOTEM_WIDTH, Game.TOTEM_HEIGHT) ;
		this.wingPosition = wingPosition ;
		
		if(wingPosition != 0)
		{
			TextureRegion textureRegion ;
			switch(wingType)
			{
				case W1 : textureRegion = new TextureRegion(Assets.wingW1) ; break ;
				case W2 : textureRegion = new TextureRegion(Assets.wingW2) ; break ;
				case W3 : textureRegion = new TextureRegion(Assets.wingW3) ; break ;
				default : textureRegion = new TextureRegion(Assets.wingW1) ; break ;
			}
			textureRegion.flip(((wingPosition == 1) ? true : false), false) ;
			wingImage = new Image(textureRegion) ;
			wingImage.setSize(Game.TOTEM_WIDTH, wingImage.getHeight()) ;
		}
	}
	
	public void setY(int y)
	{
		this.setPosition((int) bodyImage.getX(), y) ;
	}
	
	public void setPosition(int x, int y)
	{
		bodyImage.setPosition(x, y) ;
		if(wingPosition == -1)
			wingImage.setPosition(x - Game.TOTEM_WIDTH, y + Game.TOTEM_HEIGHT - wingImage.getHeight()) ;
		if(wingPosition == 1)
			wingImage.setPosition(x + Game.TOTEM_WIDTH, y + Game.TOTEM_HEIGHT - wingImage.getHeight()) ;
	}

	public int getWingPosition()
	{
		return wingPosition ;
	}
	
	public void draw(SpriteBatch sb)
	{
		bodyImage.draw(sb, 1f) ;
		if(wingPosition != 0)
			wingImage.draw(sb, 1f) ;
	}
	
	public void remove()
	{
		bodyImage.remove() ;
		if(wingPosition != 0)
			wingImage.remove() ;
	}
	
	public int getY()
	{
		return (int) (bodyImage.getY()) ;
	}
}
