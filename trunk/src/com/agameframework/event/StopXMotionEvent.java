package com.agameframework.event;

import com.agameframework.Updatables.MovementUpdatable;
import com.agameframework.interfaces.IEvent;

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
