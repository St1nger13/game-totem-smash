package me.st1nger13.gametotemsmash;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.assets.AssetManager;
import me.st1nger13.gametotemsmash.states.StateManager;

public class Game extends ApplicationAdapter 
{
	public static final int WIDTH = 900 ;
	public static final int HEIGHT = 540 ;
	public static final int SEMIWIDTH = WIDTH / 2 ;
	public static final int SEMIHEIGHT = HEIGHT /2 ;
	
	public static final int ASSETS_LOADING = 99 ;
	public static final int ENTER_NAME = 100 ;
	public static final int MAIN_MENU = 101 ;
	public static final int GAME_PROCESS = 102 ;
	
	public static final int PILLAR_MAX_HEIGHT = 50 ;
	public static final int FALL_STEP = 15 ;
	public static final int FLOOR_HEIGHT = 50 ;
	public static final int TOTEM_WIDTH = 90 ;
	public static final int TOTEM_HEIGHT = 80 ;
	public static final int PLAYER_WIDTH = 90 ;
	public static final int PLAYER_HEIGHT = 110 ;
	
	private static Game instance ;
	
	private StateManager stateManager ;
	private DebugProfiler debugProfiler ;
	private AssetManager assets ;
	private String playerName ;
	private int playerScore ;
	
	
	public Game()
	{
		instance = this ;
		stateManager = new StateManager() ;
		playerName = "Guest" ;
		playerScore = 0 ;
	}
	
	public static Game getInstance()
	{
		return instance ;
	}
	
	public StateManager getStateManager()
	{
		return stateManager ;
	}
	
	public AssetManager getAssets()
	{
		return assets ;
	}
	
	public String getPlayerName()
	{
		return playerName ;
	}
	
	public int getPlayerScore()
	{
		return playerScore ;
	}
	
	public void setName(String name)
	{
		this.playerName = name ;
	}
	
	public void increaseScore()
	{
		this.playerScore++ ;
	}
	
	public void clearScore()
	{
		this.playerScore = 0 ;
	}
	
	@Override
	public void create () 
	{
		debugProfiler = new DebugProfiler() ;
		assets = new AssetManager() ;
		
		stateManager.pushState(ASSETS_LOADING) ;
	}

	@Override
	public void render () 
	{
		stateManager.renderCurrentState() ;
		debugProfiler.render() ;
	}
}
