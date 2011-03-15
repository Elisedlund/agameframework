package com.agameframework.event;

import com.agameframework.interfaces.IEvent;
import com.agameframework.object.Sprite;

public class SetRandomColorEvent implements IEvent{

	private Sprite mSprite;

	public SetRandomColorEvent(Sprite sprite)
	{
		mSprite = sprite;
	}

	@Override
	public void invokeEvent() 
	{
		mSprite.setColor((float)Math.random(), (float)Math.random(), (float)Math.random());
	}

	public static void invoke(Sprite sprite)
	{
		sprite.setColor((float)Math.random(), (float)Math.random(), (float)Math.random());
	}
}
