package com.agameframework.components;

import javax.microedition.khronos.opengles.GL10;

import com.agameframework.object.GameNode;
import com.agameframework.settings.GameSettings;


/**
 *
 * @author Elis - Email: Elisedlund@gmail.com - Date: 11 mar 2011
 */
public class HighscoreText extends LabeledNumbers{

	
	public HighscoreText(int fontResourceID) {
		super();
		mNumbers = new GameNode(GameSettings.getHighscoreString(),fontResourceID);
	}
	
	public HighscoreText(String highscoreLabel,int fontResourceID) {
		super(highscoreLabel);
		mNumbers = new GameNode(GameSettings.getHighscoreString(),fontResourceID);
	}

	@Override
	protected void updateNumbers() {
		if (GameSettings.setIfHighscore())
		{
			//TODO do event on highscore. once? 
			mNumbers.setText(GameSettings.getHighscoreString());
		}	
	}

}