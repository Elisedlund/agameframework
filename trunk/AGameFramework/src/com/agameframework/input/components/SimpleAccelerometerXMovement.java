package com.agameframework.input.components;

import com.agameframework.input.AccelerometerListener;
import com.agameframework.input.GameInput;
import com.agameframework.interfaces.IRemovable;
import com.agameframework.object.GameNode;
import com.agameframework.object.Rectangle;

public class SimpleAccelerometerXMovement implements AccelerometerListener ,IRemovable {

	private Rectangle mRect;
	
	//TODO impact and all? or keep it simple?

	private SimpleAccelerometerXMovement(Rectangle r)
	{
		mRect = r;
		GameInput.addAccelerometerListener(this);
	}

	public static SimpleAccelerometerXMovement add(GameNode gameNodeAddTo)
	{
		SimpleAccelerometerXMovement sam = new SimpleAccelerometerXMovement(gameNodeAddTo);
		gameNodeAddTo.addRemovable(sam);
		return sam;
	}
	
	@Override
	public void AccelerometerUpdate(float x, float y, float z) {
		mRect.decX(x);
	}

	@Override
	public void remove() {
		GameInput.removeAccelerometerListener(this);
	}

}
