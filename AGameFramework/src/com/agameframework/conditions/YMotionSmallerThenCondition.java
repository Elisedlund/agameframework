package com.agameframework.conditions;

import com.agameframework.interfaces.ICondition;
import com.agameframework.updatables.MovementUpdatable;

public class YMotionSmallerThenCondition implements ICondition{


	private MovementUpdatable mMov;
	private float mSmallerThen;
	
	public YMotionSmallerThenCondition(MovementUpdatable mov, float y)
	{
		mMov = mov;
		mSmallerThen = y;
	}
	
	@Override
	public boolean getBoolean() {

		return mMov.mYMotion < mSmallerThen;
	}

}
