package com.agameframework.updatables;


public class PulsatingXUpdatable extends PulseXUpdatable
{	

	public PulsatingXUpdatable(float speed, float min, float max)
	{
		super(speed, min, max, -1);
	}

	public PulsatingXUpdatable(float min, float max)
	{
		super(1f, min, max, -1);
	}
}