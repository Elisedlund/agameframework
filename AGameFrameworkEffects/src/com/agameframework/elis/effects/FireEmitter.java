package com.agameframework.elis.effects;

import com.agameframework.event.RemoveEvent;
import com.agameframework.input.components.AccelerometerMovement;
import com.agameframework.object.GameNode;
import com.agameframework.object.Updatable;
import com.agameframework.updatables.FadeInOutGreenUpdatable;
import com.agameframework.updatables.FadeInOutUpdatable;
import com.agameframework.updatables.MovementUpdatable;

public class FireEmitter extends GameNode{

	public FireEmitter()
	{}

	public void create()
	{
		GameNode fire = new GameNode(R.drawable.effect);

		fire.setColor(0.9f, 140/255f, 40f/255f);
		Updatable green = new FadeInOutGreenUpdatable(-0.03f, 0f, 100/255f, 1);
		fire.addUpdateable(green);
		float rx =(float)(Math.random() * 8) -4f;
		float ry =(float)(Math.random() * 8) -4f;
		fire.setXY(getX()+rx, getY()+ry );
		fire.setScale((float)(Math.random()*1.5f)+0.8f);
	
		MovementUpdatable sm = new MovementUpdatable();
		fire.addUpdateable(sm); 
		
		fire.addUpdateable(new FadeInOutUpdatable(
						new RemoveEvent(fire),
						-0.03f,-fire.mOpacity));
		AccelerometerMovement am = AccelerometerMovement.add(fire, sm);
		am.invertX();
		am.invertY();
		am.setImpact(0.03f);
		add(fire);
	}
	
	@Override
	public void update()
	{
		create();
		create();
		create();
		super.update();
	}
}
