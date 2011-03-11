package com.agameframework.event;

import com.agameframework.Game;
import com.agameframework.interfaces.IEvent;

public class AddTimedEvent implements IEvent {
	
	private IEvent mEvent;
	private int mTimeInMS;
	
	public AddTimedEvent(IEvent event,int timeinms) 
	{
		mEvent = event;
		mTimeInMS = timeinms;
	}

	@Override
	public void invokeEvent() 
	{
		Game.addTimedEvent(mEvent,mTimeInMS);		
	}
	
	public static void invoke(IEvent event,int timeinms)
	{
		Game.addTimedEvent(event,timeinms);	
	}
	
}
