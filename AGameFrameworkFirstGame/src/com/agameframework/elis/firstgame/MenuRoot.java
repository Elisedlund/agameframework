package com.agameframework.elis.firstgame;

import com.agameframework.Game;
import com.agameframework.Loader;
import com.agameframework.components.Menu;
import com.agameframework.event.ChangeStateEvent;
import com.agameframework.event.CheckForUpdateEvent;
import com.agameframework.event.QuitGameEvent;
import com.agameframework.event.SearchForPackageEvent;
import com.agameframework.event.SendMailEvent;
import com.agameframework.event.SoundAndVibrateEvent;
import com.agameframework.interfaces.IEvent;
import com.agameframework.interfaces.ILoadable;
import com.agameframework.object.GameNode;

/**
 * the root of the game.
 * @author 
 */
public class MenuRoot extends GameNode implements ILoadable{

	private static String[] menuStrings = {
		Game.string(R.string.start_game),
		Game.string(R.string.update),
		Game.string(R.string.more_games),
		Game.string(R.string.mail_developer),
		Game.string(R.string.quit_game)
		};
	
	private static String[] gameStrings = {
		Game.string(R.string.label_score),
		Game.string(R.string.label_highscore),
		Game.string(R.string.touch_to_restart),
		};
	
	/**
	 * Load textures and sounds here.
	 * you can also create game stuff here.
	 */
	public void load()
	{
		//lazy loading just loads everything .Make sure only the 
		//correct resources are in the folders OR it will CRASH
		Loader.loadTexture(R.drawable.class.getFields()); //load all resources in drawable
		Loader.loadSound(R.raw.class.getFields());//load all resources in raw.
		//you can always use the loader to load just specific media. if your not lazy.
		
		Loader.loadText(menuStrings, R.drawable.font_arial_white);
		Loader.loadText(gameStrings, R.drawable.font_arial_white);
	}//end of load()

	@Override 
	public void init()
	{
		Menu menu = new Menu(
				menuStrings, 
				new IEvent[]{
						new ChangeStateEvent(new GameRoot()),
						new CheckForUpdateEvent(),
						new SearchForPackageEvent(),
						new SendMailEvent(),
						new QuitGameEvent()
						},
						new SoundAndVibrateEvent(R.raw.snd_poing,100));//effect on release.
		menu.setXY(Game.getCenterX(), Game.getCenterY());
		menu.setLineSpace(10);
		menu.setScale(1.5f);
		menu.effectGrow();
		menu.setColor(0f, 1f, 0f);
		add(menu);
	}

}// end of class