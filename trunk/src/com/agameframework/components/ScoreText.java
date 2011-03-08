package com.agameframework.components;

import javax.microedition.khronos.opengles.GL10;

import com.agameframework.debug.Debug;
import com.agameframework.object.GameNode;
import com.agameframework.settings.GameSettings;


/*
 * Copyright (C) 2010 Elis Edlund.
 */


public class ScoreText extends GameNode{

	protected GameNode mNumbers;
	protected int lastScore = 0;
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
	public void render(GL10 gl)
	{
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
		mNumbers.setX(mRight + mNumbers.getWidth()/2);
		mNumbers.setY(getY());
		super.render(gl);
		mNumbers.render(gl);
	}

	@Override
	public float getWidth()
	{
		return super.getWidth() + mNumbers.getWidth();
	}

	@Override
	public float getHeight()
	{
		return super.getHeight() + mNumbers.getHeight();
	}

	public GameNode getNumberNode()
	{
		return mNumbers;	
	}
}