package com.agameframework.elis.paperpong;

import com.agameframework.event.RandomEvent;
import com.agameframework.event.SoundAndVibrateEvent;
import com.agameframework.object.CollisionHelper;
import com.agameframework.object.Updatable;


//TODO MUCH WORK LEFT, FIXXX
/**
 * @author Elis
 *
 */
public class PaddleBallCollision extends Updatable {
 
	private Ball mBall;
	private Paddle mPaddle;
	private RandomEvent sound = new RandomEvent();

	private final int VIBRATE_LENGHT = 35;
	
	private boolean[] mCollisionArray = new boolean[4];

	public PaddleBallCollision(Ball ball, Paddle paddle)
	{
	
		mBall = ball;
		mPaddle = paddle; 
		sound.add(new SoundAndVibrateEvent(R.raw.ball_on_paddle01,VIBRATE_LENGHT));
		sound.add(new SoundAndVibrateEvent(R.raw.ball_on_paddle02,VIBRATE_LENGHT));
		sound.add(new SoundAndVibrateEvent(R.raw.ball_on_paddle03,VIBRATE_LENGHT));
		sound.add(new SoundAndVibrateEvent(R.raw.ball_on_paddle04,VIBRATE_LENGHT));
	}

	@Override
	public void update()
	{
		if(mPaddle.isCollision(mBall))
		{
			mCollisionArray[0]=false;
			mCollisionArray[1]=false;
			mCollisionArray[2]=false;
			mCollisionArray[3]=false;

			CollisionHelper.removeSmallestOverlap(mBall.mMovement, mPaddle, mCollisionArray);

			if(mCollisionArray[CollisionHelper.NORTH])
			{
				mBall.mMovement.mYMotion = -Math.abs(mBall.mMovement.mYMotion);
				PaddleBounce();
			}
			if(mCollisionArray[CollisionHelper.SOUTH])
			{

				mBall.mMovement.mYMotion = Math.abs(mBall.mMovement.mYMotion);
				PaddleBounce();
			}
			if(mCollisionArray[CollisionHelper.EAST])
			{

				mBall.mMovement.mXMotion = Math.abs(mBall.mMovement.mXMotion);
			}
			if(mCollisionArray[CollisionHelper.WEST])
			{

				mBall.mMovement.mXMotion = -Math.abs(mBall.mMovement.mXMotion);
			}
		}//end of collision
	}//end of update

	private void PaddleBounce()
	{
		float newXMotion = (mBall.getX()-mPaddle.getX())/5;

		//old motion matters.
		mBall.mMovement.mXMotion = newXMotion + mBall.mMovement.mXMotion/2;	
		sound.invokeEvent();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
}
