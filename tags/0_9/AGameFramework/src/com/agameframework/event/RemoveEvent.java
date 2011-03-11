package com.agameframework.event;

import com.agameframework.interfaces.IEvent;
import com.agameframework.interfaces.IRemovable;


/**
 * removes a node
 * @author Elis
 */
public class RemoveEvent implements IEvent{

	private IRemovable mNodeToRemove;
	
	public RemoveEvent(IRemovable nodetoremove)
	{
		mNodeToRemove = nodetoremove;
	}
	
	@Override
	public void invokeEvent() {
		mNodeToRemove.remove();
	}
}
