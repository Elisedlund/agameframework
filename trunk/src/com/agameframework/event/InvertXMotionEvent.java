package com.agameframework.event;

import com.agameframework.Updatables.MovementUpdatable;
import com.agameframework.interfaces.IEvent;

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
