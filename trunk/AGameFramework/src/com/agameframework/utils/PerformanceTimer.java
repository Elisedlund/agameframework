package com.agameframework.utils;

import com.agameframework.debug.Debug;

public class PreformanceTimer {

	private MilliTimer mTimer = new MilliTimer();
	private long[] mTimeArray;
	private int mLastIndex;
	private int mCurrentIndex;
	private String mTag;

	
	/** Creates a preformance timer. 
	 * @param tag string prefix when writen in the log
	 * @param bufferSize the size of the buffer.
	 */
	public PreformanceTimer(String tag,int bufferSize)
	{
		mTag = tag;
		mCurrentIndex = 0;
		mLastIndex = bufferSize-1;
		mTimeArray = new long[bufferSize];
	}

	
	/**Start the timer.
	 * 
	 */
	public void startTimer()
	{
		mTimer.startTimer();
	}

	
	/**Stops the timer and adds the time to a timebuffer. 
	 * if the timebuffer is full it prints the average time to the log.
	 */
	public void stopTimer()
	{
		mTimer.stopTimer();
		mTimeArray[mCurrentIndex] = mTimer.getTime();
		mCurrentIndex++;
		if(mCurrentIndex > mLastIndex)
		{
			mCurrentIndex = 0;
			printAverage();
		}
	}

	
	/** Calc and print the average time.
	 */
	private void printAverage()
	{
		int total = 0;
		for (int i = 0; i <= mLastIndex; i++) 
		{
			total += mTimeArray[i];
		}
		
		float average = total /(float)(mLastIndex+1);
		Debug.print(mTag + ": " + average + "ms , total: " + total);
	}
}
