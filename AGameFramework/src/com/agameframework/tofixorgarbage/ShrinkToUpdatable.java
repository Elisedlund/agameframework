//package com.agameframework.tofixorgarbage;
//
//import com.agameframework.interfaces.IEvent;
//import com.agameframework.object.Updatable;
//
//public class ShrinkToUpdatable extends Updatable{
//
//	private static final float DEFAULT_START = 0f;
//	private static final float DEFAULT_SPEED = 0.01f;
//	private static final float DEFAULT_FADETO = 1f;
//
//	private float mShrinkTo;
//	private float mSpeed;
//	private float mStartValue;
//	private IEvent mEvent = null;
//
//	public ShrinkToUpdatable(IEvent event, float startValue,  float speed,  float shrinkTo)
//	{
//		this(startValue,speed,shrinkTo);
//		mEvent = event;
//	}
//
//	public ShrinkToUpdatable(float startValue,  float speed,  float shrinkTo)
//	{
//		mStartValue = startValue;
//		mSpeed = speed;
//		mShrinkTo = shrinkTo;
//	}
//
//	public ShrinkToUpdatable(IEvent event, float speed,  float shrinkTo)
//	{
//		this(event,DEFAULT_START,speed,shrinkTo);
//	}
//
//	public ShrinkToUpdatable(float speed,  float shrinkTo)
//	{
//		this(DEFAULT_START,speed,shrinkTo);
//	}
//
//	public ShrinkToUpdatable(IEvent event,float shrinkTo)
//	{
//		this(event,DEFAULT_START,DEFAULT_SPEED,shrinkTo);
//	}
//
//	public ShrinkToUpdatable(float shrinkTo)
//	{
//		this(DEFAULT_START,DEFAULT_SPEED,shrinkTo);
//	}
//
//	public ShrinkToUpdatable(IEvent event)
//	{
//		this(event,DEFAULT_START,DEFAULT_SPEED,DEFAULT_FADETO);
//	}
//
//	public ShrinkToUpdatable()
//	{
//		this(DEFAULT_START,DEFAULT_SPEED,DEFAULT_FADETO);
//	}
//	@Override
//	public void init() {
//		//TODO no start value
//		mParent.setScale(mStartValue);
//	}
//	
//	@Override
//	public void update() {
//		if((mParent.getScaleX() - mSpeed) <= mShrinkTo) //if done 
//		{
//			mParent.setScale(mShrinkTo);
//			if(mEvent != null)
//			{
//				mEvent.invokeEvent();  //do event. if exists
//			}
//			remove(); // remove itself
//			return;
//		}
//		mParent.incScale(-mSpeed);		
//	}
//}