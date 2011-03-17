package com.agameframework.updatables;

import com.agameframework.interfaces.IEvent;
import com.agameframework.object.Rectangle;
import com.agameframework.object.Updatable;



public class CollisionUpdatable extends Updatable {

	private Rectangle mRect1;
	private Rectangle mRect2;
	private IEvent mEvent;


	public CollisionUpdatable(Rectangle rect1, Rectangle rect2, IEvent event) {
		mRect1 = rect1;
		mRect2 = rect2;
		mEvent = event;
	}

	@Override
	public void update()
	{
		if(mRect1.isCollision(mRect2))
		{
			mEvent.invokeEvent();
		}
	}

	@Override
	public void init() {

	}

}
