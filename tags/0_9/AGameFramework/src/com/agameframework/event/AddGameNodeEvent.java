package com.agameframework.event;

import com.agameframework.interfaces.IEvent;
import com.agameframework.object.GameNode;

public class AddGameNodeEvent implements IEvent{

	private GameNode mNodeToAdd;
	private GameNode mGameNode;
	
	public AddGameNodeEvent(GameNode nodetoadd, GameNode parentgameNode)
	{
		mNodeToAdd = nodetoadd;
		mGameNode = parentgameNode;
	}
	
	
	
	@Override
	public void invokeEvent() {
		mGameNode.add(mNodeToAdd);
	}
}
