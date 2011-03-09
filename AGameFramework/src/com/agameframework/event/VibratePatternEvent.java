package com.agameframework.event;

import com.agameframework.Game;
import com.agameframework.interfaces.IEvent;

public class VibratePatternEvent implements IEvent{

	private long[] mPattern;
	private int mRepeat = -1;

	public VibratePatternEvent(long[] pattern)
	{
		mPattern = pattern;
	}
	
	public VibratePatternEvent(long[] pattern, int repeat)
	{
		mPattern = pattern;
		mRepeat  = repeat;
	}
	
	@Override
	public void invokeEvent() 
	{
		Game.instance.vibrate(mPattern,mRepeat);
	}
	
	public static void invoke(long[] pattern, int repeat) 
	{
		Game.instance.vibrate(pattern,repeat);
	}
	
	public static void invoke(long[] pattern) 
	{
		Game.instance.vibrate(pattern,-1);
	}
}
