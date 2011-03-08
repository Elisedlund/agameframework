package com.agameframework.Updatables;

import com.agameframework.object.Updatable;
import com.agameframework.utils.PulsatingFloat;

public class PulsatingOpacityUpdatable extends Updatable{

	private PulsatingFloat mPulse;

	public PulsatingOpacityUpdatable(float startValue, float direction, float speed, float min, float max)
	{

		mPulse = new PulsatingFloat(startValue, direction, speed, min, max);
	}

	public PulsatingOpacityUpdatable(float speed, float min, float max)
	{
		mPulse = new PulsatingFloat(min, 1f, speed, min, max);
	}
	
	public PulsatingOpacityUpdatable(float min, float max)
	{
		mPulse = new PulsatingFloat(min, 1f, 0.02f, min, max);
	}
	
	@Override
	public void update() {
		mPulse.update();
		mParent.mOpacity = mPulse.getCurrentValue();	
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
}
