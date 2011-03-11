package com.agameframework.tofixorgarbage;

public final class NanoTimer {

	private long startTime;
	private long stopTime;
	private long time;
	
	protected void startTimer()
	{
		startTime = System.nanoTime();
	}
	
	protected void stopTimer()
	{
		stopTime = System.nanoTime();
		time = stopTime - startTime;	
	}
	
	protected long getStopTime()
	{
		return stopTime;
	}
	
	protected long getStartTime()
	{
		return startTime;
	}
	
	protected long getTimeSinceTimerStop()
	{
		return System.nanoTime() - stopTime;
	}
	
	protected long getTime()
	{
		return time;
	}
	
}