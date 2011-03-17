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
		mSprite.setRandomColor();
	}

	public static void invoke(Sprite sprite)
	{
		sprite.setRandomColor();
	}
}
