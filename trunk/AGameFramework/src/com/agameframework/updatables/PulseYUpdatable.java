package com.agameframework.updatables;

import com.agameframework.interfaces.IEvent;

public class PulseYUpdatable extends AbstractPulsatingUpdatable
{	

	public PulseYUpdatable(IEvent event,float speed, float relativValueMin, float relativValueMax, int nrOfTimes) 
	{
		super(event,speed, relativValueMin, relativValueMax, nrOfTimes);
	}
	
	public PulseYUpdatable(float speed, float relativValueMin, float relativValueMax, int nrOfTimes) 
	{
		super(speed,relativValueMin,relativValueMax,nrOfTimes);
	}
	
	public PulseYUpdatable(IEvent event, float speed, float relativValue, int nrOfTimes) 
	{
		super(event,speed,relativValue,nrOfTimes);
	}
	
	public PulseYUpdatable(IEvent event, float speed, float relativValue) 
	{
		super(event,speed,relativValue);
	}
	
	public PulseYUpdatable(float speed, float relativValue, int nrOfTimes) 
	{
		super(speed,relativValue,nrOfTimes);	
	}
	
	public PulseYUpdatable(float speed, float relativValue) 
	{
		super(speed,relativValue);	
	}

	public PulseYUpdatable(IEvent event,float relativValue, int nrOfTimes)
	{
		super(event,relativValue, nrOfTimes);
	}
	
	public PulseYUpdatable(IEvent event,float relativValue)
	{
		super(event,relativValue);
	}

	public PulseYUpdatable(float relativValue, int nrOfTimes)
	{
		super(relativValue, nrOfTimes);
	}
	
	public PulseYUpdatable(float relativValue)
	{
		super(relativValue);
	}

	public PulseYUpdatable(IEvent event, int nrOfTimes)
	{
		super(event, nrOfTimes);
	}
	
	public PulseYUpdatable(IEvent event)
	{
		super(event);
	}

	protected void inc(float inc)
	{
		mParent.incY(inc);
	}

	@Override
	public void init() {}
}