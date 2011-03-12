package com.agameframework.components;

import javax.microedition.khronos.opengles.GL10;

import com.agameframework.debug.Debug;
import com.agameframework.object.GameNode;
import com.agameframework.settings.GameSettings;


/**
 *
 * @author Elis - Email: Elisedlund@gmail.com - Date: 11 mar 2011
 */
public class ScoreText extends LabeledNumbers{

	private int lastScore = 0;
	private int mNr = 1;

	public ScoreText(int fontResourceID) {
		super();
		mNumbers = new GameNode("0",fontResourceID);
	}

	public ScoreText(String scoreLabel, int fontResourceID) {
		super(scoreLabel);
		mNumbers = new GameNode("0",fontResourceID);
	}
	
	public void setPlayer(int oneOrTwo)
	{
		mNr = oneOrTwo;
	}
	
	
	@Override
	protected void updateNumbers() {
		if(mNr == 1)
		{
			if (lastScore != GameSettings.getScore())
			{
				//TODO event on score change.
				mNumbers.setText(GameSettings.getScoreString());
				lastScore = GameSettings.getScore();
			}
		}
		else if (mNr  == 2)
		{
			if (lastScore != GameSettings.getScore2())
			{
				//TODO event on score change.
				mNumbers.setText(GameSettings.getScoreString2());
				lastScore = GameSettings.getScore2();
			}
		}
		else
		{
			Debug.warning("Only score for 1 and 2 exist");
		}
	}
}