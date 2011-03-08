package com.agameframework.input.components;

import com.agameframework.input.AccelerometerListener;
import com.agameframework.input.GameInput;
import com.agameframework.interfaces.IRemovable;
import com.agameframework.object.GameNode;
import com.agameframework.object.Rectangle;

public class SimpleAccelerometerMovement implements AccelerometerListener ,IRemovable {

	private Rectangle mRect;
	
	//TODO impact and all? or keep it simple?

	private SimpleAccelerometerMovement(Rectangle r)
	{
		mRect = r;
		GameInput.addAccelerometerListener(this);
	}

	public static SimpleAccelerometerMovement add(GameNode gameNodeAddTo)
	{
		SimpleAccelerometerMovement sam = new SimpleAccelerometerMovement(gameNodeAddTo);
		gameNodeAddTo.addRemovable(sam);
		return sam;
	}
	
	@Override
	public void AccelerometerUpdate(float x, float y, float z) {
		mRect.decX(x);
		mRect.decY(y);
	}

	@Override
	public void remove() {
		GameInput.removeAccelerometerListener(this);
	}

}
