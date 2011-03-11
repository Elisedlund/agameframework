package com.agameframework.event;

import com.agameframework.Game;
import com.agameframework.interfaces.IEvent;

public class SyncEvent implements IEvent{

	private IEvent mEvent;

	public SyncEvent(IEvent event) {
		mEvent = event;
	}

	@Override
	public void invokeEvent() {
		Game.addSyncEvent(mEvent);
	}
	
	public static void invoke(IEvent event)
	{
		Game.addSyncEvent(event);
	}

}
