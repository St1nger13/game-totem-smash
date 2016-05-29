package me.st1nger13.gametotemsmash.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import me.st1nger13.gametotemsmash.Assets;
import me.st1nger13.gametotemsmash.Game;
import me.st1nger13.gametotemsmash.utils.GameUtils;

public class EnterNameState extends GameState
{
	private Stage stage ;
	private Skin skin ;
	private TextField inputField ;
	
	Texture texture ;
	
	
	public EnterNameState(int id) 
	{
		super(id) ;
	}

	
	@Override
	public void create () 
	{
		super.create() ;
		
		stage = new Stage() ;
		skin = Assets.skin ;

		inputField = new TextField("", skin) ;
		inputField.setPosition(250, 200) ;
		inputField.setSize(200, 40) ;
		inputField.setAlignment(1) ;
		inputField.setFocusTraversal(true) ;
		stage.addActor(inputField) ;
		
		TextButton button = new TextButton("Ok", skin) ;
		button.setPosition(460, 200) ;
		button.setSize(90, 40) ;
		button.addListener(new ClickListener()
		{
			@Override
			public void clicked (InputEvent event, float x, float y)
			{
				String playerName = EnterNameState.this.inputField.getText() ;
				if(GameUtils.checkPlayerName(playerName))
				{
					Assets.playSound(Assets.tickSound) ;
					Game.getInstance().setName(playerName) ;
					Game.getInstance().getStateManager().pushState(Game.MAIN_MENU) ;
				}
			}
		}) ;
		stage.addActor(button) ;
		
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
	}
}
