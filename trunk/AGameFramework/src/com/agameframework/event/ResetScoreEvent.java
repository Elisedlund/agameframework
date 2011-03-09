package com.agameframework.event;

import com.agameframework.debug.Debug;
import com.agameframework.interfaces.IEvent;
import com.agameframework.settings.GameSettings;

public class ResetScoreEvent implements IEvent{

	private int mNr = 1;

	public ResetScoreEvent()
	{}

	public ResetScoreEvent(int nr)
	{
		mNr = nr;
	}

	@Override
	public void invokeEvent() {
		if(mNr == 1)
		{
			GameSettings.resetScore();
		}
		else if(mNr == 2)
		{
			GameSettings.resetScore2();
		}
		else
		{
			Debug.warning("Only score for 1 and 2 exist");	
		}
	}

	public static void invoke()
	{
		GameSettings.resetScore();
	}

	public static void invoke(int nr)
	{
		if(nr == 1)
		{
			GameSettings.resetScore();
		}
		else if(nr == 2)
		{
			GameSettings.resetScore2();
		}
		else
		{
			Debug.warning("Only score for 1 and 2 exist");	
		}
	}

}
