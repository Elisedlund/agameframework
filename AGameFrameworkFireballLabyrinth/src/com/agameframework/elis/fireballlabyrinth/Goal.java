package com.agameframework.elis.fireballlabyrinth;

import com.agameframework.event.RemoveEvent;
import com.agameframework.object.GameNode;
import com.agameframework.object.Updatable;
import com.agameframework.updatables.FadeInOutUpdatable;
import com.agameframework.updatables.PulsatingSizeUpdatable;
import com.agameframework.updatables.RainbowUpdatable;

public class Goal extends GameNode{


	public Goal()
	{
		super(R.drawable.effect);
	}

	@Override 
	public void init()
	{
		Updatable upd = new PulsatingSizeUpdatable(0.5f, 1.0f);
		addUpdateable(upd);
		Updatable upd2 = new RainbowUpdatable(0f,1f);
		addUpdateable(upd2);

	}
	public void create()
	{
		GameNode effect = new GameNode(R.drawable.effect);
		effect.setScale(0.4f);
		effect.setRandomColor();
		float rx = (float)(Math.random() * 20) -10f;
		float ry = (float)(Math.random() * 20) -10f;
		effect.setXY(getX()+rx, getY()+ry);

		effect.addUpdateable(new FadeInOutUpdatable(
				new RemoveEvent(effect),
				-0.06f,-effect.mOpacity));
		add(effect);
	}

	@Override
	public void update() 
	{
		create();
		super.update();
	}




}
