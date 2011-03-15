package com.agameframework.event;

import com.agameframework.interfaces.IEvent;
import com.agameframework.object.Sprite;

public class SetColorEvent implements IEvent{

	private Sprite mSprite;
	private float mRed;
	private float mGreen;
	private float mBlue;

	public SetColorEvent(Sprite sprite,float red, float green, float blue)
	{
		mSprite = sprite;
		mRed = red;
		mGreen = green;
		mBlue = blue;
	}

	@Override
	public void invokeEvent() 
	{
		mSprite.setColor(mRed,mGreen,mBlue);
	}
}
