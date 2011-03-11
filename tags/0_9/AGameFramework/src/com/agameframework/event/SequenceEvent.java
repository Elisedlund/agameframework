package com.agameframework.event;

import java.util.List;

import com.agameframework.interfaces.IEvent;

public class SequenceEvent extends CompositeEvent implements IEvent{

	private int mCurrentPointer = 0; 
	
	public SequenceEvent(List<IEvent> list) {
		super(list);
	}
	
	@Override
	public void invokeEvent() {
		mEventList.get(mCurrentPointer).invokeEvent();
		mCurrentPointer++;
		if(mCurrentPointer >= mEventList.size())
		{
			mCurrentPointer = 0;
		}
	}

}
