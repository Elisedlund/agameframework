package com.agameframework.updatables;

import com.agameframework.interfaces.IEvent;

public class PulseXUpdatable extends AbstractPulsatingUpdatable
{	

	public PulseXUpdatable(IEvent event,float speed, float relativValueMin, float relativValueMax, int nrOfTimes) 
	{
		super(event,speed, relativValueMin, relativValueMax, nrOfTimes);
	}
	
	public PulseXUpdatable(float speed, float relativValueMin, float relativValueMax, int nrOfTimes) 
	{
		super(speed,relativValueMin,relativValueMax,nrOfTimes);
	}
	
	public PulseXUpdatable(IEvent event, float speed, float relativValue, int nrOfTimes) 
	{
		super(event,speed,relativValue,nrOfTimes);
	}
	
	public PulseXUpdatable(IEvent event, float speed, float relativValue) 
	{
		super(event,speed,relativValue);
	}
	
	public PulseXUpdatable(float speed, float relativValue, int nrOfTimes) 
	{
		super(speed,relativValue,nrOfTimes);	
	}
	
	public PulseXUpdatable(float speed, float relativValue) 
	{
		super(speed,relativValue);	
	}

	public PulseXUpdatable(IEvent event,float relativValue, int nrOfTimes)
	{
		super(event,relativValue, nrOfTimes);
	}
	
	public PulseXUpdatable(IEvent event,float relativValue)
	{
		super(event,relativValue);
	}

	public PulseXUpdatable(float relativValue, int nrOfTimes)
	{
		super(relativValue, nrOfTimes);
	}
	
	public PulseXUpdatable(float relativValue)
	{
		super(relativValue);
	}

	public PulseXUpdatable(IEvent event, int nrOfTimes)
	{
		super(event, nrOfTimes);
	}
	
	public PulseXUpdatable(IEvent event)
	{
		super(event);
	}

	protected void inc(float inc)
	{
		mParent.incX(inc);
	}

	@Override
	public void init() {}
}