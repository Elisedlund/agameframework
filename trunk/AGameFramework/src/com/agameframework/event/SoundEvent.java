package com.agameframework.event;

import com.agameframework.interfaces.IEvent;
import com.agameframework.sound.SoundEffectPlayer;

public class SoundEvent implements IEvent{

	private int mSoundID;
	private float mVolume = 1f;

	public SoundEvent(int soundID)
	{
		mSoundID = soundID;
	}
	
	public void setVolume(float volume)
	{
		mVolume = volume;
	}

	@Override
	public void invokeEvent() 
	{
		SoundEffectPlayer.play(mSoundID, mVolume);
	}
	
	public static void invoke(int soundID)
	{
		SoundEffectPlayer.play(soundID);
	}
	
	public static void invoke(int soundID, float volume)
	{
		SoundEffectPlayer.play(soundID, volume);
	}

}
