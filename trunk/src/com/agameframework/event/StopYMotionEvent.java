package com.agameframework.event;

import com.agameframework.Updatables.MovementUpdatable;
import com.agameframework.interfaces.IEvent;

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
