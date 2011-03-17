package com.agameframework.updatables;

import com.agameframework.interfaces.IEvent;

public class GrowShrinkToUpdatable extends AbstractPulsatingUpdatable
{	

	public GrowShrinkToUpdatable(IEvent event,float speed, float relativValueMin, float relativValueMax, int nrOfTimes) 
	{
		super(event,speed, relativValueMin, relativValueMax, nrOfTimes);
	}
	
	public GrowShrinkToUpdatable(float speed, float relativValueMin, float relativValueMax, int nrOfTimes) 
	{
		super(speed,relativValueMin,relativValueMax,nrOfTimes);
	}
	
	public GrowShrinkToUpdatable(IEvent event, float speed, float relativValue, int nrOfTimes) 
	{
		super(event,speed,relativValue,nrOfTimes);
	}
	
	public GrowShrinkToUpdatable(IEvent event, float speed, float relativValue) 
	{
		super(event,speed,relativValue);
	}
	
	public GrowShrinkToUpdatable(float speed, float relativValue, int nrOfTimes) 
	{
		super(speed,relativValue,nrOfTimes);	
	}
	
	public GrowShrinkToUpdatable(float speed, float relativValue) 
	{
		super(speed,relativValue);	
	}

	public GrowShrinkToUpdatable(IEvent event,float relativValue, int nrOfTimes)
	{
		super(event,relativValue, nrOfTimes);
	}
	
	public GrowShrinkToUpdatable(IEvent event,float relativValue)
	{
		super(event,relativValue);
	}

	public GrowShrinkToUpdatable(float relativValue, int nrOfTimes)
	{
		super(relativValue, nrOfTimes);
	}
	
	public GrowShrinkToUpdatable(float relativValue)
	{
		super(relativValue);
	}

	public GrowShrinkToUpdatable(IEvent event, int nrOfTimes)
	{
		super(event, nrOfTimes);
	}
	
	public GrowShrinkToUpdatable(IEvent event)
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