package com.agameframework.debug;


import android.util.Log;

import com.agameframework.settings.GameSettings;


/**
 * Handles LogCat output, and timing events for testing
 * @author Elis
 */
public final class Debug {

	//print debugtest
	public static final boolean DEBUG_LEVEL1 = GameSettings.DEBUG_LEVEL1;
	
	//timeing 
	public static final boolean DEBUG_LEVEL2 = GameSettings.DEBUG_LEVEL2;

	//traceing
	public static final boolean DEBUG_LEVEL3 = GameSettings.DEBUG_LEVEL3;	
	
	
	private static long startTime = 0;
	private static long lastInterval = 0;


	//TODO LOG.v?
	/**
	 * @param msg string to be printed to LogCat
	 */
	public static void print(String msg) {
		if(DEBUG_LEVEL1)
			Log.v("AGameFramework", msg);
	}

	/**
	 * Starts a timer to record how long it takes for certain events to take place
	 */
	public static void startTimer() {
		if(DEBUG_LEVEL2) {
			startTime = System.currentTimeMillis();
			lastInterval = startTime;
		}
	}

	/**
	 * Debugs the timer, outputting time difference from startTimer()
	 * @param message prefix message for LogCat
	 */
	public static void getTime(String message) {
		if(DEBUG_LEVEL2) {
			long diff = System.currentTimeMillis() - startTime;
			Debug.print(message + " took " + diff + "ms");
		}
	}

	/**
	 * Debugs the timer, outputting time difference from startTimer()
	 */
	public static void getTime() {
		if(DEBUG_LEVEL2) {
			long diff = System.currentTimeMillis() - startTime;
			print("Took " + diff + "ms");
		}
	}

	/**
	 * Debugs the timer, outputting time difference from the last interval (startTimer() if none have been called before)
	 * @param message prefix message for LogCat
	 */
	public static void getIntervalTime(String message) {
		if(DEBUG_LEVEL2) {
			long diff = System.currentTimeMillis() - lastInterval;
			print(message + " interval took " + diff + "ms");
			lastInterval = System.currentTimeMillis();
		}
	}

	/**
	 * Debugs the timer, outputting time difference from the last interval (startTimer() if none have been called before)
	 */
	public static void getIntervalTime() {
		if(DEBUG_LEVEL2) {
			long diff = System.currentTimeMillis() - lastInterval;
			print("Interval took " + diff + "ms");
			lastInterval = System.currentTimeMillis();
		}
	}

	/**
	 * Prints a warning to LogCat, regardless of being in debug mode or not
	 * @param warning message to be passed on to LogCat
	 */
	public static void warning(String warning) {
		Log.e("AGAMEFRAMEWORK", "AGAMEFRAMEWORK WARNING : " + warning);
		(new Exception("AGAMEFRAMEWORKWARNING : " + warning)).printStackTrace();
	}

	public static void startTrace()
	{
		if (DEBUG_LEVEL3) {
			android.os.Debug.startMethodTracing("AGameFrameworkTrace");
		}
	}

	public static void stopTrace()
	{

		if (DEBUG_LEVEL3) {
			android.os.Debug.stopMethodTracing();
		}
	}

}
