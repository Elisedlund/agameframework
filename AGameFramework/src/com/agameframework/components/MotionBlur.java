package com.agameframework.components;

import com.agameframework.debug.Debug;
import com.agameframework.event.CallMethodEvent;
import com.agameframework.object.GameNode;
import com.agameframework.updatables.FadeInOutUpdatable;

public class MotionBlur extends GameNode{

	private GameNode mNodeToBlur = null;
	
	private int currentBlurCount = 0;
	private int mBlurCount = 10;
	
	private float mFadeTo = 0.0f;
	private float mRelativStart = -0.7f;
	private float mFadeSpeed = 0.05f;

	public MotionBlur(float relativStart,float fadespeed, float fadeTo)
	{
		mRelativStart = relativStart;
		mFadeTo = fadeTo;
		mFadeSpeed = fadespeed;
	}
	
	public MotionBlur(float relativStart,float fadespeed)
	{
		mRelativStart = relativStart;
		mFadeSpeed = fadespeed;
	}
	
	public MotionBlur(float fadespeed)
	{
		mFadeSpeed = fadespeed;
	}
	
	@Override
	public void init()
	{
		mBlurCount = (int) Math.ceil(((mParent.mOpacity + mRelativStart - mFadeTo) / mFadeSpeed));
		mNodeToBlur = mParent; //quick fix.
	}
	
	public void update()
	{
		super.update();
		if(currentBlurCount < mBlurCount)
		{
			currentBlurCount++;
			mParent.add(new Fade());
		}
	}
	
	private class Fade extends GameNode
	{
		public Fade()
		{
			super(mNodeToBlur.getTexture());
			reset();		
		}

		public void reset()
		{
			setXY(mNodeToBlur.getX(), mNodeToBlur.getY());
			setScale(mNodeToBlur.getScaleX(), mNodeToBlur.getScaleY());
			mOpacity = mNodeToBlur.mOpacity + mRelativStart;//start opacity.
			addUpdateable(new FadeInOutUpdatable(new CallMethodEvent(this,"reset"),-mFadeSpeed,-mOpacity));
		}
	}

}//end of class
