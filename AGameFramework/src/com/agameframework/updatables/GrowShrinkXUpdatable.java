package com.agameframework.updatables;

import com.agameframework.interfaces.IEvent;

public class GrowShrinkXUpdatable extends AbstractPulsatingUpdatable
{	

	public GrowShrinkXUpdatable(IEvent event,float speed, float relativValueMin, float relativValueMax, int nrOfTimes) 
	{
		super(event,speed, relativValueMin, relativValueMax, nrOfTimes);
	}
	
	public GrowShrinkXUpdatable(float speed, float relativValueMin, float relativValueMax, int nrOfTimes) 
	{
		super(speed,relativValueMin,relativValueMax,nrOfTimes);
	}
	
	public GrowShrinkXUpdatable(IEvent event, float speed, float relativValue, int nrOfTimes) 
	{
		super(event,speed,relativValue,nrOfTimes);
	}
	
	public GrowShrinkXUpdatable(IEvent event, float speed, float relativValue) 
	{
		super(event,speed,relativValue);
	}
	
	public GrowShrinkXUpdatable(float speed, float relativValue, int nrOfTimes) 
	{
		super(speed,relativValue,nrOfTimes);	
	}
	
	public GrowShrinkXUpdatable(float speed, float relativValue) 
	{
		super(speed,relativValue);	
	}

	public GrowShrinkXUpdatable(IEvent event,float relativValue, int nrOfTimes)
	{
		super(event,relativValue, nrOfTimes);
	}
	
	public GrowShrinkXUpdatable(IEvent event,float relativValue)
	{
		super(event,relativValue);
	}

	public GrowShrinkXUpdatable(float relativValue, int nrOfTimes)
	{
		super(relativValue, nrOfTimes);
	}
	
	public GrowShrinkXUpdatable(float relativValue)
	{
		super(relativValue);
	}

	public GrowShrinkXUpdatable(IEvent event, int nrOfTimes)
	{
		super(event, nrOfTimes);
	}
	
	public GrowShrinkXUpdatable(IEvent event)
	{
		super(event);
	}

	protected void inc(float inc)
	{
		mParent.incScaleX(inc);
	}

	@Override
	public void init() {}
}