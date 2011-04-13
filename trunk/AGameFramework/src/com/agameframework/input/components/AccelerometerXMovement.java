package com.agameframework.input.components;

import com.agameframework.input.AccelerometerListener;
import com.agameframework.input.GameInput;
import com.agameframework.interfaces.IRemovable;
import com.agameframework.object.GameNode;
import com.agameframework.updatables.MovementUpdatable;

public class AccelerometerXMovement implements AccelerometerListener ,IRemovable {

	private MovementUpdatable mMovement;
	private float mMaxSpeed = 8; 
	private float mImpact = 0.1f;
	private float mInvertX = 1f;
	private float mInvertY = -1f;

	private AccelerometerXMovement(MovementUpdatable m) 
	{
		mMovement=m;
		GameInput.addAccelerometerListener(this);
	}
	 
	public static AccelerometerXMovement add(GameNode gameNodeAddTo, MovementUpdatable movement)
	{
		AccelerometerXMovement am = new AccelerometerXMovement(movement);
		gameNodeAddTo.addRemovable(am);
		return am;
	}

	@Override
	public void AccelerometerUpdate(float x, float y, float z) {
		if (mMovement.mXMotion < mMaxSpeed && mMovement.mXMotion > -mMaxSpeed)
		{
			mMovement.mXMotion -= x*mImpact*mInvertX;
		}
		else if (mMovement.mXMotion > mMaxSpeed)
		{
			mMovement.mXMotion = mMaxSpeed;	
		}
		else if (mMovement.mXMotion < -mMaxSpeed)
		{
			mMovement.mXMotion = -mMaxSpeed;
		}
	}

	public void setImpact(float mImpact) {
		this.mImpact = mImpact;
	}

	public float getImpact() {
		return mImpact;
	}

	public void setMaxSpeed(float mMaxSpeed) {
		this.mMaxSpeed = mMaxSpeed;
	}

	public float getMaxSpeed() {
		return mMaxSpeed;
	}

	public void invertX() {
		mInvertX*=-1;
	}

	public void invertY() {
		mInvertY*=-1;

	}	@Override
	public void remove() {
		GameInput.removeAccelerometerListener(this);
	}
}
