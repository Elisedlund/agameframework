package com.agameframework.conditions;

import com.agameframework.Updatables.MovementUpdatable;
import com.agameframework.interfaces.ICondition;

public class YMotionLargerThenCondition implements ICondition{


	private MovementUpdatable mMov;
	private float mLargerThen;
	
	public YMotionLargerThenCondition(MovementUpdatable mov, float y)
	{
		mMov = mov;
		mLargerThen = y;
	}
	
	@Override
	public boolean getBoolean() {

		return mMov.mYMotion > mLargerThen;
	}

}
