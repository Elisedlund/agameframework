package com.agameframework.utils;

public final class MilliTimer {

	private long mStartTime;
	private long mStopTime;
	private long mTime;

	public void startTimer()
	{
		mStartTime = System.currentTimeMillis();
	}

	public void stopTimer()
	{
		mStopTime = System.currentTimeMillis();
		mTime = mStopTime - mStartTime;	
	}

	public long getTimeSinceTimerStart()
	{
		return System.currentTimeMillis() - mStartTime;
	}

	public long getTimeSinceTimerStop()
	{
		return System.currentTimeMillis() - mStopTime;
	}

	public long getTime()
	{
		return mTime;
	}

	public void reset()
	{
		mStopTime=0;
		mStartTime=0;
		mTime=0;
	}
}