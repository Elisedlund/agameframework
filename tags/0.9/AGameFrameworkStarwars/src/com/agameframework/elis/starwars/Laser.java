package com.agameframework.elis.starwars;

import com.agameframework.conditions.OutsideScreenCondition;
import com.agameframework.event.ConditionEvent;
import com.agameframework.event.RemoveEvent;
import com.agameframework.event.SoundEvent;
import com.agameframework.interfaces.IEvent;
import com.agameframework.object.GameNode;
import com.agameframework.object.Rectangle;
import com.agameframework.updatables.EventUpdatable;
import com.agameframework.updatables.MovementUpdatable;

public class Laser extends GameNode {

	public static SoundEvent laserSound = new SoundEvent(R.raw.snd_laser);

	public Laser(Rectangle rect)
	{
		setTexture(R.drawable.spr_laser);
		setXY(rect.getX(),rect.getY());
		MovementUpdatable om = new MovementUpdatable();
		om.mYMotion = 4f;
		addUpdateable(om);
		IEvent conditionEvent = new ConditionEvent(new RemoveEvent(this) , new OutsideScreenCondition(this));
		addUpdateable(new EventUpdatable(conditionEvent));
		laserSound.invokeEvent();

	}
}
