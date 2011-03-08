package com.agameframework.event;

import com.agameframework.debug.Debug;
import com.agameframework.interfaces.IEvent;
import com.agameframework.object.GameNode;

public class CreateGameNodeEvent implements IEvent{

	private float mX=0; 
	private float mY=0;
	private Class<GameNode> mClass;
	private GameNode mAddTo;

	public CreateGameNodeEvent(Class c,GameNode addTo,float x, float y)
	{
		mX = x;
		mY = y;
		mClass = c;
		mAddTo = addTo;
	}

	public CreateGameNodeEvent(Class c,GameNode addTo)
	{
		mClass = c;
		mAddTo = addTo;
	}

	@Override
	public void invokeEvent() {
		GameNode gn = null;
		try {
			gn = mClass.newInstance();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
			Debug.warning("Do the class: " + mClass +" have a empty constructor?");
		}
		if(mX != 0 || mY != 0)
		{
			gn.setXY(mX, mY);
		}
		mAddTo.add(gn);
	}

}
