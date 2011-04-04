package com.agameframework.updatables;


public class PulsatingSizeXUpdatable extends GrowShrinkXUpdatable{

	public PulsatingSizeXUpdatable(float speed, float min, float max)
	{
		super(speed, min, max, -1);
	}

	public PulsatingSizeXUpdatable(float min, float max)
	{
		super(0.02f, min, max, -1);
	}
}
