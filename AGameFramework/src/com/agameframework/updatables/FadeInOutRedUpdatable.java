package com.agameframework.updatables;

import com.agameframework.interfaces.IEvent;

public class FadeInOutRedUpdatable extends AbstractPulsatingUpdatable{


	public FadeInOutRedUpdatable(IEvent event,float speed, float relativValueMin, float relativValueMax, int nrOfTimes) 
	{
		super(event,speed, relativValueMin, relativValueMax, nrOfTimes);
	}
	
	public FadeInOutRedUpdatable(float speed, float relativValueMin, float relativValueMax, int nrOfTimes) 
	{
		super(speed,relativValueMin,relativValueMax,nrOfTimes);
	}
	
	public FadeInOutRedUpdatable(IEvent event, float speed, float relativValue, int nrOfTimes) 
	{
		super(event,speed,relativValue,nrOfTimes);
	}
	
	public FadeInOutRedUpdatable(IEvent event, float speed, float relativValue) 
	{
		super(event,speed,relativValue);
	}
	
	public FadeInOutRedUpdatable(float speed, float relativValue, int nrOfTimes) 
	{
		super(speed,relativValue,nrOfTimes);	
	}
	
	public FadeInOutRedUpdatable(float speed, float relativValue) 
	{
		super(speed,relativValue);	
	}

	public FadeInOutRedUpdatable(IEvent event,float relativValue, int nrOfTimes)
	{
		super(event,relativValue, nrOfTimes);
	}
	
	public FadeInOutRedUpdatable(IEvent event,float relativValue)
	{
		super(event,relativValue);
	}

	public FadeInOutRedUpdatable(float relativValue, int nrOfTimes)
	{
		super(relativValue, nrOfTimes);
	}
	
	public FadeInOutRedUpdatable(float relativValue)
	{
		super(relativValue);
	}

	public FadeInOutRedUpdatable(IEvent event, int nrOfTimes)
	{
		super(event, nrOfTimes);
	}
	
	public FadeInOutRedUpdatable(IEvent event)
	{
		super(event);
	}

	protected void inc(float inc)
	{
		mParent.incRed(inc);
	}
	
	@Override
	public void init() {

	}
}