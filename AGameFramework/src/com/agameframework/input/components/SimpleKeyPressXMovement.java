/*
 * Copyright (C) 2010 Elis Edlund.
 */
package com.agameframework.input.components;

import android.view.KeyEvent;

import com.agameframework.input.GameInput;
import com.agameframework.input.KeyPressListener;
import com.agameframework.interfaces.IRemovable;
import com.agameframework.object.GameNode;
import com.agameframework.object.Rectangle;

public class SimpleKeyPressXMovement implements KeyPressListener , IRemovable{

	private Rectangle mRect;
	private float mImpact = 10;
	
	private SimpleKeyPressXMovement(Rectangle rect)
	{
		mRect = rect;
		GameInput.addKeyPressListner(this);
	}

	public static SimpleKeyPressXMovement add(GameNode gameNodeAddTo)
	{
		SimpleKeyPressXMovement skpm = new SimpleKeyPressXMovement(gameNodeAddTo);
		gameNodeAddTo.addRemovable(skpm);
		return skpm;
	}
	
	@Override
	public boolean keyPress(int keyCode, KeyEvent msg) {
		if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT
				|| keyCode == KeyEvent.KEYCODE_A)
		{
			mRect.incX(-mImpact);
			return true;
		}
		else if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT
				|| keyCode == KeyEvent.KEYCODE_D)
		{
			mRect.incX(mImpact);
			return true;
		}
		return false;
	}


	@Override
	public void remove() {
		GameInput.removeKeyPressListner(this);
	}
	public void setImpact(float mImpact) {
		this.mImpact = mImpact;
	}


	public float getImpact() {
		return mImpact;
	}
}
