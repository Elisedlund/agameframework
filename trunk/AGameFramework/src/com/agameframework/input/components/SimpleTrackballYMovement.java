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

public class SimpleTrackballYMovement implements TrackballListener , IRemovable{

	private Rectangle mRect;

	//TODO inpact osv.
	
	private SimpleTrackballYMovement(Rectangle rect)
	{
		mRect = rect;
		GameInput.addTrackballListener(this);
	}

	public static SimpleTrackballYMovement add(GameNode gameNodeAddTo)
	{
		SimpleTrackballYMovement stm = new SimpleTrackballYMovement(gameNodeAddTo);
		gameNodeAddTo.addRemovable(stm);
		return stm;
	}
	
	/* (non-Javadoc)
	 * @see com.elis.agameengine.input.TrackballListener#trackballMoved(android.view.MotionEvent)
	 */
	@Override
	public void trackball(MotionEvent event) {
		mRect.incY(-event.getY());	
	}

	@Override
	public void remove() {
		GameInput.removeTrackballListener(this);	
	}
}
