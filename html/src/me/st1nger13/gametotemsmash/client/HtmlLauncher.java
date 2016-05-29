package me.st1nger13.gametotemsmash.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import me.st1nger13.gametotemsmash.Game;

public class HtmlLauncher extends GwtApplication 
{
    @Override
    public GwtApplicationConfiguration getConfig () 
    {
    	return new GwtApplicationConfiguration(Game.WIDTH, Game.HEIGHT) ;
    }

    @Override
    public ApplicationListener createApplicationListener () 
    {
    	return new Game() ;
    }
}