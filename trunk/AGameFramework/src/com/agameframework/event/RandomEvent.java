package com.agameframework.event;

import java.util.List;

import com.agameframework.interfaces.IEvent;

public class RandomEvent extends CompositeEvent implements IEvent{


	public RandomEvent(List<IEvent> list) {
		super(list);
	}

	public RandomEvent() {
		super();
	}

	@Override
	public void invokeEvent() {
		int random = (int) (Math.random()*mEventList.size());
		mEventList.get(random).invokeEvent();
	}

}
