package com.agameframework.components;

import javax.microedition.khronos.opengles.GL10;

import com.agameframework.object.GameNode;
import com.agameframework.settings.GameSettings;


/**
 *
 * @author Elis - Email: Elisedlund@gmail.com - Date: 11 mar 2011
 */
public class HighscoreText extends GameNode{

	protected GameNode mNumbers;

	public HighscoreText(String scoreLabel,int fontResourceID) {
		super(scoreLabel);
		mNumbers = new GameNode(GameSettings.getHighscoreString(),fontResourceID);
	}

	@Override
	public void render(GL10 gl)
	{
		if (GameSettings.setIfHighscore())
		{
			//TODO do event on highscore. once? 
			mNumbers.setText(GameSettings.getHighscoreString());
		}
		mNumbers.setX(mRight + mNumbers.getWidth()/2);
		mNumbers.setY(getY());
		super.render(gl);
		mNumbers.render(gl);
	}
	
	public GameNode getNumberNode()
	{
		return mNumbers;	
	}

}