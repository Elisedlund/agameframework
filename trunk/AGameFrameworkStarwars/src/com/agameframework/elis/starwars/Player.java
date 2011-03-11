package com.agameframework.elis.starwars;

import android.view.KeyEvent;

import com.agameframework.Game;
import com.agameframework.event.StopXMotionEvent;
import com.agameframework.event.StopYMotionEvent;
import com.agameframework.input.components.DoEventOnAnywhereTouchDown;
import com.agameframework.input.components.DoEventOnKeyPress;
import com.agameframework.input.components.DoEventOnTrackballDown;
import com.agameframework.input.components.TrackballMovement;
import com.agameframework.interfaces.IEvent;
import com.agameframework.object.GameNode;
import com.agameframework.updatables.MovementUpdatable;
import com.agameframework.updatables.StayOnScreenUpdatable;

public class Player extends GameNode {
	
	

	public Player()
	{
		setXY(Game.getCenterX(),Game.getCenterY()/2);
		
		MovementUpdatable playermovement = new MovementUpdatable();
		addUpdateable(playermovement);

		setTexture(new PlayerAnimation(playermovement));
		
		TrackballMovement.add(this,playermovement); 

		IEvent shootEvent = new ShootEvent(this);
		DoEventOnKeyPress.add(this,KeyEvent.KEYCODE_DPAD_CENTER, shootEvent);
		DoEventOnTrackballDown.add(this,shootEvent);
		DoEventOnAnywhereTouchDown.add(this,shootEvent);
		
		addUpdateable(new StayOnScreenUpdatable(
				new StopXMotionEvent(playermovement),
				new StopYMotionEvent(playermovement)));	
	}

}
