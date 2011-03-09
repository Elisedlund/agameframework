package com.agameframework.conditions;

import com.agameframework.interfaces.ICondition;
import com.agameframework.updatables.MovementUpdatable;

public class XMotionSmallerThenCondition implements ICondition{


	private MovementUpdatable mMov;
	private float mSmallerThen;
	
	public XMotionSmallerThenCondition(MovementUpdatable mov, float x)
	{
		mMov = mov;
		mSmallerThen = x;
	}
	
	@Override
	public boolean getBoolean() {

		return mMov.mXMotion < mSmallerThen;
	}

}
