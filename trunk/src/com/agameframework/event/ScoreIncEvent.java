package com.agameframework.event;

import com.agameframework.debug.Debug;
import com.agameframework.interfaces.IEvent;
import com.agameframework.settings.GameSettings;

public class ScoreIncEvent implements IEvent{

	private int mInc;
	private int mNr = 1;

	public ScoreIncEvent(int inc)
	{
		mInc = inc;
	}

	public ScoreIncEvent(int inc, int nr)
	{
		mInc = inc;
		mNr = nr;
	}

	@Override
	public void invokeEvent() {
		if(mNr == 1)
		{
			GameSettings.incScore(mInc);
		}
		else if(mNr == 2)
		{
			GameSettings.incScore2(mInc);
		}
		else
		{
			Debug.warning("Only score for 1 and 2 exist");	
		}
	}

	public static void invoke(int inc,int nr)
	{
		if(nr == 1)
		{
			GameSettings.incScore(inc);
		}
		else if(nr == 2)
		{
			GameSettings.incScore2(inc);
		}
		else
		{
			Debug.warning("Only score for 1 and 2 exist");	
		}
	}

	public static void invoke(int inc)
	{
		GameSettings.incScore(inc);
	}

}
