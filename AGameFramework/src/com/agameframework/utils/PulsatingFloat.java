package com.agameframework.utils;

import com.agameframework.interfaces.IUpdatable;

public class PulsatingFloat implements IUpdatable{

	private Float mCurrentValue;
	private float mSpeed;
	private float mMin = 0f;
	private float mMax = 1f;
	private boolean mDone = false;
	private int mGoalPulseCount = -1;
	private int mCurrentPulseCount = 0;


	public PulsatingFloat(Float pulsingValue, float speed, float min, float max, int nrOfTimes)
	{
		this.mCurrentValue = pulsingValue;
		this.mSpeed = speed;
		this.mMin = min;
		this.mMax = max;
		this.mGoalPulseCount = nrOfTimes;
	}

	public PulsatingFloat(Float pulsingValue, float speed, float min, float max)
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
		mCurrentValue += mSpeed;

		if (mCurrentValue <= mMin)
		{
			mSpeed *= -1;
			mCurrentPulseCount++;
			if(mCurrentPulseCount == mGoalPulseCount) //if done
			{
				mDone = true;
			}
			if (mCurrentValue < mMin)
			{
				//TODO diff.
				mCurrentValue = mMin;
			}
		}
		if (mCurrentValue >= mMax)
		{
			mSpeed *= -1;
			mCurrentPulseCount++;
			if(mCurrentPulseCount == mGoalPulseCount) //if done
			{
				mDone = true;
			}
			if (mCurrentValue > mMax)
			{
				//TODO diff.
				mCurrentValue = mMax;
			}
		}
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

	public Float getCurrentValue() {
		return mCurrentValue;
	}

	public void setCurrentValue(Float currentValue) {
		this.mCurrentValue = currentValue;
	}

	public float getDiff()
	{
		return mSpeed;
	}
	
	public boolean isDone()
	{
		return mDone;
	}
}
