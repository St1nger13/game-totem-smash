package me.st1nger13.gametotemsmash.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.st1nger13.gametotemsmash.Assets;
import me.st1nger13.gametotemsmash.Game;
import me.st1nger13.gametotemsmash.Settings;

public class GameProcess 
{
	private boolean isStoped = true ;
	private Pillar pillar ;
	private Player player ;
	private Charge charge ;
	private boolean isPlayerMoved ;
	
	
	public GameProcess()
	{
		pillar = new Pillar(2) ;
		player = new Player() ;
		charge = new Charge(6) ;
		isPlayerMoved = false ;
		Game.getInstance().clearScore() ;
	}
	
	public void update()
	{
		pillar.update() ;
		player.update() ;
		charge.update() ;
		
		checkInputs() ;
		checkCollision() ;
		if(isPlayerMoved)
		{
			pillar.removeBottom() ;
			isPlayerMoved = false ;
			charge.increaseVolume() ; 
		}
	}
	
	public void draw(SpriteBatch sb)
	{
		pillar.draw(sb) ;
		player.draw(sb) ;
		charge.draw(sb) ;
	}
	
	public void start()
	{
		this.isStoped = false ;
	}
	
	public void stop()
	{
		this.isStoped = true ;
	}
	
	public boolean isStoped()
	{
		return isStoped ;
	}
	
	private void checkCollision()
	{
		if((player.getSidePosition() == Player.Position.LEFT && pillar.isHasLeftWing()) ||
				(player.getSidePosition() == Player.Position.RIGHT && pillar.isHasRightWing()))
		{
			Assets.playSound(Assets.dohSound) ;
			Game.getInstance().getStateManager().pushState(Game.MAIN_MENU);
		}
	}
	
	private void checkInputs()
	{
		if(Gdx.input.isKeyJustPressed(Settings.KEY_LEFT))
		{
			player.moveLeft() ;
			isPlayerMoved = true ;
		}
		if(Gdx.input.isKeyJustPressed(Settings.KEY_RIGHT))
		{
			player.moveRight() ;
			isPlayerMoved = true ;
		}
	}
}
