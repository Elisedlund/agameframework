package com.agameframework.event;

import com.agameframework.interfaces.IEvent;
import com.agameframework.interfaces.IUpdatable;
import com.agameframework.object.GameNode;

public class RemoveUpdatableEvent implements IEvent{

	private IUpdatable mUpdateble;
	private GameNode mGameNode;
	
	public RemoveUpdatableEvent(IUpdatable updateable, GameNode gameNode)
	{
		mUpdateble = updateable;
		mGameNode = gameNode;
	}
	
	@Override
	public void invokeEvent() {
			mGameNode.removeUpdateable(mUpdateble); //TODO FIX IUpdatable / Updateable	
	}
}
