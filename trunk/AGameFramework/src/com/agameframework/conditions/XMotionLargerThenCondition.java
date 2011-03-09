package com.agameframework.conditions;

import com.agameframework.interfaces.ICondition;
import com.agameframework.updatables.MovementUpdatable;

public class XMotionLargerThenCondition implements ICondition{


	private MovementUpdatable mMov;
	private float mLargerThen;
	
	public XMotionLargerThenCondition(MovementUpdatable mov, float x)
	{
		mMov = mov;
		mLargerThen = x;
	}
	
	@Override
	public boolean getBoolean() {

		return mMov.mXMotion >  mLargerThen;
	}

}
