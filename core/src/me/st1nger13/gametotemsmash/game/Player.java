package me.st1nger13.gametotemsmash.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import me.st1nger13.gametotemsmash.Assets;
import me.st1nger13.gametotemsmash.Game;

public class Player 
{
	public enum Position { LEFT, RIGHT } ;
	
	private Position sidePosition ;
	private Image playerImage ;
	
	
	public Player()
	{
		playerImage = new Image(Assets.player) ;
		playerImage.setSize(Game.PLAYER_WIDTH, Game.PLAYER_HEIGHT) ;
		this.moveLeft() ;
	}
	
	public void update()
	{
		
	}
	
	public void draw(SpriteBatch sb)
	{
		playerImage.draw(sb, 1f) ;
	}
	
	public Position getSidePosition()
	{
		return sidePosition ;
	}
	
	public void remove()
	{
		playerImage.remove() ;
	}
	
	public void moveLeft()
	{
		this.setSidePosition(Position.LEFT) ;
	}
	
	public void moveRight()
	{
		this.setSidePosition(Position.RIGHT) ;
	}
	
	public void setSidePosition(Position pos)
	{
		if(pos == Position.LEFT)
		{
			sidePosition = Position.LEFT ;
			playerImage.setPosition(Game.SEMIWIDTH - Game.TOTEM_WIDTH / 2 - Game.PLAYER_WIDTH - 10, Game.FALL_STEP) ;
		}
		else
		{
			sidePosition = Position.RIGHT ;
			playerImage.setPosition(Game.SEMIWIDTH + Game.TOTEM_WIDTH / 2 + 10, Game.FALL_STEP) ;
		}
	}
}
