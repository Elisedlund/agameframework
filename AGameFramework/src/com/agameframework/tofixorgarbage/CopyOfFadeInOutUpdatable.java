//package com.agameframework.tofixorgarbage;
//
//import com.agameframework.interfaces.IEvent;
//import com.agameframework.object.Updatable;
//
//public class CopyOfFadeInOutUpdatable extends Updatable{
//
//
//	private static final float DEFAULT_SPEED = 0.01f;
//	private static final float DEFAULT_FADE = 1f;
//
//	private float mFade;
//	private float mSpeed;
//	private float mCurrentFade = 0f;
//
//	private IEvent mEvent = null;
//
//	public CopyOfFadeInOutUpdatable(IEvent event, float speed, float fadeValue)
//	{
//		this(speed,fadeValue);
//		mEvent = event;
//	}
//
//	public CopyOfFadeInOutUpdatable(float speed, float fadeValue)
//	{
//		mSpeed = speed;
//		mFade = fadeValue;
//	}
//
//	public CopyOfFadeInOutUpdatable(IEvent event,float fadeValue)
//	{
//		this(event,DEFAULT_SPEED,fadeValue);
//	}
//
//	public CopyOfFadeInOutUpdatable(float fadeValue)
//	{
//		this(DEFAULT_SPEED,fadeValue);
//	}
//
//	public CopyOfFadeInOutUpdatable(IEvent event)
//	{
//		this(event,DEFAULT_SPEED,DEFAULT_FADE);
//	}
//
//	public CopyOfFadeInOutUpdatable()
//	{
//		this(DEFAULT_SPEED,DEFAULT_FADE);
//	}
//
//
//	@Override
//	public void update() {
//		if(mSpeed > 0) //fade in
//		{
//			if(mCurrentFade+mSpeed >= mFade) //if done 
//			{
//				mParent.mOpacity += mFade - mCurrentFade; //adds whats left.
//				if(mEvent != null)
//				{
//					mEvent.invokeEvent();  //do event. if exists
//				}
//				remove(); // remove itself
//				return;
//			}
//		}
//		else//fade out
//		{
//			if(mCurrentFade+mSpeed <= mFade) //if done 
//			{
//				mParent.mOpacity += mFade - mCurrentFade; //sub whats left.
//				if(mEvent != null)
//				{
//					mEvent.invokeEvent();  //do event. if exists
//				}
//				remove(); // remove itself
//				return;
//			}
//		}
//		mCurrentFade += mSpeed;
//		mParent.mOpacity += mSpeed;		
//	}
//
//	@Override
//	public void init() {
//		// TODO Auto-generated method stub
//		
//	}
//}