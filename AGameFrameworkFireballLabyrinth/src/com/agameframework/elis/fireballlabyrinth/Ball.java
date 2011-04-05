package com.agameframework.elis.fireballlabyrinth;

import com.agameframework.components.Shadow;
import com.agameframework.event.RemoveEvent;
import com.agameframework.input.components.AccelerometerMovement;
import com.agameframework.object.GameNode;
import com.agameframework.object.Updatable;
import com.agameframework.updatables.FadeInOutGreenUpdatable;
import com.agameframework.updatables.FadeInOutRedUpdatable;
import com.agameframework.updatables.FadeInOutUpdatable;
import com.agameframework.updatables.MovementUpdatable;

public class Ball extends GameNode{

	public MovementUpdatable mMovement;
	private AccelerometerMovement mBallController;

	public Ball()  
	{
		super(R.drawable.ball);
	}
	
	@Override  
	public void init()
	{
		mMovement = new MovementUpdatable();
		addUpdateable(mMovement);
//		setScale(0.50f);
		mBallController = AccelerometerMovement.add(this,mMovement);
	
		Shadow shadow = new Shadow();
		shadow.mOpacity = 0.4f;
		shadow.setOffset(4,4);
		add(shadow);
	}
	
	public void create()
	{
		GameNode fire = new GameNode(R.drawable.effect2);
		fire.setColor(0.9f, 140/255f, 40f/255f);

		Updatable green = new FadeInOutGreenUpdatable(-0.04f, 0f, 100/255f, 1);
		//TODO make black.
		fire.addUpdateable(green);

		float rx =(float)(Math.random() * 8) -4f;
		float ry =(float)(Math.random() * 8) -4f;
		fire.setXY(getX()+rx, getY()+ry );
		fire.setScale((float)(Math.random()*0.8f)+0.4f);
		MovementUpdatable sm = new MovementUpdatable();
		fire.addUpdateable(sm); 
		
		fire.addUpdateable(new FadeInOutUpdatable(
						new RemoveEvent(fire),
						-0.05f,-fire.mOpacity));
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
