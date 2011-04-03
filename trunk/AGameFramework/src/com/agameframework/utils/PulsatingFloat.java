package com.agameframework.utils;

import com.agameframework.interfaces.IUpdatable;

public class PulsatingFloat implements IUpdatable{

	private final float mTolerance = 0.001f;
	
	private float mCurrentValue;
	private float mSpeed;
	private float mDiff;
	private float mMin = 0f;
	private float mMax = 1f;
	private boolean mDone = false;
	private int mGoalPulseCount = -1;
	private int mCurrentPulseCount = 0;


	public PulsatingFloat(float pulsingValue, float speed, float min, float max, int nrOfTimes)
	{
		this.mCurrentValue = pulsingValue;
		this.mSpeed = speed;
		this.mDiff = speed;
		this.mMin = min;
		this.mMax = max;
		this.mGoalPulseCount = nrOfTimes;
	}

	public PulsatingFloat(float pulsingValue, float speed, float min, float max)
	{
		this(pulsingValue, speed, min, max,-1);
	}
	
	public PulsatingFloat(float speed, float min, float max,int nrOfTimes)
	{
		this(min, speed, min, max, nrOfTimes);
	}
	
	public PulsatingFloat(float speed, float min, float max)
	{
		this(min, speed, min, max, -1);
	}

	public void update()
	{
		float newValue = mCurrentValue + mSpeed;
		mDiff = mSpeed;
		if (newValue <= mMin + mTolerance)
		{
			mSpeed *= -1;
			mCurrentPulseCount++;
			if(mCurrentPulseCount == mGoalPulseCount) //if done
			{
				mDone = true;
			}
			if (newValue < mMin)
			{
				mDiff =  mMin - mCurrentValue;
				mCurrentValue = mMin;
			}
			return;
		}
		if (newValue >= mMax - mTolerance)
		{
			mSpeed *= -1;
			mCurrentPulseCount++;
			if(mCurrentPulseCount == mGoalPulseCount) //if done
			{
				mDone = true;
			}
			if (newValue > mMax)
			{				
				mDiff =  mMax - mCurrentValue;
				mCurrentValue = mMax;
			}
			return;			
		}
		mCurrentValue = newValue;
	}

	public float getSpeed() {
		return mSpeed;
	}

	public void setSpeed(float speed) {
		this.mSpeed = speed;
	}

	public float getMax() {
		return mMax;
	}

	public void setMax(float max) {
		this.mMax = max;
	}

	public float getMin() {
		return mMin;
	}

	public void setMin(float min) {
		this.mMin = min;
	}

	public float getCurrentValue() {
		return mCurrentValue;
	}

	public void setCurrentValue(float currentValue) {
		this.mCurrentValue = currentValue;
	}

	public float getDiff()
	{
		return mDiff;
	}
	
	public boolean isDone()
	{
		return mDone;
	}
}
