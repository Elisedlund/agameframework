package com.agameframework.input.components;

import com.agameframework.input.AccelerometerListener;
import com.agameframework.input.GameInput;
import com.agameframework.interfaces.IRemovable;
import com.agameframework.object.GameNode;
import com.agameframework.object.Rectangle;

public class SimpleAccelerometerYMovement implements AccelerometerListener ,IRemovable {

	private Rectangle mRect;
	
	//TODO impact and all? or keep it simple?

	private SimpleAccelerometerYMovement(Rectangle r)
	{
		mRect = r;
		GameInput.addAccelerometerListener(this);
	}

	public static SimpleAccelerometerYMovement add(GameNode gameNodeAddTo)
	{
		SimpleAccelerometerYMovement sam = new SimpleAccelerometerYMovement(gameNodeAddTo);
		gameNodeAddTo.addRemovable(sam);
		return sam;
	}
	
	@Override
	public void AccelerometerUpdate(float x, float y, float z) {
		mRect.decY(y);
	}

	@Override
	public void remove() {
		GameInput.removeAccelerometerListener(this);
	}

}
