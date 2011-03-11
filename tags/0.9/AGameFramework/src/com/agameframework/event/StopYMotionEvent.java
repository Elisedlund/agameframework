package com.agameframework.event;

import com.agameframework.interfaces.IEvent;
import com.agameframework.updatables.MovementUpdatable;

public class StopYMotionEvent implements IEvent{

	private MovementUpdatable mMovement;

	public StopYMotionEvent(MovementUpdatable movement) {
		mMovement = movement;
	}

	@Override
	public void invokeEvent() {
		mMovement.mYMotion = 0;

	}


}
