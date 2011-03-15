package com.agameframework.YOURNAME.YOURGAME;

import javax.microedition.khronos.opengles.GL10;

import com.agameframework.Game;
import com.agameframework.Loader;
import com.agameframework.event.AddUpdatableEvent;
import com.agameframework.interfaces.ILoadable;
import com.agameframework.object.GameNode;
import com.agameframework.updatables.FadeInOutUpdatable;

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
		GameNode testText = new GameNode(appNameString); //creates a gameNode with the texture loaded above.
		testText.setScale(1.8f); //set the scale.
		testText.setXY(Game.getCenterX(),Game.getCenterY()); //set position.
		testText.mOpacity = 0;
		testText.addUpdateable(new FadeInOutUpdatable(new AddUpdatableEvent(new FadeInOutUpdatable(-0.01f,-1f), testText)));//add a updatable component.
		add(testText);//adds the GameNode to this node(root) 
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

}// end of class