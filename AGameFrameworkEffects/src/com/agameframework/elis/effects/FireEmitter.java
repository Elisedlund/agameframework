package com.agameframework.elis.effects;

import com.agameframework.event.RemoveEvent;
import com.agameframework.input.components.AccelerometerMovement;
import com.agameframework.object.GameNode;
import com.agameframework.updatables.FadeInOutUpdatable;
import com.agameframework.updatables.MovementUpdatable;

public class FireEmitter extends GameNode{

	public FireEmitter()
	{}

	public void create()
	{
		GameNode fire = new GameNode(R.drawable.effect);
		fire.setColor(1f, 0.3f, 0.3f);
		float rx =(float)(Math.random() * 8) -4f;
		float ry =(float)(Math.random() * 8) -4f;
		fire.setXY(getX()+rx, getY()+ry );
		fire.setScale((float)(Math.random()*1.5f)+0.8f);
		fire.mOpacity=1f;
//		sm.mXMotion = (float)(Math.random() * 0.2f) -0.1f;
//		sm.mYMotion = (float)(Math.random() * 3f)+ 0.5f -Math.abs(sm.mXMotion);
		
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
