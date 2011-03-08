package com.agameframework.event;

import com.agameframework.Game;
import com.agameframework.interfaces.IEvent;

public class QuitGameEvent implements IEvent{

	@Override
	public void invokeEvent() 
	{
		Game.instance.finish();
	}
	
	public static void invoke()
	{
		Game.instance.finish();
	}
}
