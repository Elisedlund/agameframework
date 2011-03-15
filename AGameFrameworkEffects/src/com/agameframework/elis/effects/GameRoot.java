package com.agameframework.elis.effects;

import javax.microedition.khronos.opengles.GL10;

import com.agameframework.Game;
import com.agameframework.Loader;
import com.agameframework.input.components.SimpleTouchMovement;
import com.agameframework.interfaces.ILoadable;
import com.agameframework.object.GameNode;

/**
 * the root of the game.
 * @author 
 */
public class GameRoot extends GameNode implements ILoadable{

	//load a string from string.xml (localized)
	private String appNameString = Game.string(R.string.app_name);

	/**
	 * Load textures and sounds here. you should also static text textures here 
	 */
	public void load()
	{
		//lazy loading just loads everything .Make sure only the 
		//correct resources are in the folders OR it will CRASH
		Loader.loadTexture(R.drawable.class.getFields()); //load all resources in drawable
		Loader.loadSound(R.raw.class.getFields());//load all resources in raw.
		//you can always use the loader to load just specific media. if your not lazy.


		Loader.loadText(appNameString, R.drawable.font_arial_white); //create a static text texture. 
	}//end of load()

	@Override
	public void init()
	{
		GameNode fire = new FireEmitter();
		fire.setXY(Game.getCenterX(),Game.getCenterY());
		add(fire);
		SimpleTouchMovement.add(fire);
	}


}// end of class