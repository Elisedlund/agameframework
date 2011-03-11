package com.agameframework.elis.starwars;

import com.agameframework.event.CompositeEvent;
import com.agameframework.event.RemoveEvent;
import com.agameframework.interfaces.IEvent;
import com.agameframework.interfaces.IUpdatable;
import com.agameframework.object.Updatable;

public class EnemyLaserCollision extends Updatable{

	@Override
	public void update() {

		if(GameRoot.mEnemyList.getUpdatableList() == null || GameRoot.mLaserList.getUpdatableList() == null)
		{return;}
		
		for (IUpdatable en : GameRoot.mEnemyList.getUpdatableList()) {
			Enemy enemy = (Enemy) en;
			for (IUpdatable la : GameRoot.mLaserList.getUpdatableList()) {
				Laser laser = (Laser) la;
				if(laser.isCollision(enemy))
				{
					IEvent removeLaser = new RemoveEvent(laser);
					CompositeEvent tot = new CompositeEvent();
					tot.add(removeLaser);
					tot.add(new EnemyDieEvent(enemy));
					tot.invokeEvent();
				}
			}
		}
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
