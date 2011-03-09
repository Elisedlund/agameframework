package com.agameframework.tofixorgarbage;
//package com.agameframework.input;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import android.content.Context;
//import android.hardware.Sensor;
//import android.hardware.SensorEvent;
//import android.hardware.SensorEventListener;
//import android.hardware.SensorManager;
//
//import com.agameframework.Game;
//
//
////TODO move to GameInput.
//public class Accelerometer {
//
//	// a sensor manager used to control the accelerometer sensor.
//	private static SensorManager sSensorManager;
//
//	//list of AccelerometerListeners
//	private static ArrayList<AccelerometerListener> sListenerList = null;
//
//	/**
//	 * Register the accelerometer and add a listener
//	 */
//	public static void addAccelerometerListener(AccelerometerListener listener) {
//		if (sSensorManager == null)
//		{
//			sSensorManager = (SensorManager) Game.instance.getSystemService(Context.SENSOR_SERVICE);
//
//			Sensor sensor = null;
//			List<Sensor> sensors = sSensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
//			if(sensors.size() > 0)
//			{
//				sensor = sensors.get(0);
//			}
//
//			//SENSOR_DELAY_GAME is a good rate for games.
//			//register a listener for the accelerometer.
//			sSensorManager.registerListener(mSensorAccelerometer, sensor, SensorManager.SENSOR_DELAY_GAME);
//		}
//		
//		if (sListenerList == null)
//		{
//			sListenerList = new ArrayList<AccelerometerListener>();
//		}
//		sListenerList.add(listener);
//	}
//
//	/**
//	 * Unregister the accelerometer sensor otherwise it will continue to operate
//	 * and report values.
//	 */
//	public static void removeAccelerometerListener() {
//		sSensorManager.unregisterListener(mSensorAccelerometer);
//	}
//
//	private static SensorEventListener mSensorAccelerometer = new SensorEventListener() {
//
//		@Override
//		public void onAccuracyChanged(Sensor sensor, int accuracy) {
//		}
//
//		@Override
//		public void onSensorChanged(SensorEvent event) {
//			if (sListenerList == null)
//			{
//				removeAccelerometerListener();
//			}
//
//			int size = sListenerList.size();
//			for (int i = size - 1; i != -1; i--)
//			{
//				sListenerList.get(i).AccelerometerUpdate(event.values[0],event.values[1],event.values[2]);
//			}
//		}
//	};
//}//end of class
