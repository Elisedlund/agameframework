package com.agameframework.Updatables;

import android.util.FloatMath;

import com.agameframework.object.Updatable;

public class MovementUpdatable extends Updatable {

	//public for performance 
	public float mXMotion = 0;
	public float mYMotion = 0;
	
    //TODO test if it works
	/**
	 * @return
	 */
	public float getMotionDirection()
	{
		if (mXMotion>=0) 
		{
			return (float) Math.atan(mYMotion/mXMotion);  
		}
		else
		{
			return (float)(Math.atan(mYMotion/mXMotion)+ Math.PI);
		}
	}

	public void setMotion(float speed,float rotation)
	{
		mXMotion = (speed*FloatMath.cos(rotation));
		mYMotion = (speed*FloatMath.sin(rotation));
	}

	@Override
	public void update()
	{
		mParent.incX(this.mXMotion);
		mParent.incY(this.mYMotion);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}	
}