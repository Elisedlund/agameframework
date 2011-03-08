package com.agameframework.conditions;

import com.agameframework.Updatables.MovementUpdatable;
import com.agameframework.interfaces.ICondition;

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
