package com.agameframework.updatables;

import com.agameframework.interfaces.IEvent;

public class FadeInOutGreenUpdatable extends AbstractPulsatingUpdatable{

	public FadeInOutGreenUpdatable(IEvent event,float speed, float relativValueMin, float relativValueMax, int nrOfTimes) 
	{
		super(event,speed, relativValueMin, relativValueMax, nrOfTimes);
	}
	
	public FadeInOutGreenUpdatable(float speed, float relativValueMin, float relativValueMax, int nrOfTimes) 
	{
		super(speed,relativValueMin,relativValueMax,nrOfTimes);
	}
	
	public FadeInOutGreenUpdatable(IEvent event, float speed, float relativValue, int nrOfTimes) 
	{
		super(event,speed,relativValue,nrOfTimes);
	}
	
	public FadeInOutGreenUpdatable(IEvent event, float speed, float relativValue) 
	{
		super(event,speed,relativValue);
	}
	
	public FadeInOutGreenUpdatable(float speed, float relativValue, int nrOfTimes) 
	{
		super(speed,relativValue,nrOfTimes);	
	}
	
	public FadeInOutGreenUpdatable(float speed, float relativValue) 
	{
		super(speed,relativValue);	
	}

	public FadeInOutGreenUpdatable(IEvent event,float relativValue, int nrOfTimes)
	{
		super(event,relativValue, nrOfTimes);
	}
	
	public FadeInOutGreenUpdatable(IEvent event,float relativValue)
	{
		super(event,relativValue);
	}

	public FadeInOutGreenUpdatable(float relativValue, int nrOfTimes)
	{
		super(relativValue, nrOfTimes);
	}
	
	public FadeInOutGreenUpdatable(float relativValue)
	{
		super(relativValue);
	}

	public FadeInOutGreenUpdatable(IEvent event, int nrOfTimes)
	{
		super(event, nrOfTimes);
	}
	
	public FadeInOutGreenUpdatable(IEvent event)
	{
		super(event);
	}

	protected void inc(float inc)
	{
		mParent.incGreen(inc);
	}
	
	@Override
	public void init() {

	}
}