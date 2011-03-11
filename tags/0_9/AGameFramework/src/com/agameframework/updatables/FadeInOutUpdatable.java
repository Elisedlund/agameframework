package com.agameframework.updatables;

import com.agameframework.interfaces.IEvent;
import com.agameframework.object.Updatable;

public class FadeInOutUpdatable extends Updatable{


	private static final float DEFAULT_SPEED = 0.01f;
	private static final float DEFAULT_FADE = 1f;

	private float mFade;
	private float mSpeed;
	private float mCurrentFade = 0f;

	private IEvent mEvent = null;

	public FadeInOutUpdatable(IEvent event, float speed, float fadeValue)
	{
		this(speed,fadeValue);
		mEvent = event;
	}

	public FadeInOutUpdatable(float speed, float fadeValue)
	{
		mSpeed = speed;
		mFade = fadeValue;
	}

	public FadeInOutUpdatable(IEvent event,float fadeValue)
	{
		this(event,DEFAULT_SPEED,fadeValue);
	}

	public FadeInOutUpdatable(float fadeValue)
	{
		this(DEFAULT_SPEED,fadeValue);
	}

	public FadeInOutUpdatable(IEvent event)
	{
		this(event,DEFAULT_SPEED,DEFAULT_FADE);
	}

	public FadeInOutUpdatable()
	{
		this(DEFAULT_SPEED,DEFAULT_FADE);
	}


	@Override
	public void update() {
		if(mSpeed > 0) //fade in
		{
			if(mCurrentFade+mSpeed >= mFade) //if done 
			{
				mParent.mOpacity += mFade - mCurrentFade; //adds whats left.
				if(mEvent != null)
				{
					mEvent.invokeEvent();  //do event. if exists
				}
				remove(); // remove itself
				return;
			}
		}
		else//fade out
		{
			if(mCurrentFade+mSpeed <= mFade) //if done 
			{
				mParent.mOpacity += mFade - mCurrentFade; //sub whats left.
				if(mEvent != null)
				{
					mEvent.invokeEvent();  //do event. if exists
				}
				remove(); // remove itself
				return;
			}
		}
		mCurrentFade += mSpeed;
		mParent.mOpacity += mSpeed;		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
}