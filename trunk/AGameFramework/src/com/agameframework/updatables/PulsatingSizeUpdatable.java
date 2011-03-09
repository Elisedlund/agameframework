package com.agameframework.updatables;

import com.agameframework.object.Updatable;
import com.agameframework.utils.PulsatingFloat;

public class PulsatingSizeUpdatable extends Updatable{

	private PulsatingFloat mPulse;

	public PulsatingSizeUpdatable(float startValue, float direction, float speed, float min, float max)
	{
		mPulse = new PulsatingFloat(startValue, direction, speed, min, max);
	}

	public PulsatingSizeUpdatable(float speed, float min, float max)
	{
		mPulse = new PulsatingFloat(min, 1f, speed, min, max);
	}
	
	public PulsatingSizeUpdatable(float min, float max)
	{
		mPulse = new PulsatingFloat(min, 1f, 0.02f, min, max);
	}
	
	@Override
	public void update() {
		mPulse.update();
		mParent.setScale(mPulse.getCurrentValue());	
	}

	@Override
	public void init() {
	}
}
