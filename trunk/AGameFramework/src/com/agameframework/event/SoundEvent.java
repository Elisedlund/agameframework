package com.agameframework.event;

import com.agameframework.interfaces.IEvent;
import com.agameframework.sound.SoundEffectPlayer;

public class SoundEvent implements IEvent{

	private int mSoundID;

	public SoundEvent(int soundID)
	{
		mSoundID = soundID;
	}

	@Override
	public void invokeEvent() 
	{
		SoundEffectPlayer.play(mSoundID);
	}
	
	public static void invoke(int soundID)
	{
		SoundEffectPlayer.play(soundID);
	}

}
