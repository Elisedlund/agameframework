package com.agameframework.input.components;

import android.view.MotionEvent;

import com.agameframework.Game;
import com.agameframework.input.GameInput;
import com.agameframework.input.TouchDownListener;
import com.agameframework.interfaces.IEvent;
import com.agameframework.interfaces.IRemovable;
import com.agameframework.object.GameNode;



/**
 *
 * @author Elis - Email: Elisedlund@gmail.com - Date: 11 mar 2011
 */
public class DoEventOnAnywhereTouchDown implements TouchDownListener ,IRemovable {


	private IEvent mEvent;
	private boolean mSync;

	private DoEventOnAnywhereTouchDown(IEvent event, boolean sync)
	{
		mEvent = event;
		mSync = sync;
		GameInput.addTouchDownListner(this);
	}

	public static DoEventOnAnywhereTouchDown add(GameNode addtogamenode,IEvent event, boolean sync)
	{
		DoEventOnAnywhereTouchDown de = new DoEventOnAnywhereTouchDown(event, sync);
		addtogamenode.addRemovable(de);
		return de;
	}

	public static DoEventOnAnywhereTouchDown add(GameNode addtogamenode, IEvent event)
	{
		return add(addtogamenode, event, true);
	}

	@Override
	public void touchDown(MotionEvent event) {
		if(mSync)
		{
			Game.addSyncEvent(mEvent); // do event just before next update cycle
		}
		else
		{
			mEvent.invokeEvent();
		}
	}

	@Override
	public void remove() {
		GameInput.removeTouchDownListner(this);
	}
}
