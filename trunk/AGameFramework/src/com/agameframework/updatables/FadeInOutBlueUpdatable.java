package com.agameframework.updatables;

import com.agameframework.interfaces.IEvent;

public class FadeInOutBlueUpdatable extends AbstractPulsatingUpdatable{

	public FadeInOutBlueUpdatable(IEvent event,float speed, float relativValueMin, float relativValueMax, int nrOfTimes) 
	{
		super(event,speed, relativValueMin, relativValueMax, nrOfTimes);
	}
	
	public FadeInOutBlueUpdatable(float speed, float relativValueMin, float relativValueMax, int nrOfTimes) 
	{
		super(speed,relativValueMin,relativValueMax,nrOfTimes);
	}
	
	public FadeInOutBlueUpdatable(IEvent event, float speed, float relativValue, int nrOfTimes) 
	{
		super(event,speed,relativValue,nrOfTimes);
	}
	
	public FadeInOutBlueUpdatable(IEvent event, float speed, float relativValue) 
	{
		super(event,speed,relativValue);
	}
	
	public FadeInOutBlueUpdatable(float speed, float relativValue, int nrOfTimes) 
	{
		super(speed,relativValue,nrOfTimes);	
	}
	
	public FadeInOutBlueUpdatable(float speed, float relativValue) 
	{
		super(speed,relativValue);	
	}

	public FadeInOutBlueUpdatable(IEvent event,float relativValue, int nrOfTimes)
	{
		super(event,relativValue, nrOfTimes);
	}
	
	public FadeInOutBlueUpdatable(IEvent event,float relativValue)
	{
		super(event,relativValue);
	}

	public FadeInOutBlueUpdatable(float relativValue, int nrOfTimes)
	{
		super(relativValue, nrOfTimes);
	}
	
	public FadeInOutBlueUpdatable(float relativValue)
	{
		super(relativValue);
	}

	public FadeInOutBlueUpdatable(IEvent event, int nrOfTimes)
	{
		super(event, nrOfTimes);
	}
	
	public FadeInOutBlueUpdatable(IEvent event)
	{
		super(event);
	}

	protected void inc(float inc)
	{
		mParent.incBlue(inc);
	}
	
	@Override
	public void init() {

	}
}