package com.agameframework.elis.starwars;

import com.agameframework.Game;
import com.agameframework.conditions.YSmallerThenCondition;
import com.agameframework.event.ConditionEvent;
import com.agameframework.event.SetPositionEvent;
import com.agameframework.interfaces.IEvent;
import com.agameframework.object.GameNode;
import com.agameframework.updatables.EventUpdatable;

public class Star extends GameNode{


	public Star(int resid)
	{	
		super(resid);
	}
	
	@Override
	public void init()
	{
		setXY(Game.getRandomX(),Game.getRandomY());
		
		IEvent moveback = new SetPositionEvent(this, getX(), Game.getHeight()+5);
		IEvent conditionEvent = new ConditionEvent(moveback,
				new YSmallerThenCondition(this,-10f));
		addUpdateable(new EventUpdatable(conditionEvent));
		//		new SimpleAccelerometerMovement(this); //just for fun :)
	}

}

