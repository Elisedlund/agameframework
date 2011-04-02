package com.agameframework.updatables;

import com.agameframework.debug.Debug;
import com.agameframework.interfaces.IEvent;
import com.agameframework.object.Updatable;
import com.agameframework.utils.PulsatingFloat;

public abstract class AbstractPulsatingUpdatable extends Updatable
{	

	private static final float DEFAULT_SPEED = 0.01f;
	private static final float DEFAULT_RELATIV_VALUE = 1f; 

	private PulsatingFloat mPulse;
	private IEvent mEvent = null;


	public AbstractPulsatingUpdatable(float speed, float relativValueMin, float relativValueMax, int nrOfTimes) 
	{
		//TODO error.
		if(speed<0)
		{
			mPulse = new PulsatingFloat(relativValueMax,speed,relativValueMin,relativValueMax, nrOfTimes);
		}
		else
		{
			mPulse = new PulsatingFloat(relativValueMin,speed,relativValueMin,relativValueMax, nrOfTimes);
		}	
	}
	public AbstractPulsatingUpdatable(IEvent event,float speed, float relativValueMin, float relativValueMax, int nrOfTimes) 
	{
		this(speed, relativValueMin, relativValueMax, nrOfTimes);
		mEvent = event;
	}

	public AbstractPulsatingUpdatable(float speed, float relativValue, int nrOfTimes) 
	{
		this(speed,0,Math.abs(relativValue),nrOfTimes);
	}

	public AbstractPulsatingUpdatable(IEvent event, float speed, float relativValue, int nrOfTimes) 
	{
		this(speed,relativValue,nrOfTimes);
		mEvent = event;
	}

	public AbstractPulsatingUpdatable(float speed, float relativValue) 
	{
		this(speed,relativValue,1);
	}

	public AbstractPulsatingUpdatable(IEvent event, float speed, float relativValue) 
	{
		this(speed,relativValue,1);
		mEvent = event;
	}

	public AbstractPulsatingUpdatable(IEvent event,float relativValue, int nrOfTimes)
	{
		this(event,DEFAULT_SPEED,relativValue,nrOfTimes);
	}

	public AbstractPulsatingUpdatable(IEvent event,float relativValue)
	{
		this(event,DEFAULT_SPEED,relativValue);
	}

	public AbstractPulsatingUpdatable(float relativValue, int nrOfTimes)
	{
		this(DEFAULT_SPEED,relativValue,nrOfTimes);

	}
	public AbstractPulsatingUpdatable(float relativValue)
	{
		this(DEFAULT_SPEED,relativValue,1);
	}

	public AbstractPulsatingUpdatable(IEvent event, int nrOfTimes)
	{
		this(event,DEFAULT_SPEED,DEFAULT_RELATIV_VALUE, nrOfTimes);
	}

	public AbstractPulsatingUpdatable(IEvent event)
	{
		this(event,DEFAULT_SPEED,DEFAULT_RELATIV_VALUE);
	}

	@Override
	public void update() 
	{
		if(mPulse.isDone() == false)
		{
			mPulse.update();
			inc(mPulse.getDiff());
			if(mPulse.isDone())
			{
				done();	
			}
		}
	}

	protected abstract void inc(float inc);

	protected void done()
	{
		if(mEvent != null)
		{
			mEvent.invokeEvent();  //do event. if exists
		}
		remove(); // remove itself
	}

	@Override
	public void init() {}
}