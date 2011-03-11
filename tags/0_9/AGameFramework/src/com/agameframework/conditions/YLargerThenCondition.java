package com.agameframework.conditions;

import com.agameframework.interfaces.ICondition;
import com.agameframework.object.Rectangle;

public class YLargerThenCondition implements ICondition{


	private Rectangle mRect;
	private float mLargerThen;
	
	public YLargerThenCondition(Rectangle rect, float y)
	{
		mRect = rect;
		mLargerThen = y;
	}
	
	@Override
	public boolean getBoolean() {

		return mRect.getY() > mLargerThen;
	}

}
