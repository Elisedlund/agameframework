package com.agameframework.event;

import com.agameframework.interfaces.IEvent;
import com.agameframework.updatables.MovementUpdatable;

public class StopXMotionEvent implements IEvent{

	private MovementUpdatable mMovement;

	public StopXMotionEvent(MovementUpdatable movement) {
		mMovement = movement;
	}

	@Override
	public void invokeEvent() {
		mMovement.mXMotion = 0;

	}


}
