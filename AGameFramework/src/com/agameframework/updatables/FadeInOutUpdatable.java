package com.agameframework.updatables;

import com.agameframework.interfaces.IEvent;

public class FadeInOutUpdatable extends AbstractPulsatingUpdatable
{	

	public FadeInOutUpdatable(IEvent event,float speed, float relativValueMin, float relativValueMax, int nrOfTimes) 
	{
		super(event,speed, relativValueMin, relativValueMax, nrOfTimes);
	}
	
	public FadeInOutUpdatable(float speed, float relativValueMin, float relativValueMax, int nrOfTimes) 
	{
		super(speed,relativValueMin,relativValueMax,nrOfTimes);
	}
	
	public FadeInOutUpdatable(IEvent event, float speed, float relativValue, int nrOfTimes) 
	{
		super(event,speed,relativValue,nrOfTimes);
	}
	
	public FadeInOutUpdatable(IEvent event, float speed, float relativValue) 
	{
		super(event,speed,relativValue);
	}
	
	public FadeInOutUpdatable(float speed, float relativValue, int nrOfTimes) 
	{
		super(speed,relativValue,nrOfTimes);	
	}
	
	public FadeInOutUpdatable(float speed, float relativValue) 
	{
		super(speed,relativValue);	
	}

	public FadeInOutUpdatable(IEvent event,float relativValue, int nrOfTimes)
	{
		super(event,relativValue, nrOfTimes);
	}
	
	public FadeInOutUpdatable(IEvent event,float relativValue)
	{
		super(event,relativValue);
	}

	public FadeInOutUpdatable(float relativValue, int nrOfTimes)
	{
		super(relativValue, nrOfTimes);
	}
	
	public FadeInOutUpdatable(float relativValue)
	{
		super(relativValue);
	}

	public FadeInOutUpdatable(IEvent event, int nrOfTimes)
	{
		super(event, nrOfTimes);
	}
	
	public FadeInOutUpdatable(IEvent event)
	{
		super(event);
	}

	protected void inc(float inc)
	{
		mParent.mOpacity+=inc;
	}

	@Override
	public void init() {}
}