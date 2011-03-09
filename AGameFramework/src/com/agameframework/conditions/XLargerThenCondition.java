package com.agameframework.conditions;

import com.agameframework.interfaces.ICondition;
import com.agameframework.object.Rectangle;

public class XLargerThenCondition implements ICondition{


	private Rectangle mRect;
	private float mLargerThen;
	
	public XLargerThenCondition(Rectangle rect, float x)
	{
		mRect = rect;
		mLargerThen = x;
	}
	
	@Override
	public boolean getBoolean() {

		return mRect.getX() > mLargerThen;
	}

}
