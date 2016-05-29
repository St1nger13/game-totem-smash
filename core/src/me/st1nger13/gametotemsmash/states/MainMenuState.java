package me.st1nger13.gametotemsmash.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import me.st1nger13.gametotemsmash.Assets;
import me.st1nger13.gametotemsmash.Game;
import me.st1nger13.gametotemsmash.utils.GuiUtils;

public class MainMenuState extends GameState
{
	private Stage stage ;
	
	
	public MainMenuState(int id) 
	{
		super(id) ;
	}

	
	@Override
	public void create () 
	{
		super.create() ;
		stage = new Stage() ;
		Skin skin = Assets.skin ;
		
		ImageButtonStyle style = GuiUtils.createNormalImageButtonStyle(Assets.drawablePlay) ;	
		ImageButton playBtn = new ImageButton(style) ;
		playBtn.setPosition(300, 300) ;
		playBtn.setSize(260, 50) ;
		playBtn.addListener(new ClickListener()
		{
			@Override
			public void clicked (InputEvent event, float x, float y)
			{
				Game.getInstance().getStateManager().pushState(Game.GAME_PROCESS) ;
			}
		}) ;
		stage.addActor(playBtn) ;
		
		style = GuiUtils.createNormalImageButtonStyle(Assets.drawableLeaders) ;
		ImageButton leaderboardBtn = new ImageButton(style) ;
		leaderboardBtn.setPosition(300, 240) ;
		leaderboardBtn.setSize(260, 50) ;
		leaderboardBtn.addListener(new ClickListener()
		{
			@Override
			public void clicked (InputEvent event, float x, float y)
			{
			}
		}) ;
		stage.addActor(leaderboardBtn) ;
		
		Gdx.input.setInputProcessor(stage) ;
	}

	@Override
	public void render () 
	{
		Gdx.gl.glClearColor(1, 0, 1, 1) ;
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT) ;
		
		sb.begin() ;
		{
			stage.draw() ;
		}
		sb.end() ;
		
		if(Gdx.input.isKeyPressed(Input.Keys.ENTER))
			Game.getInstance().getStateManager().pushState(Game.GAME_PROCESS) ; 
	}
}
