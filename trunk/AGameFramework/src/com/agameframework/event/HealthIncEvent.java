package com.agameframework.event;

import com.agameframework.interfaces.IEvent;
import com.agameframework.settings.GameSettings;

public class HealthIncEvent implements IEvent{

	private int mInc;

	public HealthIncEvent(int inc)
	{
		mInc = inc;
	}

	public HealthIncEvent(int inc, int nr)
	{
		mInc = inc;
	}

	@Override
	public void invokeEvent() {
		GameSettings.incHealth(mInc);
	}

	public static void invoke(int inc)
	{
		GameSettings.incScore(inc);
	}

}
