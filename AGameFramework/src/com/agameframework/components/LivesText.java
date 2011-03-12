package com.agameframework.components;

import javax.microedition.khronos.opengles.GL10;

import com.agameframework.object.GameNode;
import com.agameframework.settings.GameSettings;


/**
 *
 * @author Elis - Email: Elisedlund@gmail.com - Date: 11 mar 2011
 */
public class LivesText extends LabeledNumbers{


	private int lastLives = GameSettings.getLives();
	
	public LivesText(int fontResourceID) {
		super();
		mNumbers = new GameNode(GameSettings.getLivesString(),fontResourceID);
	}
	
	public LivesText(String label, int fontResourceID) {
		super(label);
		mNumbers = new GameNode(GameSettings.getLivesString(),fontResourceID);
	}

	protected void updateNumbers()
	{ 
		if (lastLives != GameSettings.getLives())
		{
			//TODO event on health change.
			mNumbers.setText(GameSettings.getLivesString());
			lastLives = GameSettings.getLives();
		}
	}
}