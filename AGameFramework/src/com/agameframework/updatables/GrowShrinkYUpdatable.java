package com.agameframework.updatables;

import com.agameframework.interfaces.IEvent;

public class GrowShrinkYUpdatable extends AbstractPulsatingUpdatable
{	

	public GrowShrinkYUpdatable(IEvent event,float speed, float relativValueMin, float relativValueMax, int nrOfTimes) 
	{
		super(event,speed, relativValueMin, relativValueMax, nrOfTimes);
	}
	
	public GrowShrinkYUpdatable(float speed, float relativValueMin, float relativValueMax, int nrOfTimes) 
	{
		super(speed,relativValueMin,relativValueMax,nrOfTimes);
	}
	
	public GrowShrinkYUpdatable(IEvent event, float speed, float relativValue, int nrOfTimes) 
	{
		super(event,speed,relativValue,nrOfTimes);
	}
	
	public GrowShrinkYUpdatable(IEvent event, float speed, float relativValue) 
	{
		super(event,speed,relativValue);
	}
	
	public GrowShrinkYUpdatable(float speed, float relativValue, int nrOfTimes) 
	{
		super(speed,relativValue,nrOfTimes);	
	}
	
	public GrowShrinkYUpdatable(float speed, float relativValue) 
	{
		super(speed,relativValue);	
	}

	public GrowShrinkYUpdatable(IEvent event,float relativValue, int nrOfTimes)
	{
		super(event,relativValue, nrOfTimes);
	}
	
	public GrowShrinkYUpdatable(IEvent event,float relativValue)
	{
		super(event,relativValue);
	}

	public GrowShrinkYUpdatable(float relativValue, int nrOfTimes)
	{
		super(relativValue, nrOfTimes);
	}
	
	public GrowShrinkYUpdatable(float relativValue)
	{
		super(relativValue);
	}

	public GrowShrinkYUpdatable(IEvent event, int nrOfTimes)
	{
		super(event, nrOfTimes);
	}
	
	public GrowShrinkYUpdatable(IEvent event)
	{
		super(event);
	}

	protected void inc(float inc)
	{
		mParent.incScaleY(inc);
	}

	@Override
	public void init() {}
}