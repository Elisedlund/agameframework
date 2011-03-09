package com.agameframework.input.components;

import android.view.MotionEvent;

import com.agameframework.Game;
import com.agameframework.input.GameInput;
import com.agameframework.input.TouchUpListener;
import com.agameframework.interfaces.IEvent;
import com.agameframework.interfaces.IRemovable;
import com.agameframework.object.GameNode;
import com.agameframework.object.Rectangle;



/**
 *
 * @author Elis - Email: Elisedlund@gmail.com - Date: 10 feb 2011
 */
public class DoEventOnTouchUp implements TouchUpListener , IRemovable{


	private IEvent mEvent;
	private Rectangle mRect;
	private boolean mSync;

	private DoEventOnTouchUp(Rectangle hotspot,IEvent event, boolean sync)
	{
		mEvent = event;
		mRect = hotspot;
		mSync = sync;
		GameInput.addTouchUpListner(this);
	}
	
	public static DoEventOnTouchUp add(GameNode gamenodehotspot,IEvent event, boolean sync)
	{
		DoEventOnTouchUp de = new DoEventOnTouchUp(gamenodehotspot, event, sync);
		gamenodehotspot.addRemovable(de);
		return de;
	}
	
	public static DoEventOnTouchUp add(GameNode gamenodehotspot, IEvent event)
	{
		return add(gamenodehotspot, event, true);
	}


	@Override
	public void touchUp(MotionEvent event) {
		
		//"Math.abs(event.getY() - Game.getHeight()" inverts the yaxis to match the opengl.
		if (mRect.isInside(event.getX(),Math.abs(event.getY()-Game.getHeight())))
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
		GameInput.removeTouchUpListner(this);
	}
}
