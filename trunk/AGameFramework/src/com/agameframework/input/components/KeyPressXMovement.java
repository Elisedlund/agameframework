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

public class KeyPressXMovement implements KeyPressListener , IRemovable{


	private MovementUpdatable mMovement;
	private float mMaxSpeed = 8f;
	private float mImpact = 1.0f;

	private KeyPressXMovement(MovementUpdatable om)
	{
		mMovement = om;
		GameInput.addKeyPressListner(this);
	}
	
	public static KeyPressXMovement add(GameNode gameNodeAddTo, MovementUpdatable movement)
	{
		KeyPressXMovement kpm = new KeyPressXMovement(movement);
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
		return false;
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
