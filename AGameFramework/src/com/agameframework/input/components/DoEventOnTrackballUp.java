package com.agameframework.input.components;

import android.view.MotionEvent;

import com.agameframework.Game;
import com.agameframework.input.GameInput;
import com.agameframework.input.TrackballListener;
import com.agameframework.interfaces.IEvent;
import com.agameframework.interfaces.IRemovable;
import com.agameframework.object.GameNode;



/**
 *
 * @author Elis - Email: Elisedlund@gmail.com - Date: 11 mar 2011
 */
public class DoEventOnTrackballUp implements TrackballListener ,IRemovable {


	private IEvent mEvent;
	private boolean mSync;

	private DoEventOnTrackballUp(IEvent event, boolean sync)
	{
		mEvent = event;
		mSync = sync;
		GameInput.addTrackballListener(this);
	}

	public static DoEventOnTrackballUp add(GameNode addtogamenode,IEvent event, boolean sync)
	{
		DoEventOnTrackballUp de = new DoEventOnTrackballUp(event, sync);
		addtogamenode.addRemovable(de);
		return de;
	}

	public static DoEventOnTrackballUp add(GameNode addtogamenode, IEvent event)
	{
		return add(addtogamenode, event, true);
	}


	@Override
	public void trackball(MotionEvent event) {
		if(event.getAction() == MotionEvent.ACTION_UP)
		{
			if(mSync)
			{
				Game.addSyncEvent(mEvent); // do event just before next update cycle
			}
			else
			{
				mEvent.invokeEvent();
			}
		}
	}


	@Override
	public void remove() {
		GameInput.removeTrackballListener(this);
	}
	
}