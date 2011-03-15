/*
 * Copyright (C) 2010 Elis Edlund.
 */
package com.agameframework.input.components;

import android.view.KeyEvent;
import android.view.MotionEvent;

import com.agameframework.Game;
import com.agameframework.input.GameInput;
import com.agameframework.input.KeyPressListener;
import com.agameframework.input.TouchDownListener;
import com.agameframework.input.TouchMoveListener;
import com.agameframework.interfaces.IRemovable;
import com.agameframework.object.GameNode;
import com.agameframework.object.Rectangle;

public class SimpleTouchMovement implements TouchDownListener, TouchMoveListener, IRemovable{

	private Rectangle mRect;
	
	private SimpleTouchMovement(Rectangle rect)
	{
		mRect = rect;
		GameInput.addTouchDownListner(this);
		GameInput.addTouchMoveListner(this);
	}

	public static SimpleTouchMovement add(GameNode gameNodeAddTo)
	{
		SimpleTouchMovement stm = new SimpleTouchMovement(gameNodeAddTo);
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
		mRect.setXY(event.getX(),Math.abs(event.getY()-Game.getHeight()));
	}

	@Override
	public void touchMove(MotionEvent event) {
		mRect.setXY(event.getX(),Math.abs(event.getY()-Game.getHeight()));
	}
}
