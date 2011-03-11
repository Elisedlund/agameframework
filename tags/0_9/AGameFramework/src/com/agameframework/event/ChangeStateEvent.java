package com.agameframework.event;

import com.agameframework.Game;
import com.agameframework.interfaces.IEvent;
import com.agameframework.object.GameNode;

public class ChangeStateEvent implements IEvent{

	private GameNode mGameNode;
	
	public ChangeStateEvent(GameNode gameNode)
	{
		mGameNode = gameNode;
	}
	
	@Override
	public void invokeEvent() 
	{
		Game.setGameRoot(mGameNode);
	}
	
	public static void invoke(GameNode nextState)
	{
		Game.setGameRoot(nextState);	
	}	
}
