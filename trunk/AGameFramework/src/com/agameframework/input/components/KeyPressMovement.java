/*
 * Copyright (C) 2010 Elis Edlund.
 */
package com.agameframework.input.components;

import android.view.KeyEvent;

import com.agameframework.input.GameInput;
import com.agameframework.input.KeyPressListener;
import com.agameframework.interfaces.IRemovable;
import com.agameframework.object.GameNode;
import com.agameframework.updatables.MovementUpdatable;

public class KeyPressMovement implements KeyPressListener , IRemovable{


	private MovementUpdatable mMovement;
	private float mMaxSpeed = 8f;
	private float mImpact = 1.0f;

	private KeyPressMovement(MovementUpdatable om)
	{
		mMovement = om;
		GameInput.addKeyPressListner(this);
	}
	
	public static KeyPressMovement add(GameNode gameNodeAddTo, MovementUpdatable movement)
	{
		KeyPressMovement kpm = new KeyPressMovement(movement);
		gameNodeAddTo.addRemovable(kpm);
		return kpm;
	}
	
	@Override
	public boolean keyPress(int keyCode, KeyEvent msg) {
		if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT
				|| keyCode == KeyEvent.KEYCODE_A)
		{
			if (mMovement.mXMotion > -getMaxSpeed())
			{
				mMovement.mXMotion -= getImpact();				
			}
			return true;
		}
		else if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT
				|| keyCode == KeyEvent.KEYCODE_D)
		{
			if (mMovement.mXMotion < getMaxSpeed())
			{
				mMovement.mXMotion += getImpact();				
			}
			return true;
		}
		if (keyCode == KeyEvent.KEYCODE_DPAD_UP
				|| keyCode == KeyEvent.KEYCODE_W)
		{
			if (mMovement.mYMotion > -getMaxSpeed())
			{
				mMovement.mYMotion -= getImpact();				
			}
			return true;
		}
		else if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN
				|| keyCode == KeyEvent.KEYCODE_S)
		{
			if (mMovement.mYMotion < getMaxSpeed())
			{
				mMovement.mXMotion += getImpact();				
			}
			return true;
		}
		return true;
	}


	public void setMaxSpeed(float mMaxSpeed) {
		this.mMaxSpeed = mMaxSpeed;
	}


	public float getMaxSpeed() {
		return mMaxSpeed;
	}


	public void setImpact(float mImpact) {
		this.mImpact = mImpact;
	}


	public float getImpact() {
		return mImpact;
	}


	@Override
	public void remove() {
		GameInput.removeKeyPressListner(this);
	}
}
