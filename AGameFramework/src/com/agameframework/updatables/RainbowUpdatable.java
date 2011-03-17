package com.agameframework.updatables;

import com.agameframework.debug.Debug;
import com.agameframework.object.Updatable;
import com.agameframework.utils.PulsatingFloat;

public class RainbowUpdatable extends Updatable{

	private PulsatingFloat mPulse1;
	private PulsatingFloat mPulse2;
	private PulsatingFloat mPulse3;

	public RainbowUpdatable(float offset)
	{
		Debug.print("off: " +offset);
		mPulse1 = new PulsatingFloat(offset+0.1f, 0.02f, 0f, 1f);
		mPulse2 = new PulsatingFloat(offset+0.2f, 0.03f, 0f, 1f);
		mPulse3 = new PulsatingFloat(offset+0.3f, 0.038f, 0f, 1f);
	}
	
	public RainbowUpdatable(float min, float max)
	{
		mPulse1 = new PulsatingFloat(min+0.1f, 0.02f, min, max);
		mPulse2 = new PulsatingFloat(min+0.2f, 0.03f, min, max);
		mPulse3 = new PulsatingFloat(min+0.3f, 0.038f, min, max);
	}
	
	@Override
	public void update() {
		mPulse1.update();
		mPulse2.update();
		mPulse3.update();
		mParent.setColor(mPulse1.getCurrentValue(),mPulse3.getCurrentValue(),mPulse2.getCurrentValue());
	}

	@Override
	public void init() {
	}
}
