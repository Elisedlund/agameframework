package com.agameframework.event;

import com.agameframework.interfaces.ICondition;
import com.agameframework.interfaces.IEvent;

public class ConditionEvent implements IEvent{
	
	private ICondition mCondition;
	private IEvent mEvent = null;
	private IEvent mElseEvent = null;
	
	public ConditionEvent(IEvent event, ICondition condition)
	{
		mEvent = event; 
		mCondition = condition;
	}
	
	public ConditionEvent(IEvent event, IEvent elseEvent, ICondition condition)
	{
		mEvent = event; 
		mElseEvent = elseEvent;
		mCondition = condition;
	}
	
	@Override
	public void invokeEvent() {
		if(mCondition.getBoolean())
		{
			mEvent.invokeEvent();
		}
		else
		{
			if(mElseEvent != null)
			{
				mElseEvent.invokeEvent();
			}
		}
	}
	
}//end of class