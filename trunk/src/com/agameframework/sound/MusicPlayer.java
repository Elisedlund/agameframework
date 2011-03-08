package com.agameframework.sound;

import java.io.IOException;

import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;

import com.agameframework.Game;
import com.agameframework.debug.Debug;
import com.agameframework.settings.GameSettings;

/**
 * Music plays one sound file, continuously or once.
 * It's only suitable for background music. it should not be used for
 * sound effects(Use the SoundEffectPlayer) in game.
 * @author Elis
 *
 */
public class MusicPlayer extends MediaPlayer{

	
	/** 
	 * Begins to play a sound file in the background.
	 * @param filename path to the sound file in the /assets/ folder 
	 * @param continuous TRUE to loop the sound
	 */
	public void play(String filename, boolean continuous) {
		if(!GameSettings.getSoundMusic())
		{return;}
		this.release(); 
		try {
			if(continuous)
			{
				try {
					this.setLooping(continuous);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			//TODO MEDIA HANDLER?
			AssetFileDescriptor afd = Game.instance.getAssets().openFd(filename);
			this.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
			this.setAudioStreamType(AudioManager.STREAM_ALARM);
			this.prepare();
			this.start();
		} catch (IOException e) {
			Debug.print("Could not find " + filename + " in assets folder");
			e.printStackTrace();
		}
	}

	/*
	 * Sets the volume 
	 */
	public void setVolume(float volume) {
		this.setVolume(volume, volume);
	}
	
	/*
	 * restarts the music.
	 */
	public void restart() {
		this.seekTo(0);
	}


	/**
	 * Stops playing the music, and releases the MediaPlayer. Should be called when you 
	 * are finished with the music even if the game is being terminated.
	 */
	public void end() {
		if(this.isPlaying())
			this.stop();
		this.release();
	}

}
