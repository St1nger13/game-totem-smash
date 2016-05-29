package me.st1nger13.gametotemsmash.states;

import java.util.Stack;

import me.st1nger13.gametotemsmash.Game;

public class StateManager 
{
	private Stack<GameState> states ;
	
	
	public StateManager()
	{
		states = new Stack<GameState>() ;
	}
	
	public GameState getCurrentState()
	{
		return states.peek() ;
	}
	
	public void pushState(int stateID)
	{
		if(stateID == Game.ASSETS_LOADING)
			push(new AssetsLoadingState(stateID)) ;
		if(stateID == Game.MAIN_MENU)
			push(new MainMenuState(stateID)) ;
		if(stateID == Game.GAME_PROCESS)
			push(new GameProcessState(stateID)) ;
		if(stateID == Game.ENTER_NAME)
			push(new EnterNameState(stateID)) ;
		
		createCurrentState() ;
	}
	
	public void createCurrentState()
	{
		if(states.peek() != null)
			states.peek().create() ;
	}
	
	public void renderCurrentState()
	{
		if(states.peek() != null)
			states.peek().render() ;
	}
	
	private void push(GameState state)
	{
		if(states.size() > 0 && states.peek() != null)
			states.peek().dispose() ;
		state.create() ;
		states.push(state) ;
	}
}
