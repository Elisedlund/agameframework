package com.agameframework.elis.firstgame;

import com.agameframework.Game;
import com.agameframework.event.ChangeStateEvent;
import com.agameframework.event.CompositeEvent;
import com.agameframework.event.ResetScoreEvent;
import com.agameframework.input.components.DoEventOnTouchDown;
import com.agameframework.interfaces.IEvent;
import com.agameframework.object.GameNode;

public class RestartRoot extends GameNode{
	
	@Override
	public void init()
	{
		GameNode text = new GameNode("Touch to restart!");
		text.setXY(Game.getCenterX(), Game.getCenterY());
		text.setScale(1f);
		add(text);	
		
		IEvent resetScore = new ResetScoreEvent();
		IEvent restartGame = new ChangeStateEvent(new GameRoot());
		IEvent tot = new CompositeEvent(restartGame,resetScore);
		
		DoEventOnTouchDown.add(text, tot);
	}
}
