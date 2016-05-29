package me.st1nger13.gametotemsmash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class Assets 
{
	public static GlyphLayout layout ;
	public static TextureAtlas atlas ;
	
	public static TextureRegion bgGame ;
	public static TextureRegion go ;
	public static TextureRegion one ;
	public static TextureRegion two ;
	public static TextureRegion three ;
	public static TextureRegion four ;
	public static TextureRegion five ;
	public static TextureRegion six ;
	public static TextureRegion seven ;
	public static TextureRegion eight ;
	public static TextureRegion nine ;
	public static TextureRegion zero ;
	public static TextureRegion back ;
	public static TextureRegion play ;
	public static TextureRegion leaders ;
	public static TextureRegion button ;
	public static TextureRegion buttonOver ;
	public static TextureRegion buttonClicked ;
	public static TextureRegion totemT1 ;
	public static TextureRegion totemT2 ;
	public static TextureRegion totemT3 ;
	public static TextureRegion totemT4 ;
	public static TextureRegion wingW1 ;
	public static TextureRegion wingW2 ;
	public static TextureRegion wingW3 ;
	public static TextureRegion player ;
	public static TextureRegion chargeBg ;
	public static TextureRegion charge ;
	
	public static Drawable drawableButton ;
	public static Drawable drawableButtonOver ;
	public static Drawable drawableButtonClicked ;
	public static Drawable drawableBack ;
	public static Drawable drawablePlay ;
	public static Drawable drawableLeaders ;
	
	public static BitmapFont font ;
	public static Skin skin ;
	public static Music bgGameProcessMusic ;
	public static Sound tickSound ;
	public static Sound dropSound ;
	public static Sound screamingSound ;
	public static Sound dohSound ;

	
	public static Texture loadTexture (String file) 
	{
		return new Texture(Gdx.files.internal(file));
	}

	public static void load () 
	{
		layout = new GlyphLayout() ;
		atlas = new TextureAtlas(Gdx.files.internal("textures/packtextures.atlas")) ;
		
		bgGame = new TextureRegion(atlas.findRegion("bg")) ;
		go = new TextureRegion(atlas.findRegion("go")) ;
		one = new TextureRegion(atlas.findRegion("1")) ;
		two = new TextureRegion(atlas.findRegion("2")) ;
		three = new TextureRegion(atlas.findRegion("3")) ;
		four = new TextureRegion(atlas.findRegion("4")) ;
		five = new TextureRegion(atlas.findRegion("5")) ;
		six = new TextureRegion(atlas.findRegion("6")) ;
		seven = new TextureRegion(atlas.findRegion("7")) ;
		eight = new TextureRegion(atlas.findRegion("8")) ;
		nine = new TextureRegion(atlas.findRegion("9")) ;
		zero = new TextureRegion(atlas.findRegion("0")) ;
		back = new TextureRegion(atlas.findRegion("back")) ;
		play = new TextureRegion(atlas.findRegion("play")) ;
		leaders = new TextureRegion(atlas.findRegion("leaders")) ;
		button = new TextureRegion(atlas.findRegion("button")) ;
		buttonOver = new TextureRegion(atlas.findRegion("button_over")) ;
		buttonClicked = new TextureRegion(atlas.findRegion("button_clicked")) ;
		totemT1 = new TextureRegion(atlas.findRegion("t1")) ;
		totemT2 = new TextureRegion(atlas.findRegion("t2")) ;
		totemT3 = new TextureRegion(atlas.findRegion("t3")) ;
		totemT4 = new TextureRegion(atlas.findRegion("t4")) ;
		wingW1 = new TextureRegion(atlas.findRegion("w1")) ;
		wingW2 = new TextureRegion(atlas.findRegion("w2")) ;
		wingW3 = new TextureRegion(atlas.findRegion("w3")) ;
		player = new TextureRegion(atlas.findRegion("player")) ;
		charge = new TextureRegion(atlas.findRegion("charge")) ;
		chargeBg = new TextureRegion(atlas.findRegion("charge_bg")) ;
		
		drawableButton = new Image(button).getDrawable() ;
		drawableButtonOver = new Image(buttonOver).getDrawable() ;
		drawableButtonClicked = new Image(buttonClicked).getDrawable() ;
		drawableBack = new Image(back).getDrawable() ;
		drawablePlay = new Image(play).getDrawable() ;
		drawableLeaders = new Image(leaders).getDrawable() ;
		
		skin = new Skin(Gdx.files.internal("skin/uiskin.json")) ;
		font = new BitmapFont(Gdx.files.internal("fonts/totem-game-font.fnt"), Gdx.files.internal("fonts/totem-game-font.png"), false) ;

		bgGameProcessMusic = Gdx.audio.newMusic(Gdx.files.internal("music/game_process.mp3")) ;
		bgGameProcessMusic.setLooping(true) ;
		bgGameProcessMusic.setVolume(0.7f) ;
		
		tickSound = Gdx.audio.newSound(Gdx.files.internal("music/click.wav")) ;
		dropSound = Gdx.audio.newSound(Gdx.files.internal("music/drop.mp3")) ;
		screamingSound = Gdx.audio.newSound(Gdx.files.internal("music/screaming.mp3")) ;
		dohSound = Gdx.audio.newSound(Gdx.files.internal("music/doh.mp3")) ;
	}
	
	public static int getStringWidth(BitmapFont font, String string)
	{
		layout.setText(font, string) ;
		return (int) layout.width ;
	}
	
	public static int getStringHeight(BitmapFont font, String string)
	{
		layout.setText(font, string) ;
		return (int) layout.height ;
	}

	public static void playSound (Sound sound) 
	{
		sound.play(1) ;
	}
}