/*
 * Copyright (C) 2010 Elis Edlund.
 */
package com.agameframework.input.components;

import android.view.MotionEvent;

import com.agameframework.input.GameInput;
import com.agameframework.input.TouchDownListener;
import com.agameframework.input.TouchMoveListener;
import com.agameframework.interfaces.IRemovable;
import com.agameframework.object.GameNode;
import com.agameframework.object.Rectangle;

public class SimpleTouchXMovement implements TouchDownListener, TouchMoveListener, IRemovable{

	private Rectangle mRect;
	
	private SimpleTouchXMovement(Rectangle rect)
	{
		mRect = rect;
		GameInput.addTouchDownListner(this);
		GameInput.addTouchMoveListner(this);
	}

	public static SimpleTouchXMovement add(GameNode gameNodeAddTo)
	{
		SimpleTouchXMovement stm = new SimpleTouchXMovement(gameNodeAddTo);
		gameNodeAddTo.addRemovable(stm);
		return stm;
	}
	
	@Override
	public void remove() {
		GameInput.removeTouchDownListner(this);
		GameInput.removeTouchMoveListner(this);
	}

	@Override
	public void touchDown(MotionEvent event) {
		mRect.setX(event.getX());
	}

	@Override
	public void touchMove(MotionEvent event) {
		mRect.setX(event.getX());
	}
}
