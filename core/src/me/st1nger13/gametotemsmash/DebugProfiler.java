package me.st1nger13.gametotemsmash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.st1nger13.gametotemsmash.states.GameState;

public class DebugProfiler 
{
	private BitmapFont font ;
	private SpriteBatch sb ;
	
	
	public DebugProfiler()
	{
		this.sb = new SpriteBatch() ;
		font = new BitmapFont() ;
        font.setColor(Color.WHITE) ;
	}
	
	public void render()
	{
		sb.begin() ;
		{
			font.draw(sb, "State: " + getCurrentStateName(), 4, Gdx.graphics.getHeight() - 10) ;
			font.draw(sb, "Mouse: " + Gdx.input.getX() + " : " + Gdx.input.getY(), 4, Gdx.graphics.getHeight() - 24) ;
			font.draw(sb, "Player: " + Game.getInstance().getPlayerName(), 4, Gdx.graphics.getHeight() - 38) ;
			font.draw(sb, "Score: " + Game.getInstance().getPlayerScore(), 4, Gdx.graphics.getHeight() - 52) ;
		}
		sb.end() ;
	}
	
	public void dispose() 
	{
        font.dispose() ;
    }
	
	private String getCurrentStateName()
	{
		GameState state = Game.getInstance().getStateManager().getCurrentState() ;
		if(state == null)
			return "NULL" ;
		return state.getClass().getSimpleName() ;
	}
}
