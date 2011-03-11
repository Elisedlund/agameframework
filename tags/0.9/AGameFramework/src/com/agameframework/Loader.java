package com.agameframework;

import java.lang.reflect.Field;

import com.agameframework.sound.SoundEffectPlayer;
import com.agameframework.texture.TextureHandler;


public class Loader {


	public static void loadTexture(int resourceID)
	{
		TextureHandler.loadTexture(resourceID);
	}

	public static void loadTexture(int[] list)
	{
		int size = list.length;
		for(int i=0; i<size ; i++)
		{
			TextureHandler.loadTexture(list[i]);
		}
	}

	public static void loadTexture(Field[] fields) {

		int size = fields.length;
		for(int i=0; i<size ; i++)
		{
			try {
				TextureHandler.loadTexture(fields[i].getInt(null));
			} catch (IllegalArgumentException e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void loadSound(int resourceID)
	{
		SoundEffectPlayer.load(resourceID);
	}

	public static void loadSound(int[] list)
	{
		int size = list.length;
		for(int i=0; i<size ; i++)
		{
			SoundEffectPlayer.load(list[i]);
		}
	}	

	public static void loadSound(Field[] fields) {

		int size = fields.length;
		for(int i=0; i<size ; i++)
		{
			try {
				SoundEffectPlayer.load(fields[i].getInt(null));
			} catch (IllegalArgumentException e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void loadText(String text, int fontResourceID) {
		TextureHandler.loadStaticTextTexture(fontResourceID, text);
	}

	public static void loadText(String[] text, int fontResourceID) {
		for(int i = 0 ; i<text.length;i++)
		{
			TextureHandler.loadStaticTextTexture(fontResourceID, text[i]);
		}
	}


}