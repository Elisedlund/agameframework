package com.agameframework.elis.paperpong;

import javax.microedition.khronos.opengles.GL10;

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
			"Start game",
			"Update",
			"More games",
			"Mail developer",
			"Quit game"};
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
		
		Loader.loadText(menuStrings, R.drawable.font_arial_black_shadow);
	}//end of load()

	@Override 
	public void init()
	{
		Menu menu = new Menu(
				menuStrings, 
				new IEvent[]{
						new ChangeStateEvent(new GameRoot()), //TODO 
						new CheckForUpdateEvent(),
						new SearchForPackageEvent(),
						new SendMailEvent(),
						new QuitGameEvent()
						},
						new SoundAndVibrateEvent(R.raw.pong,100));
		menu.setXY(Game.getCenterX(), Game.getCenterY());
		menu.setLineSpace(10);
		menu.setScale(1.5f);
		menu.effectGrow();
		add(menu);
	}

	@Override
	public void update()
	{
		super.update();
		//You can add stuff here but don't have to (not recommended)
	}

	@Override
	public void render(GL10 gl) {
		super.render(gl);
		//You can add stuff here but don't have to (not recommended)
	}

	
//	public void playerOneScore()
//	{
//		if(mWinner){return;}
//		playerOneScore++;
//		SoundEffectPlayer.play("score");
//		if(playerOneScore >= 9)
//		{
//			mWinner = true;	
//			remove(mBall);
//			mBall=null;
//		}
//		else
//		{ 
//
//			resetBall();
//		}
//	}
//
//	public void playerTwoScore()
//	{
//		if(mWinner){return;}
//		playerTwoScore++;
//		SoundEffectPlayer.play("score");
//		if(playerTwoScore >= 9)
//		{
//			mWinner = true;	
//			remove(mBall);
//			mBall=null;
//		}
//		else
//		{
//			//TODO give serve.
//			resetBall();
//		}
//	}
}// end of class