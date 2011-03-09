package com.agameframework.updatables;

import com.agameframework.interfaces.IEvent;
import com.agameframework.object.Updatable;

public class GrowShrinkToUpdatable extends Updatable{

	private static final float DEFAULT_SPEED = 0.01f;
	private static final float DEFAULT_GROWSHRINKTO = 1f;

	private float mGrowShrinkTo;
	private float mSpeed;
	private float mCurrent = 0;
	private IEvent mEvent = null;

	public GrowShrinkToUpdatable(IEvent event, float speed, float growshrinkTo)
	{
		this(speed,growshrinkTo);
		mEvent = event;
	}

	public GrowShrinkToUpdatable(float speed, float growshrinkTo)
	{
		mSpeed = speed;
		mGrowShrinkTo = growshrinkTo;
	}

	public GrowShrinkToUpdatable(IEvent event,float growshrinkTo)
	{
		this(event,DEFAULT_SPEED,growshrinkTo);
	}

	public GrowShrinkToUpdatable(float growshrinkTo)
	{
		this(DEFAULT_SPEED,growshrinkTo);
	}

	/**
	 * Grow one size with a default speed. size->endSize 0->1, 2->3 and do a event at the end. 
	 */
	public GrowShrinkToUpdatable(IEvent event)
	{
		this(event,DEFAULT_SPEED,DEFAULT_GROWSHRINKTO);
	}

	/**
	 * Grow one size with a default speed. size->endSize 0->1, 2->3
	 */
	public GrowShrinkToUpdatable()
	{
		this(DEFAULT_SPEED,DEFAULT_GROWSHRINKTO);
	}

	@Override
	public void update() {

		if(mSpeed > 0) //grow 
		{
			if(mCurrent + mSpeed >= mGrowShrinkTo) //if done growing
			{
				mParent.incScale(mGrowShrinkTo - mCurrent); //grow whats left.
				if(mEvent != null)
				{
					mEvent.invokeEvent();  //do event. if exists
				}
				remove(); // remove itself
				return;
			}
		}
		else //shrink
		{
			if(mCurrent + mSpeed <= mGrowShrinkTo) //if done shrinking
			{
				mParent.incScale(mGrowShrinkTo - mCurrent); //shrink whats left.
				if(mEvent != null)
				{
					mEvent.invokeEvent();  //do event. if exists
				}
				remove(); // remove itself
				return;
			}
		}
		mCurrent += mSpeed;
		mParent.incScale(mSpeed);
	}//end of func

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
}//end of class