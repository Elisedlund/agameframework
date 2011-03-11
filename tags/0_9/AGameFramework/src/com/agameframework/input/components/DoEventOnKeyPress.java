package com.agameframework.input.components;

import android.view.KeyEvent;

import com.agameframework.Game;
import com.agameframework.input.GameInput;
import com.agameframework.input.KeyPressListener;
import com.agameframework.interfaces.IEvent;
import com.agameframework.interfaces.IRemovable;
import com.agameframework.object.GameNode;

public class DoEventOnKeyPress implements KeyPressListener ,IRemovable  {


	private IEvent mEvent;
	private int mKey;
	private boolean mSync;

	private DoEventOnKeyPress(int keyEvent,IEvent event, boolean sync)
	{
		mEvent = event;
		mKey = keyEvent;
		mSync = sync;
		GameInput.addKeyPressListner(this);
	}
	
	public static DoEventOnKeyPress add(GameNode gameNodeAddTo, int keyEvent, IEvent event, boolean sync )
	{
		DoEventOnKeyPress de = new DoEventOnKeyPress(keyEvent,event,sync);
		gameNodeAddTo.addRemovable(de);
		return de;
	}
	
	public static DoEventOnKeyPress add(GameNode gameNodeAddTo, int keyEvent, IEvent event)
	{
		return add(gameNodeAddTo,keyEvent,event,true);
	}
	
	@Override
	public boolean keyPress(int keyCode, KeyEvent msg) {
		if (keyCode == mKey)
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
		return true; //TODO false? 
	}
	
	@Override
	public void remove() {
		GameInput.addKeyPressListner(this);	
	}
}
