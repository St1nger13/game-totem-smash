package me.st1nger13.gametotemsmash.states;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class GameState extends ApplicationAdapter 
{
	protected int id ;
	protected SpriteBatch sb ;
	
	
	public GameState(int id)
	{
		this.id = id ;
	}
	
	@Override
	public void create()
	{
		this.sb = new SpriteBatch() ;
	}
	
	public int getID()
	{
		return id ;
	}
}
