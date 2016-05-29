package me.st1nger13.gametotemsmash.utils;

import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

import me.st1nger13.gametotemsmash.Assets;

public class GuiUtils 
{
	public static ImageButtonStyle createNormalImageButtonStyle(Drawable drawableImage)
	{
		ImageButtonStyle style = new ImageButtonStyle();
		style.up           = Assets.drawableButton ;
		style.over 		   = Assets.drawableButtonOver ;
		style.down         = Assets.drawableButtonClicked ;
		style.imageUp      = drawableImage ;
		style.imageDown    = drawableImage ;
		style.imageChecked = drawableImage ;
		
		return style ;
	}
}
