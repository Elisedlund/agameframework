package com.agameframework.elis.paperpong;

import com.agameframework.Game;
import com.agameframework.components.MotionBlur;
import com.agameframework.components.Shadow;
import com.agameframework.object.GameNode;

public class Paddle extends GameNode{

	protected float mGoalX;
	protected float mGoalY;
	protected int mSpeed = 7;

	public Paddle(int x, int y)
	{
		super(R.drawable.paddle);
		setScale(0.7f);
		setXY(x,y);
		mGoalX = x; 
		mGoalY = y; 
		add(new MotionBlur(-0.8f, 0.04f));

	}


	public void update()
	{
		super.update();

		if(mGoalX > mCenterX)
		{
			setX(mCenterX  + (((mGoalX-mCenterX)*2)/mSpeed));
		}
		if(mGoalX < mCenterX)
		{
			setX(mCenterX  - (((mCenterX-mGoalX)*2)/mSpeed));
		}

		if(getX()<0)
		{
			setX(0);
		}
		if(mCenterX > (Game.getWidth() - mWidth*0.5f ))
		{
			setX(Game.getWidth() - mWidth*0.5f);
		}
	}

}