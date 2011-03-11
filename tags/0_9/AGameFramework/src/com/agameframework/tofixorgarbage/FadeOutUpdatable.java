//package com.agameframework.tofixorgarbage;
//
//import com.agameframework.interfaces.IEvent;
//import com.agameframework.object.Updatable;
//
//public class FadeOutUpdatable extends Updatable{
//
//	private static final float DEFAULT_SPEED = 0.1f;
//	private static final float DEFAULT_FADETO = 0f;
//
//	private float mFadeTo;
//	private float mSpeed;
//	private IEvent mEvent = null;
//
//	public FadeOutUpdatable(IEvent event, float speed,  float fadeTo)
//	{
//		this(speed,fadeTo);
//		mEvent = event;
//	}
//
//	public FadeOutUpdatable(float speed,  float fadeTo)
//	{
//		mSpeed = speed;
//		mFadeTo = fadeTo;
//	}
//
//	public FadeOutUpdatable(IEvent event,float fadeTo)
//	{
//		this(event,DEFAULT_SPEED,fadeTo);
//	}
//
//	public FadeOutUpdatable(float fadeTo)
//	{
//		this(DEFAULT_SPEED,fadeTo);
//	}
//
//	public FadeOutUpdatable(IEvent event)
//	{
//		this(event,DEFAULT_SPEED,DEFAULT_FADETO);
//	}
//
//	public FadeOutUpdatable()
//	{
//		this(DEFAULT_SPEED,DEFAULT_FADETO);
//	}
//
//	@Override
//	public void update() {
//		if(mParent.mOpacity-mSpeed <= mFadeTo) //if done 
//		{
//			mParent.mOpacity = mFadeTo;
//			if(mEvent != null)
//			{
//				mEvent.invokeEvent();  //do event. if exists
//			}
//			remove(); // remove itself
//			return;
//		}
//		mParent.mOpacity -= mSpeed;	
//	}
//}