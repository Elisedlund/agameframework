package com.agameframework.conditions;

import com.agameframework.Game;
import com.agameframework.interfaces.ICondition;
import com.agameframework.object.Rectangle;

public class OutsideScreenCondition implements ICondition{

	private Rectangle mRect;

	public OutsideScreenCondition(Rectangle rect)
	{
		mRect = rect;
	}

	@Override
	public boolean getBoolean() {
		return !mRect.isCollision(Game.getGameRectangle());
	}

}
