package com.agameframework.event;

import com.agameframework.Game;
import com.agameframework.interfaces.IEvent;
import com.agameframework.sound.SoundEffectPlayer;
import com.agameframework.utils.GameIntents;

public class SoundAndVibrateEvent implements IEvent{

	private int mSoundID;
	private int mLength;

	public SoundAndVibrateEvent(int soundID, int vibrateLength)
	{
		mSoundID = soundID;
		mLength = vibrateLength;
	}

	@Override
	public void invokeEvent() 
	{
		SoundEffectPlayer.play(mSoundID);
		Game.instance.vibrate(mLength);
	}
	
	public static void invoke(int soundID, int vibrateLength)
	{
		SoundEffectPlayer.play(soundID);
		Game.instance.vibrate(vibrateLength);
	}
}
