package com.agameframework.updatables;


public class PulsatingYUpdatable extends PulseYUpdatable
{	

	public PulsatingYUpdatable(float speed, float min, float max)
	{
		super(speed, min, max, -1);
	}

	public PulsatingYUpdatable(float min, float max)
	{
		super(1f, min, max, -1);
	}
}