package com.agameframework.components;

import com.agameframework.debug.Debug;
import com.agameframework.event.AddUpdatableEvent;
import com.agameframework.event.CallMethodEvent;
import com.agameframework.event.CompositeEvent;
import com.agameframework.event.RemoveEvent;
import com.agameframework.event.VibrateEvent;
import com.agameframework.input.components.DoEventOnTouchMove;
import com.agameframework.interfaces.IEvent;
import com.agameframework.interfaces.IRemovable;
import com.agameframework.object.GameNode;
import com.agameframework.object.Updatable;
import com.agameframework.updatables.GrowShrinkToUpdatable;

public class GrowOnTouchEffect extends GameNode{
	
	@Override
	public void init()
	{

		if(mParent.getUpdatableList()!=null)
		Debug.print("count:" + mParent.getUpdatableList().size());
		
		float speed = 0.2f;

		IEvent restart = new CallMethodEvent(this, "init");
		
		Updatable growshrink = new GrowShrinkToUpdatable(restart, speed, 0f, 0.5f, 2);
		IEvent addGrowShrink = new AddUpdatableEvent(growshrink,mParent);
		
		CompositeEvent comp = new CompositeEvent();
		comp.add(addGrowShrink);
		comp.add(new VibrateEvent(25));
		IRemovable removeable = DoEventOnTouchMove.add(mParent,comp);
		comp.add(new RemoveEvent(removeable)); //so it only can be touched once.
		
	}

	//TODO remove.
}
