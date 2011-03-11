package com.agameframework.input;

import java.util.ArrayList;
import java.util.List;

import com.agameframework.Game;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.KeyEvent;
import android.view.MotionEvent;

/**
 *
 * @author Elis - Email: Elisedlund@gmail.com - Date: 10 feb 2011
 */
public class GameInput{

	private static ArrayList<KeyReleaseListener> sKeyReleaseList;
	private static ArrayList<KeyPressListener> sKeyPressList;
	private static ArrayList<TouchDownListener> sTouchDownList;
	private static ArrayList<TouchUpListener> sTouchUpList;
	private static ArrayList<TouchMoveListener> sTouchMoveList;
	private static ArrayList<TrackballListener> sTrackballList;
	private static ArrayList<AccelerometerListener> sAccelerometerList;
	private static SensorEventListener sSensorAccelerometer = new SensorEventListener() {
		
		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
		}
	
		@Override
		public void onSensorChanged(SensorEvent event) {
	
			if (sAccelerometerList == null) {return;} //should not be needed.
			
			int size = sAccelerometerList.size();
			for (int i = size - 1; i != -1; i--)
			{
				sAccelerometerList.get(i).AccelerometerUpdate(event.values[0],event.values[1],event.values[2]);
			}
		}
	};

	// a sensor manager used to control the accelerometer sensor.
	private static SensorManager sSensorManager;

	public static boolean sIsTouchable;


	public static void reset()
	{
		sKeyReleaseList = null;
		sKeyPressList = null;
		sTouchDownList = null;
		sTouchUpList = null;
		sTouchMoveList = null;
		sTrackballList = null;
		sAccelerometerList = null;
		if (sSensorManager != null)
		{
			unactivateAccelerometer();
		}
		sIsTouchable = false;
	}
	
	public static void addKeyPressListner(KeyPressListener obj)
	{
		if (sKeyPressList == null)
		{
			sKeyPressList = new ArrayList<KeyPressListener>();
		}
		sKeyPressList.add(obj);
	}
	
	public static void removeKeyPressListner(KeyPressListener obj)
	{
		if (sKeyPressList != null)
		{
			sKeyPressList.remove(obj);
		}
	}

	public static void addKeyReleaseListner(KeyReleaseListener obj)
	{
		if (sKeyReleaseList == null)
		{
			sKeyReleaseList = new ArrayList<KeyReleaseListener>();
		}
		sKeyReleaseList.add(obj);
	}
	
	public static void removeKeyReleaseListner(KeyReleaseListener obj)
	{
		if (sKeyReleaseList != null)
		{
			sKeyReleaseList.remove(obj);
		}
	}

	public static void addTouchDownListner(TouchDownListener obj)
	{
		if (sTouchDownList == null)
		{
			sTouchDownList = new ArrayList<TouchDownListener>();
		}
		sTouchDownList.add(obj);
		sIsTouchable=true;
	}

	public static void removeTouchDownListner(TouchDownListener obj)
	{
		if (sTouchDownList != null)
		{
			sTouchDownList.remove(obj);
		}
	}

	public static void addTouchUpListner(TouchUpListener obj)
	{
		if (sTouchUpList == null)
		{
			sTouchUpList = new ArrayList<TouchUpListener>();
		}
		sTouchUpList.add(obj);
		sIsTouchable=true;
	}

	public static void removeTouchUpListner(TouchUpListener obj)
	{
		if (sTouchUpList != null)
		{
			sTouchUpList.remove(obj);
		}
	}


	public static void addTouchMoveListner(TouchMoveListener obj)
	{
		if (sTouchMoveList == null)
		{
			sTouchMoveList = new ArrayList<TouchMoveListener>();
		}
		sTouchMoveList.add(obj);
		sIsTouchable=true;
	}

	public static void removeTouchMoveListner(TouchMoveListener obj)
	{
		if (sTouchMoveList != null)
		{
			sTouchMoveList.remove(obj);
		}
	}

	public static void addTrackballListener(TrackballListener obj)
	{
		if (sTrackballList == null)
		{
			sTrackballList = new ArrayList<TrackballListener>();
		}
		sTrackballList.add(obj);
	}

	public static void removeTrackballListener(TrackballListener obj)
	{
		if (sTrackballList != null)
		{
			sTrackballList.remove(obj);
		}
	}

	/**
	 * Register the accelerometer and add a listener
	 */
	public static void addAccelerometerListener(AccelerometerListener listener) 
	{
		activateAccelerometer();
		if (sAccelerometerList == null)
		{
			sAccelerometerList = new ArrayList<AccelerometerListener>();
		}
		sAccelerometerList.add(listener);
	}

	public static void removeAccelerometerListener(AccelerometerListener listener) 
	{
		if (sAccelerometerList != null)
		{
			sAccelerometerList.remove(listener);
		}
		
		if (sAccelerometerList == null || sAccelerometerList.isEmpty())
		{
			unactivateAccelerometer();
		}
	}

	public static boolean doKeyDown(int keyCode, KeyEvent msg) {
		if (sKeyPressList == null)
		{
			return false;
		}

		int size = sKeyPressList.size();
		for (int i = size - 1; i != -1; i--)
		{
			sKeyPressList.get(i).keyPress(keyCode, msg);
		}
		return true; //event handled
	}

	public static boolean doKeyUp(int keyCode, KeyEvent msg) {
		if (sKeyReleaseList == null)
		{
			return false;
		}

		int size = sKeyReleaseList.size();
		for (int i = 0; i != size; i++)
		{
			sKeyReleaseList.get(i).keyRelease(keyCode, msg);
		}
		return true; //event handled
	}

	public static void onTouchEvent(MotionEvent event) {
		if(!sIsTouchable){return;}
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
			touchDown(event);
			break;
		case MotionEvent.ACTION_MOVE:
			touchMove(event);
			break;
		case MotionEvent.ACTION_UP:
			touchUp(event);
			break;
		}//end of case
	}//end of touch

	private static void touchUp(MotionEvent event) {
		if ( sTouchUpList == null)
		{
			return;
		}

		int size =  sTouchUpList.size();
		for (int i = 0; i != size; i++)
		{
			sTouchUpList.get(i).touchUp(event);
		}
	}

	private static void touchMove(MotionEvent event) {
		if ( sTouchMoveList == null)
		{
			return;
		}

		int size =  sTouchMoveList.size();
		for (int i = 0; i != size; i++)
		{
			sTouchMoveList.get(i).touchMove(event);
		}
	}

	private static void touchDown(MotionEvent event) {
		if ( sTouchDownList == null)
		{
			return;
		}

		int size =  sTouchDownList.size();
		for (int i = 0; i != size; i++)
		{
			sTouchDownList.get(i).touchDown(event);
		}
	}

	public static boolean onTrackballEvent(MotionEvent event) {
		if (sTrackballList == null)
		{
			return false; //event not handled
		}
		
		int size = sTrackballList.size();
		for (int i = 0; i != size; i++)
		{
			sTrackballList.get(i).trackball(event);
			
			
		}
		return true; //event handled
	}

	private static void activateAccelerometer()
	{
		if (sSensorManager == null)
		{
			sSensorManager = (SensorManager) Game.instance.getSystemService(Context.SENSOR_SERVICE);
	
			Sensor sensor = null;
			List<Sensor> sensors = sSensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
			if(sensors.size() > 0)
			{
				sensor = sensors.get(0);
			}
	
			//SENSOR_DELAY_GAME is a good rate for games.
			//register a listener for the accelerometer.
			sSensorManager.registerListener(sSensorAccelerometer, sensor, SensorManager.SENSOR_DELAY_GAME);
		}
	
	}

	/**
	 * Unregister the accelerometer sensor otherwise it will continue to operate
	 * and report values.
	 */
	private static void unactivateAccelerometer() {
		sSensorManager.unregisterListener(sSensorAccelerometer);
		sSensorManager = null;
	}


}//end of class