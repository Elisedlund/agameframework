package com.agameframework.updatables;


public class PulsatingSizeYUpdatable extends GrowShrinkYUpdatable{

	public PulsatingSizeYUpdatable(float speed, float min, float max)
	{
		super(speed, min, max, -1);
	}

	public PulsatingSizeYUpdatable(float min, float max)
	{
		super(0.02f, min, max, -1);
	}
}
