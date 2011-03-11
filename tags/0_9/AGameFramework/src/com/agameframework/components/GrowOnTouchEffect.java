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
//		float scale = mParent.getScaleX();
		float speed = 0.2f;
		
//		Debug.print("scale: " + scale );
//		IEvent restart = new NullEvent();
		IEvent restart = new CallMethodEvent(this, "init");
		
		Updatable shrink = new GrowShrinkToUpdatable(restart,-speed,-0.5f); //shrink
		IEvent addShrink = new AddUpdatableEvent(shrink,mParent);
		
		Updatable grow = new GrowShrinkToUpdatable(addShrink,speed, 0.5f); //grow
		IEvent addGrow = new AddUpdatableEvent(grow,mParent);
		
		CompositeEvent comp = new CompositeEvent();
		comp.add(addGrow);
		comp.add(new VibrateEvent(25));
		IRemovable removeable = DoEventOnTouchMove.add(mParent,comp);
		comp.add(new RemoveEvent(removeable)); //so it only can be touched once.
		
	}

	//TODO remove.
}
