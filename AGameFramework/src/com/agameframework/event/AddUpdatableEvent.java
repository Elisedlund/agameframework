package com.agameframework.event;

import com.agameframework.interfaces.IEvent;
import com.agameframework.object.GameNode;
import com.agameframework.object.Updatable;

public class AddUpdatableEvent implements IEvent{

	private Updatable mUpdateble;
	private GameNode mGameNode;
	
	public AddUpdatableEvent(Updatable updateable, GameNode gameNode)
	{
		mUpdateble = updateable;
		mGameNode = gameNode; 
	}
	
	@Override
	public void invokeEvent() {
		mGameNode.addUpdateable(mUpdateble);//TODO FIX IUpdatable / Updateable
	}
}
