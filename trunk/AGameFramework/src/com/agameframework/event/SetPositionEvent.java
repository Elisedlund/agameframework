package com.agameframework.event;

import com.agameframework.interfaces.IEvent;
import com.agameframework.object.Rectangle;

public class SetPositionEvent implements IEvent{

	private Rectangle mRect;
	private float mX;
	private float mY;

	public SetPositionEvent(Rectangle rect, float newx ,float newy)
	{
		mRect = rect;
		mX = newx;
		mY = newy;
	}

	@Override
	public void invokeEvent() {
		mRect.setXY(mX, mY);
	}

}
