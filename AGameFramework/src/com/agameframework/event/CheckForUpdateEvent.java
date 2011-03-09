package com.agameframework.event;

import com.agameframework.interfaces.IEvent;
import com.agameframework.utils.GameIntents;

public class CheckForUpdateEvent implements IEvent{

	@Override
	public void invokeEvent() 
	{
		GameIntents.checkForUpdate();
	}
	
	public static void invoke()
	{
		GameIntents.checkForUpdate();
	}
}
