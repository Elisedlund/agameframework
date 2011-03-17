package com.agameframework.updatables;


public class PulsatingOpacityUpdatable extends FadeInOutUpdatable{

	public PulsatingOpacityUpdatable(float speed, float min, float max)
	{
		super(speed, min, max, -1);
	}

	public PulsatingOpacityUpdatable(float min, float max)
	{
		super(0.02f, min, max, -1);
	}
	
	@Override
	public void init() {}
}
