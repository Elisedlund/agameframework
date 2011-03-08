package com.agameframework.input.components;

import com.agameframework.Updatables.MovementUpdatable;
import com.agameframework.input.AccelerometerListener;
import com.agameframework.input.GameInput;
import com.agameframework.interfaces.IRemovable;
import com.agameframework.object.GameNode;

public class AccelerometerMovement implements AccelerometerListener ,IRemovable {

	private MovementUpdatable mMovement;
	private float mMaxSpeed = 8; 
	private float mImpact = 0.1f;
	private float mInvertX = 1f;
	private float mInvertY = -1f;

	private AccelerometerMovement(MovementUpdatable m) 
	{
		mMovement=m;
		GameInput.addAccelerometerListener(this);
	}
	 
	public static AccelerometerMovement add(GameNode gameNodeAddTo, MovementUpdatable movement)
	{
		AccelerometerMovement am = new AccelerometerMovement(movement);
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

		if (mMovement.mYMotion < mMaxSpeed && mMovement.mYMotion > -mMaxSpeed)
		{
			mMovement.mYMotion += y*mImpact*mInvertY;
		}
		else if (mMovement.mYMotion > mMaxSpeed)
		{
			mMovement.mYMotion = mMaxSpeed;	
		}
		else if (mMovement.mYMotion < -mMaxSpeed)
		{
			mMovement.mYMotion =- mMaxSpeed;
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
