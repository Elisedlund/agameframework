package com.agameframework.event;

import com.agameframework.interfaces.IEvent;
import com.agameframework.updatables.MovementUpdatable;

public class InvertYMotionEvent implements IEvent{

	private MovementUpdatable mMovement;

	public InvertYMotionEvent(MovementUpdatable movement) {
		mMovement = movement;
	}

	@Override
	public void invokeEvent() {
		mMovement.mYMotion *= -1;

	}


}
