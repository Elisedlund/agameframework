package com.agameframework.utils;

import com.agameframework.interfaces.IUpdatable;

public class PulsatingFloat implements IUpdatable{

	private Float mCurrentValue;
	private float mDirection;
	private float mSpeed;
	private float mMin;
	private float mMax;

	public PulsatingFloat(Float pulsingValue, float direction, float speed, float min, float max)
	{
		this.mCurrentValue = pulsingValue;
		this.mDirection = direction;
		this.mSpeed = speed;
		this.mMin = min;
		this.mMax = max;
	}
	
	public PulsatingFloat(float direction, float speed, float min, float max)
	{
		this.mCurrentValue = new Float(0.5f);
		this.mDirection = direction;
		this.mSpeed = speed;
		this.mMin = min;
		this.mMax = max;
	}
	
	public void update()
	{
		if (mCurrentValue <= mMin)
		{
			mDirection = 1;
		}
		if (mCurrentValue >= mMax)
		{
			mDirection = -1;
		}

		 mCurrentValue += mDirection * mSpeed;

		if (mCurrentValue > mMax)
		{
			mCurrentValue = mMax;
		}
		else if (mCurrentValue < mMin)
		{
			mCurrentValue = mMin;
		}
	}
	
	public float getDirection() {
		return mDirection;
	}

	public void setDirection(float direction) {
		this.mDirection = direction;
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
}
