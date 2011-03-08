package com.agameframework.components;

import com.agameframework.Updatables.FadeInOutUpdatable;
import com.agameframework.event.CallMethodEvent;
import com.agameframework.object.GameNode;

public class MotionBlur extends GameNode{

	private GameNode mNodeToBlur = null;
	private int currentBlurCount = 0;

	private int maxBlurCount = 10;
	private float mFadeTo = 0.0f;
	private float mRelativStart = -0.7f;
	private float mFadeSpeed = 0.05f;

	public MotionBlur(GameNode nodeToBlur,float relativStart,float fadespeed, float fadeTo)
	{
		mNodeToBlur = nodeToBlur;
		mRelativStart= relativStart;
		mFadeTo = fadeTo;
		mFadeSpeed = fadespeed;
		maxBlurCount = (int) ((nodeToBlur.mOpacity+mRelativStart-mFadeTo) / mFadeSpeed);
	}
	
	public MotionBlur(GameNode nodeToBlur,float relativStart,float fadespeed)
	{
		mNodeToBlur = nodeToBlur;
		mRelativStart= relativStart;
		mFadeSpeed = fadespeed;
		maxBlurCount = (int) ((nodeToBlur.mOpacity+mRelativStart-mFadeTo) / mFadeSpeed);
	}
	
	public MotionBlur(GameNode nodeToBlur,float fadespeed)
	{
		mNodeToBlur = nodeToBlur;
		mFadeSpeed = fadespeed;
		maxBlurCount = (int) ((nodeToBlur.mOpacity+mRelativStart-mFadeTo) / mFadeSpeed);
	}
	
	public MotionBlur(GameNode nodeToBlur)
	{
		mNodeToBlur = nodeToBlur;
		maxBlurCount = (int) ((nodeToBlur.mOpacity+mRelativStart-mFadeTo) / mFadeSpeed);
	}

	public void update()
	{
		super.update();
		if(currentBlurCount < maxBlurCount)
		{
			currentBlurCount++;
			mNodeToBlur.add(new Fade());
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

}
