package com.agameframework.elis.fireballlabyrinth;

import com.agameframework.debug.Debug;
import com.agameframework.event.SoundEvent;
import com.agameframework.event.VibrateEvent;
import com.agameframework.object.CollisionHelper;
import com.agameframework.object.Rectangle;
import com.agameframework.object.Updatable;

public class BallWallCollision extends Updatable {

	private Ball mBall;
	private Rectangle mWall;

	private final static float VIBRATE_FACTOR = 4.0f;
	private final static float BOUNCE_FACTOR = 0.50f;
	private final static float MINIMAL_BOUNCE = 1.00f;
	private final static int SMALLEST_VIBRATE = 6;
	private boolean mShouldBounceX = true;
	private boolean mShouldBounceY = true;

	private SoundEvent  mSound = new SoundEvent(R.raw.woodcollision);
//	private VibrateEvent mVibrate = new VibrateEvent(30);


	boolean[] mCollisionAt = new boolean[4];

	public BallWallCollision(Ball ball)
	{
		mBall = ball;
	}

	public BallWallCollision(Ball ball, Rectangle wall) {
		mBall = ball;
		mWall = wall;
	}

	@Override
	public void update()
	{
		if(mBall.isCollision(mWall))//rectangle collision.
		{
			float absMX =  Math.abs(mBall.mMovement.mXMotion);
			float absMY =  Math.abs(mBall.mMovement.mYMotion);

			mCollisionAt[0]=false;
			mCollisionAt[1]=false;
			mCollisionAt[2]=false;
			mCollisionAt[3]=false;
			CollisionHelper.removeSmallestOverlap(mBall.mMovement, mWall,mCollisionAt);
			
			if(mCollisionAt[CollisionHelper.NORTH])
			{
				vibrate(absMY);
				bounceY(-absMY);
			}
			if(mCollisionAt[CollisionHelper.SOUTH])
			{
				vibrate(absMY);
				bounceY(absMY);
			}
			if(mCollisionAt[CollisionHelper.WEST])
			{
				vibrate(absMX);
				bounceX(-absMX);			
			}
			if(mCollisionAt[CollisionHelper.EAST])
			{
				vibrate(absMX);
				bounceX(absMX);
			}
		}
		stillcolliding();
	}

	private void stillcolliding()
	{
		if(mBall.isCollision(mWall))
		{
			Debug.print("Still colliding update again");
			Debug.print("bX: " + mBall.getX() +" bY: "+ mBall.getY() + "bX2: " + (mBall.getX()+mBall.getWidth()) +" bY2: " + (mBall.getY() + mBall.getHeight()));
			Debug.print("wX: " + mWall.getX() +" wY: "+ mWall.getY() + "wX2: " + (mWall.getX()+mWall.getWidth()) +" wY2: " + (mWall.getY() + mWall.getHeight()));
		}	
	}

	private void bounceX(float abs)
	{
		if(Math.abs(abs) > MINIMAL_BOUNCE)
		{
			mShouldBounceX=true;
		}
		if (Math.abs(abs*BOUNCE_FACTOR) > MINIMAL_BOUNCE && mShouldBounceX)
		{
			mBall.mMovement.mXMotion = abs*BOUNCE_FACTOR;
		}
		else 
		{
			mBall.mMovement.mXMotion = 0;
			mShouldBounceX = false;
		}
	}

	private void bounceY(float abs)
	{
		if(Math.abs(abs) > MINIMAL_BOUNCE)
		{
			mShouldBounceY = true;
		}
		if (Math.abs(abs*BOUNCE_FACTOR) > MINIMAL_BOUNCE && mShouldBounceY)
		{
			mBall.mMovement.mYMotion = abs*BOUNCE_FACTOR;
		}
		else
		{
			mBall.mMovement.mYMotion = 0;
			mShouldBounceY= false;
		}
	}

	private void vibrate(float abs)
	{
		if((abs*VIBRATE_FACTOR) > SMALLEST_VIBRATE)
		{
			mSound.setVolume(abs/32);
			mSound.invokeEvent();
			VibrateEvent.invoke((int)(abs*VIBRATE_FACTOR));
		}
	}

	@Override
	public void init() {

	}
}
