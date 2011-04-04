package com.agameframework.event;

import com.agameframework.interfaces.IEvent;
import com.agameframework.sound.SoundEffectPlayer;

public class SoundEvent implements IEvent{

	private int mSoundID;
	private float mVolume = 1f;

	public SoundEvent(int resourceID)
	{
		//TODO do a load? to make this one safe to?
		mSoundID = SoundEffectPlayer.getSoundID(resourceID);
	}
	
	public void setVolume(float volume)
	{
		mVolume = volume;
	}

	@Override
	public void invokeEvent() 
	{
		SoundEffectPlayer.play_soundID(mSoundID, mVolume);
	}
}
