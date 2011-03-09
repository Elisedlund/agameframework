/*
 * Copyright (C) 2010 Elis Edlund.
 */
package com.agameframework.input.components;

import android.view.MotionEvent;

import com.agameframework.input.GameInput;
import com.agameframework.input.TrackballListener;
import com.agameframework.interfaces.IRemovable;
import com.agameframework.object.GameNode;
import com.agameframework.object.Rectangle;

public class SimpleTrackballMovement implements TrackballListener , IRemovable{

	private Rectangle mRect;

	//TODO inpact osv.
	
	private SimpleTrackballMovement(Rectangle rect)
	{
		mRect = rect;
		GameInput.addTrackballListener(this);
	}

	public static SimpleTrackballMovement add(GameNode gameNodeAddTo)
	{
		SimpleTrackballMovement stm = new SimpleTrackballMovement(gameNodeAddTo);
		gameNodeAddTo.addRemovable(stm);
		return stm;
	}
	
	/* (non-Javadoc)
	 * @see com.elis.agameengine.input.TrackballListener#trackballMoved(android.view.MotionEvent)
	 * if there is no trackball the keypress will be invoked instead
	 */
	@Override
	public void trackballMoved(MotionEvent event) {
		mRect.incX(event.getX());	
		mRect.incY(-event.getY());	
	}

	@Override
	public void remove() {
		GameInput.removeTrackballListener(this);	
	}
}
