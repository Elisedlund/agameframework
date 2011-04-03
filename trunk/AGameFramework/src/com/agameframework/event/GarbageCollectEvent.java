package com.agameframework.event;

import com.agameframework.Game;
import com.agameframework.interfaces.IEvent;

public class GarbageCollectEvent implements IEvent{

	@Override
	public void invokeEvent() 
	{
		System.gc();
	}
	
	public static void invoke()
	{
		System.gc();
	}
}
