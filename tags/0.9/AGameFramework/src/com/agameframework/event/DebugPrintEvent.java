package com.agameframework.event;

import com.agameframework.debug.Debug;
import com.agameframework.interfaces.IEvent;

public class DebugPrintEvent implements IEvent{

	private String mString;
	
	public DebugPrintEvent(String string)
	{
		mString = string;
	}
	
	@Override
	public void invokeEvent() {
		Debug.print(mString);
	}
}
