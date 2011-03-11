package com.agameframework.conditions;

import com.agameframework.interfaces.ICondition;
import com.agameframework.object.Rectangle;

public class XSmallerThenCondition implements ICondition{


	private Rectangle mRect;
	private float mSmallerThen;
	
	public XSmallerThenCondition(Rectangle rect, float x)
	{
		mRect = rect;
		mSmallerThen = x;
	}
	
	@Override
	public boolean getBoolean() {

		return mRect.getX() < mSmallerThen;
	}

}
