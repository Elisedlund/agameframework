package com.agameframework.event;

import com.agameframework.Updatables.MovementUpdatable;
import com.agameframework.interfaces.IEvent;

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
