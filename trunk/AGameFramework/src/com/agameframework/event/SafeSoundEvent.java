package com.agameframework.event;

import com.agameframework.interfaces.IEvent;
import com.agameframework.sound.SoundEffectPlayer;

public class SafeSoundEvent implements IEvent{

	private int mResourceID;
	private float mVolume = 1f;

	public SafeSoundEvent(int resourceID)
	{
		mResourceID = resourceID;
	}
	
	public void setVolume(float volume)
	{
		mVolume = volume;
	}

	@Override
	public void invokeEvent() 
	{
		SoundEffectPlayer.play(mResourceID, mVolume);
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
