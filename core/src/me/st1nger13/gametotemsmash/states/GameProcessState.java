package me.st1nger13.gametotemsmash.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import me.st1nger13.gametotemsmash.Assets;
import me.st1nger13.gametotemsmash.Game;
import me.st1nger13.gametotemsmash.game.CountDown;
import me.st1nger13.gametotemsmash.game.GameProcess;
import me.st1nger13.gametotemsmash.utils.GuiUtils;

public class GameProcessState extends GameState
{
	private Stage stage ;
	private Image bgSprite ;
	private CountDown countDown ;
	private GameProcess game ;
	
	
	public GameProcessState(int id) 
	{
		super(id) ;
	}
	
	@Override
	public void create () 
	{
		super.create() ;
		
		game = new GameProcess() ;
		countDown = new CountDown() ;
		countDown.start() ;
		
		stage = new Stage() ;
		bgSprite = new Image(Assets.bgGame) ;
		bgSprite.setPosition(0, 0) ;
		bgSprite.setSize(Game.WIDTH, Game.HEIGHT) ;
		stage.addActor(bgSprite) ;
		
		ImageButtonStyle style = GuiUtils.createNormalImageButtonStyle(Assets.drawableBack) ;	
 		ImageButton buttonBack = new ImageButton(style) ;
		buttonBack.setPosition(40, 40);
		buttonBack.setSize(180, 60) ;
		buttonBack.addListener(new ClickListener()
		{
			@Override
			public void clicked (InputEvent event, float x, float y)
			{
				Assets.bgGameProcessMusic.stop() ;
				Game.getInstance().getStateManager().pushState(Game.MAIN_MENU) ;
			}
		}) ;
		stage.addActor(buttonBack) ;
		
		Gdx.input.setInputProcessor(stage) ;
	}
	
	@Override
	public void dispose () 
	{
		stage.dispose() ;
		sb.dispose() ;
	}
	
	@Override
	public void render () 
	{	
		Gdx.gl.glClearColor(0, 0, 0, 1) ;
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT) ;
		
		sb.begin() ;
		{
			stage.draw() ;
		}
		sb.end() ;
		
		sb.begin() ;
		{
			if(!game.isStoped())
			{
				game.update() ;	
			}
			
			game.draw(sb) ;
			
			if(!countDown.isStoped())
				countDown.drawCounter(sb) ;
			else
				game.start() ;
		}
		sb.end() ;
	}
}
