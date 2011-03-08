package com.agameframework.Updatables;

import com.agameframework.interfaces.IEvent;
import com.agameframework.object.Updatable;

public class EventUpdatable extends Updatable{

	private IEvent mEvent;
	
	public EventUpdatable(IEvent event)
	{
		mEvent = event;
	}
	
	@Override
	public void update() {
		mEvent.invokeEvent();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
}
