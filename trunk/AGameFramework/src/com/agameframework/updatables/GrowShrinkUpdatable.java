package com.agameframework.updatables;

import com.agameframework.interfaces.IEvent;

public class GrowShrinkUpdatable extends AbstractPulsatingUpdatable
{	

	public GrowShrinkUpdatable(IEvent event,float speed, float relativValueMin, float relativValueMax, int nrOfTimes) 
	{
		super(event,speed, relativValueMin, relativValueMax, nrOfTimes);
	}
	
	public GrowShrinkUpdatable(float speed, float relativValueMin, float relativValueMax, int nrOfTimes) 
	{
		super(speed,relativValueMin,relativValueMax,nrOfTimes);
	}
	
	public GrowShrinkUpdatable(IEvent event, float speed, float relativValue, int nrOfTimes) 
	{
		super(event,speed,relativValue,nrOfTimes);
	}
	
	public GrowShrinkUpdatable(IEvent event, float speed, float relativValue) 
	{
		super(event,speed,relativValue);
	}
	
	public GrowShrinkUpdatable(float speed, float relativValue, int nrOfTimes) 
	{
		super(speed,relativValue,nrOfTimes);	
	}
	
	public GrowShrinkUpdatable(float speed, float relativValue) 
	{
		super(speed,relativValue);	
	}

	public GrowShrinkUpdatable(IEvent event,float relativValue, int nrOfTimes)
	{
		super(event,relativValue, nrOfTimes);
	}
	
	public GrowShrinkUpdatable(IEvent event,float relativValue)
	{
		super(event,relativValue);
	}

	public GrowShrinkUpdatable(float relativValue, int nrOfTimes)
	{
		super(relativValue, nrOfTimes);
	}
	
	public GrowShrinkUpdatable(float relativValue)
	{
		super(relativValue);
	}

	public GrowShrinkUpdatable(IEvent event, int nrOfTimes)
	{
		super(event, nrOfTimes);
	}
	
	public GrowShrinkUpdatable(IEvent event)
	{
		super(event);
	}

	protected void inc(float inc)
	{
		mParent.incScale(inc);
	}

	@Override
	public void init() {}
}