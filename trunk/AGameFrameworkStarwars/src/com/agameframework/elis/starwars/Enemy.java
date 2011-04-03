package com.agameframework.elis.starwars;

import com.agameframework.Game;
import com.agameframework.conditions.YSmallerThenCondition;
import com.agameframework.event.CompositeEvent;
import com.agameframework.event.ConditionEvent;
import com.agameframework.event.HealthIncEvent;
import com.agameframework.event.SetPositionEvent;
import com.agameframework.interfaces.IEvent;
import com.agameframework.object.GameNode;
import com.agameframework.updatables.CollisionUpdatable;
import com.agameframework.updatables.EventUpdatable;
import com.agameframework.updatables.MovementUpdatable;

public class Enemy extends GameNode{

	private static int[] resList = {
		R.drawable.spr_enemy1,R.drawable.spr_enemy2,R.drawable.spr_enemy3,
		R.drawable.spr_enemy4,R.drawable.spr_enemy5,
		R.drawable.spr_enemy6,R.drawable.spr_enemy7};

	public Enemy()
	{
		int rand = (int)(Math.random()*resList.length);
		setTexture(resList[rand]);
		setXY(Game.getRandomX(),Game.getHeight()+30);

		//gravity updatable.
		MovementUpdatable sm = new MovementUpdatable();
		sm.mYMotion = (float) -Math.random();
		addUpdateable(sm);

		IEvent moveback = new SetPositionEvent(this, getX(), Game.getHeight()+30);
		IEvent conditionEvent = new ConditionEvent(moveback  , new YSmallerThenCondition(this,-50f));
		addUpdateable(new EventUpdatable(conditionEvent));
		
		CompositeEvent collisionEvent = new CompositeEvent(new EnemyDieEvent(this), new HealthIncEvent(-5));
		addUpdateable(new CollisionUpdatable(this, GameRoot.mPlayer, collisionEvent));
	}

}

