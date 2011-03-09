package com.agameframework.event;

import com.agameframework.interfaces.IEvent;
import com.agameframework.updatables.MovementUpdatable;

public class InvertXMotionEvent implements IEvent{

	private MovementUpdatable mMovement;

	public InvertXMotionEvent(MovementUpdatable movement) {
		mMovement = movement;
	}

	@Override
	public void invokeEvent() {
		mMovement.mXMotion *= -1;
	}


}
