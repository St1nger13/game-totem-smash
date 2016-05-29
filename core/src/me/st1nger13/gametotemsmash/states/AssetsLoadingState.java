package me.st1nger13.gametotemsmash.states;

import me.st1nger13.gametotemsmash.Assets;
import me.st1nger13.gametotemsmash.Game;

public class AssetsLoadingState extends GameState
{	
	public AssetsLoadingState(int id) 
	{
		super(id) ;
	}
	
	@Override
	public void create () 
	{
		super.create() ;
		Assets.load() ;
		Game.getInstance().getStateManager().pushState(Game.ENTER_NAME) ;
	}

	@Override
	public void render () 
	{

	}
}
