/*
 * Copyright (C) 2010 Elis Edlund.
 */
package com.agameframework.input.components;

import android.view.MotionEvent;

import com.agameframework.input.GameInput;
import com.agameframework.input.TrackballListener;
import com.agameframework.interfaces.IRemovable;
import com.agameframework.object.GameNode;
import com.agameframework.updatables.MovementUpdatable;

public class TrackballMovement implements TrackballListener , IRemovable{

	private MovementUpdatable mMovement;
	private float mMaxSpeed = 8f;
	private float mImpact = 1.0f;

	public TrackballMovement(MovementUpdatable movement)
	{
		mMovement = movement;
		GameInput.addTrackballListener(this);
	}

	public static TrackballMovement add(GameNode gameNodeAddTo, MovementUpdatable movement)
	{
		TrackballMovement tm = new TrackballMovement(movement);
		gameNodeAddTo.addRemovable(tm);
		return tm;
	}
	
	
	/* (non-Javadoc)
	 * @see com.elis.agameengine.input.TrackballListener#trackballMoved(android.view.MotionEvent)
	 * if there is no trackball the keypress will be invoked instead
	 */
	@Override
	public void trackballMoved(MotionEvent event) {
		if (mMovement.mXMotion < getMaxSpeed() && mMovement.mXMotion > -getMaxSpeed())
		{
			mMovement.mXMotion += event.getX()*getImpact();
		}
		else if (mMovement.mXMotion > getMaxSpeed())
		{
			mMovement.mXMotion = getMaxSpeed();	
		}
		else if (mMovement.mXMotion < -getMaxSpeed())
		{
			mMovement.mXMotion = -getMaxSpeed();
		}

		if (mMovement.mYMotion < getMaxSpeed() && mMovement.mYMotion > -getMaxSpeed())
		{
			mMovement.mYMotion -= event.getY()*getImpact();
		}
		else if (mMovement.mYMotion > getMaxSpeed())
		{
			mMovement.mYMotion = getMaxSpeed();	
		}
		else if (mMovement.mYMotion < -getMaxSpeed())
		{
			mMovement.mYMotion =- getMaxSpeed();
		}
	}

	public void setImpact(float mImpact) {
		this.mImpact = mImpact;
	}

	public float getImpact() {
		return mImpact;
	}

	public void setMaxSpeed(int mMaxSpeed) {
		this.mMaxSpeed = mMaxSpeed;
	}

	public float getMaxSpeed() {
		return mMaxSpeed;
	}

	public void setMaxSpeed(float mMaxSpeed) {
		this.mMaxSpeed = mMaxSpeed;
	}

	@Override
	public void remove() {
		GameInput.removeTrackballListener(this);
	}

}
