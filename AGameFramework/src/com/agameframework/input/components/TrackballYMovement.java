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

public class TrackballYMovement implements TrackballListener , IRemovable{

	private MovementUpdatable mMovement;
	private float mMaxSpeed = 8f;
	private float mImpact = 1.0f;

	public TrackballYMovement(MovementUpdatable movement)
	{
		mMovement = movement;
		GameInput.addTrackballListener(this);
	}

	public static TrackballYMovement add(GameNode gameNodeAddTo, MovementUpdatable movement)
	{
		TrackballYMovement tm = new TrackballYMovement(movement);
		gameNodeAddTo.addRemovable(tm);
		return tm;
	}
	
	
	/* (non-Javadoc)
	 * @see com.elis.agameengine.input.TrackballListener#trackballMoved(android.view.MotionEvent)
	 */
	@Override
	public void trackball(MotionEvent event) {
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
			mMovement.mYMotion = -getMaxSpeed();
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
