package com.agameframework.updatables;


public class PulsatingSizeUpdatable extends GrowShrinkToUpdatable{

	public PulsatingSizeUpdatable(float speed, float min, float max)
	{
		super(speed, min, max, -1);
	}

	public PulsatingSizeUpdatable(float min, float max)
	{
		super(0.02f, min, max, -1);
	}
	
	@Override
	public void init() {}
}
