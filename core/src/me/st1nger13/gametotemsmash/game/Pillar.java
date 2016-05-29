package me.st1nger13.gametotemsmash.game;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.st1nger13.gametotemsmash.Assets;
import me.st1nger13.gametotemsmash.Game;

public class Pillar 
{
	private int[] wingsMask = {1, 0, -1, 0, -1, 0, 1, 0, -1, 0, 1, 1, 0, -1, 0, 1, 0, -1, 0, -1, 0, 1, 0, -1, 0, 1, 0, 0, -1, -1, 0, 1, 0, 1, 0, -1, 0, 1, 1, 0, -1, -1, 0, 1, 1, 0, 0, -1, 0, 1} ;
	private ArrayList<Totem> totems ;
	
	
	public Pillar(int levelID)
	{
		totems = new ArrayList<Totem>() ;
		prepareLevel(levelID) ;
	}
	
	public boolean isHasLeftWing()
	{
		if(totems.size() > 0 && totems.get(0).getWingPosition() == -1)
			return true ;
		return false ;
	}
	
	public boolean isHasRightWing()
	{
		if(totems.size() > 0 && totems.get(0).getWingPosition() == 1)
			return true ;
		return false ;
	}
	
	public void update()
	{
		if(totems.size() > 0 && totems.get(0).getY() >= Game.FLOOR_HEIGHT)
		{
			for(Totem totem : totems)
			{
				totem.setY(totem.getY() - Game.FALL_STEP) ;
			}	
		}
	}
	
	public void draw(SpriteBatch sb)
	{
		if(totems.size() > 0)
		{
			for(Totem totem : totems)
			{
				if(totem.getY() > Game.HEIGHT)
					continue ;		
				totem.draw(sb) ;
			}
		}
	}
	
	public void removeBottom()
	{
		if(totems.size() > 0 && totems.get(0).getY() < Game.FLOOR_HEIGHT + Game.TOTEM_HEIGHT)
		{
			totems.get(0).remove() ;
			totems.remove(0) ;
			
			// TODO:
			Game.getInstance().increaseScore() ;
			Assets.playSound(Assets.dropSound) ;
		}
	}
	
	private void prepareLevel(int levelID)
	{
		Totem totem ;
		Random random = new Random(System.currentTimeMillis()) ;
		int currentX = Game.SEMIWIDTH - Game.TOTEM_WIDTH / 2 ;
		int currentY ;
		for (int i = 0; i < wingsMask.length; i++) 
		{
			totem = new Totem(random.nextInt(3), wingsMask[i], 1) ; //(i%2==0)?1:-1
			currentY = Game.FLOOR_HEIGHT + Game.TOTEM_HEIGHT * i ;
			totem.setPosition(currentX, currentY) ;
			totems.add(totem) ;
		}
	}
}
