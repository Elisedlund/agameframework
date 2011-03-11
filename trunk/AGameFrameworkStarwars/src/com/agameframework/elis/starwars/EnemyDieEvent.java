package com.agameframework.elis.starwars;

import com.agameframework.event.CompositeEvent;
import com.agameframework.event.RemoveEvent;
import com.agameframework.event.ScoreIncEvent;
import com.agameframework.event.SoundEvent;
import com.agameframework.event.VibrateEvent;
import com.agameframework.interfaces.IEvent;

public class EnemyDieEvent extends CompositeEvent implements IEvent{

	public EnemyDieEvent(Enemy enemy)
	{
		IEvent removeEnemy = new RemoveEvent(enemy);
		IEvent sound = new SoundEvent(R.raw.snd_explode);
		IEvent vibrate = new VibrateEvent(35);
		IEvent score = new ScoreIncEvent(10);
		add(removeEnemy); 
		add(vibrate);
		add(sound);
		add(score);
	}

}
