package com.agameframework.input.components;

import android.view.MotionEvent;

import com.agameframework.Game;
import com.agameframework.input.GameInput;
import com.agameframework.input.TouchMoveListener;
import com.agameframework.interfaces.IEvent;
import com.agameframework.interfaces.IRemovable;
import com.agameframework.object.GameNode;
import com.agameframework.object.Rectangle;



/**
 *
 * @author Elis - Email: Elisedlund@gmail.com - Date: 10 feb 2011
 */
public class DoEventOnTouchMove implements TouchMoveListener , IRemovable{


	private IEvent mEvent;
	private Rectangle mRect;
	private boolean mSync;

	private DoEventOnTouchMove(Rectangle hotspot,IEvent event, boolean sync)
	{
		mEvent = event;
		mRect = hotspot;
		mSync = sync;
		GameInput.addTouchMoveListner(this);
	}
	
	public static DoEventOnTouchMove add(GameNode gamenodehotspot,IEvent event, boolean sync)
	{
		DoEventOnTouchMove de = new DoEventOnTouchMove(gamenodehotspot, event, sync);
		gamenodehotspot.addRemovable(de);
		return de;
	}
	
	public static DoEventOnTouchMove add(GameNode gamenodehotspot, IEvent event)
	{
		return add(gamenodehotspot, event, true);
	}

	@Override
	public void touchMove(MotionEvent event) {
		
		//"Math.abs(event.getY() - Game.getHeight()" inverts the yaxis to match the opengl.
		if (mRect.isInside(event.getX(),Math.abs(event.getY() - Game.getHeight())))
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
		GameInput.removeTouchMoveListner(this);		
	}
}
