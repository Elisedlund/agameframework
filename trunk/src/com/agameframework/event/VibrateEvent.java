package com.agameframework.event;

import com.agameframework.Game;
import com.agameframework.interfaces.IEvent;

public class VibrateEvent implements IEvent{

	private int mLength;

	public VibrateEvent(int length)
	{
		mLength = length;
	}

	@Override
	public void invokeEvent() 
	{
		Game.instance.vibrate(mLength);
	}
	
	public static void invoke(int length) 
	{
		Game.instance.vibrate(length);
	}

}