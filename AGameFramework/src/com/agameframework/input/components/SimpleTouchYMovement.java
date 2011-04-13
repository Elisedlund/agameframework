/*
 * Copyright (C) 2010 Elis Edlund.
 */
package com.agameframework.input.components;

import android.view.MotionEvent;

import com.agameframework.Game;
import com.agameframework.input.GameInput;
import com.agameframework.input.TouchDownListener;
import com.agameframework.input.TouchMoveListener;
import com.agameframework.interfaces.IRemovable;
import com.agameframework.object.GameNode;
import com.agameframework.object.Rectangle;

public class SimpleTouchYMovement implements TouchDownListener, TouchMoveListener, IRemovable{

	private Rectangle mRect;
	
	private SimpleTouchYMovement(Rectangle rect)
	{
		mRect = rect;
		GameInput.addTouchDownListner(this);
		GameInput.addTouchMoveListner(this);
	}

	public static SimpleTouchYMovement add(GameNode gameNodeAddTo)
	{
		SimpleTouchYMovement stm = new SimpleTouchYMovement(gameNodeAddTo);
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
		mRect.setY(Math.abs(event.getY()-Game.getHeight()));
	}

	@Override
	public void touchMove(MotionEvent event) {
		mRect.setY(Math.abs(event.getY()-Game.getHeight()));
	}
}
