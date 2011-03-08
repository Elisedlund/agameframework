package com.agameframework.conditions;

import com.agameframework.interfaces.ICondition;
import com.agameframework.object.Rectangle;

public class YSmallerThenCondition implements ICondition{


	private Rectangle mRect;
	private float mSmallerThen;
	
	public YSmallerThenCondition(Rectangle rect, float y)
	{
		mRect = rect;
		mSmallerThen = y;
	}
	
	@Override
	public boolean getBoolean() {

		return mRect.getY() < mSmallerThen;
	}

}
