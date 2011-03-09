package com.agameframework.elis.paperpong;

import android.view.KeyEvent;
import android.view.MotionEvent;

import com.agameframework.Game;
import com.agameframework.input.GameInput;
import com.agameframework.input.KeyPressListener;
import com.agameframework.input.TrackballListener;
import com.agameframework.input.components.SimpleAccelerometerMovement;
import com.agameframework.interfaces.IRemovable;

public class PaddlePlayerMovement implements KeyPressListener,TrackballListener,IRemovable{

	private Paddle mPaddle;

	private PaddlePlayerMovement(Paddle p)
	{
		mPaddle = p;
		GameInput.addKeyPressListner(this);
		GameInput.addTrackballListener(this);
	}

	public static PaddlePlayerMovement add(Paddle gameNodeAddTo)
	{
		PaddlePlayerMovement sam = new PaddlePlayerMovement(gameNodeAddTo);
		gameNodeAddTo.addRemovable(sam);
		return sam;
	}

	public void setPaddle(Paddle p)
	{
		mPaddle = p;  
	}


	/* (non-Javadoc)
	 * @see com.elis.agameengine.input.TrackballListener#trackballMoved(android.view.MotionEvent)
	 * if there is no trackball the keypress will be invoked instead
	 */
	@Override
	public void trackballMoved(MotionEvent event) {
		int speed = 60;
		mPaddle.mGoalX += event.getX()*speed;
		if(mPaddle.mGoalX < mPaddle.getWidth()*0.5f)
		{
			//			int a = 1/0;
			mPaddle.mGoalX = 0 + mPaddle.getWidth()*0.5f;
		}
		if(mPaddle.mGoalX > Game.getWidth() - mPaddle.getWidth()*0.5f)
		{
			mPaddle.mGoalX = Game.getWidth() - mPaddle.getWidth()*0.5f; 
		}
	}

	@Override
	public boolean keyPress(int keyCode, KeyEvent msg)
	{

		int speed = 40;
		if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT
				|| keyCode == KeyEvent.KEYCODE_Q)
		{

			mPaddle.mGoalX -= speed;
			if(mPaddle.mGoalX < 0)
			{
				mPaddle.mGoalX = 0;
			}
			return true;
		}
		else if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT
				|| keyCode == KeyEvent.KEYCODE_W)
		{
			mPaddle.mGoalX += speed;
			if(mPaddle.mGoalX > Game.getWidth() - mPaddle.getWidth())
			{
				mPaddle.mGoalX = Game.getWidth() - mPaddle.getWidth(); 
			}
			return true;
		}
		return false;
	}

	@Override
	public void remove() {
		GameInput.removeKeyPressListner(this);
		GameInput.removeTrackballListener(this);
	}



}
