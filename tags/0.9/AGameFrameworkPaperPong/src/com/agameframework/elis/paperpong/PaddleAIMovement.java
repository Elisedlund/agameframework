package com.agameframework.elis.paperpong;

import com.agameframework.Game;
import com.agameframework.object.Updatable;

public class PaddleAIMovement extends Updatable{

	private Paddle mPaddle;
	private Ball mBall;
	
	private boolean haveSetRandom = false;
	private int thinking = 0; 
	private int precisionRightNow = 0;

	
    //AI difficulty
	private int thinkDoneDelay = 55;
	private int precision = 35; //+-
	public float mDir = 1;
	
	public PaddleAIMovement(Paddle p, Ball b)
	{
		mPaddle = p;
		mBall = b;
	}
	public void setPaddle(Paddle p)
	{
		mPaddle = p;
	}
	public void update()
	{
		if(mDir *mBall.mMovement.mYMotion>0)
		{
			if (!haveSetRandom)
			{
				haveSetRandom=true;
				precisionRightNow = (int)(Math.random()*(precision*2)) - precision;
			}
			mPaddle.mGoalX = mBall.getX() - mPaddle.getWidth()/2 + precisionRightNow; 
		}
		
		thinking++;
		if( thinking > thinkDoneDelay )
		{
			thinking = 0; 
			haveSetRandom=false;
		}
		
		//dont move offscreen
		if(mPaddle.mGoalX > Game.getWidth() - mPaddle.getWidth()*0.5f)
		{
			mPaddle.mGoalX = Game.getWidth() - mPaddle.getWidth()*0.5f; 
		}
		if(mPaddle.mGoalX < mPaddle.getWidth()*0.5f)
		{
			mPaddle.mGoalX = mPaddle.getWidth()*0.5f;
		}
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
}