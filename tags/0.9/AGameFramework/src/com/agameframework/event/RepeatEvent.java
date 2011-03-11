package com.agameframework.event;

import com.agameframework.interfaces.IEvent;

public class RepeatEvent implements IEvent{


	private int mRepeat = 1;
	private IEvent mEvent; 

	public RepeatEvent(IEvent event, int repeat) {
		mEvent = event;
		mRepeat = repeat;
	}

	@Override
	public void invokeEvent() {
		for (int i=0; i < mRepeat ;i++)
		{
			mEvent.invokeEvent();
		}
	}

}
