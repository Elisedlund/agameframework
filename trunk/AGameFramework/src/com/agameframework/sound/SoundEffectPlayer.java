package com.agameframework.sound;

import java.util.HashMap;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import com.agameframework.Game;
import com.agameframework.debug.Debug;
import com.agameframework.settings.GameSettings;

/**
 * 
 * @author Elis
 */
public class SoundEffectPlayer {
	private static final int MAX_STREAMS = 25;
	private static AudioManager sAudioManager = (AudioManager)Game.instance.getSystemService(Context.AUDIO_SERVICE);
	private static int sStreamVolume = sAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC); 

	//TODO is static going to be a problem?. probably. change. 
	
	private static SoundPool sSoundPool; 
	private static HashMap<Integer, Integer> sSoundPoolMap; 
	

	private static void loadPlayer()
	{
		if(sSoundPool==null)
		{
			sSoundPool = new SoundPool(MAX_STREAMS, AudioManager.STREAM_MUSIC, 0);
		}
		if(sSoundPoolMap == null)
		{
			sSoundPoolMap = new HashMap<Integer, Integer>(); 
		}
	}

	public static void load(int resourceID)
	{
		loadPlayer();
		if(isLoaded(resourceID))
		{
			return; // no need to load it twice.
		}
		
		int id = sSoundPool.load(Game.instance,resourceID,0);
		sSoundPoolMap.put(resourceID, id);
	}


	public static void play(int resourceID) { 
		if(!GameSettings.getSoundEffect())
		{return;}
		if(!isLoaded(resourceID))
		{
			load(resourceID);
			Debug.print("Loading sound. its recommended that the sound is loaded manually beforehand");
		}
		sSoundPool.play(sSoundPoolMap.get(resourceID), sStreamVolume, sStreamVolume, 1, 0, 1f); 
	} 

	public static void play(int resourceID, float volumeProcentage) { 
		if(!GameSettings.getSoundEffect())
		{return;}
		if(!isLoaded(resourceID))
		{
			load(resourceID);
			Debug.print("Loading sound. its recommended that the sound is loaded manually beforehand");
		}
		sSoundPool.play(sSoundPoolMap.get(resourceID), sStreamVolume*volumeProcentage, sStreamVolume*volumeProcentage, 1, 0, 1f); 
	}
	
	
	public static void play_soundID(int soundID)
	{
		if(!GameSettings.getSoundEffect())
		{return;}
		sSoundPool.play(soundID, sStreamVolume, sStreamVolume, 1, 0, 1f); 
	}
	
	public static int getSoundID(int resourceID)
	{
		return sSoundPoolMap.get(resourceID);
	}
		
	public static void release()
	{
		sSoundPool.release();
		sSoundPool = null;
		sSoundPoolMap = null;
	}
	
	private static boolean isLoaded(int resourceID)
	{
		return sSoundPoolMap.containsKey(resourceID);
	}
}//end of class