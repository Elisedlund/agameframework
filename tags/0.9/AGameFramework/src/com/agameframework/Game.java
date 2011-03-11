package com.agameframework;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.Vibrator;
import android.view.Window;
import android.view.WindowManager;

import com.agameframework.debug.Debug;
import com.agameframework.debug.GameErrorReporter;
import com.agameframework.input.GameInput;
import com.agameframework.interfaces.IEvent;
import com.agameframework.interfaces.ILoadable;
import com.agameframework.interfaces.ISettings;
import com.agameframework.object.GameNode;
import com.agameframework.object.Rectangle;
import com.agameframework.settings.GameSettings;
import com.agameframework.texture.TextureHandler;



/**
 *
 * @author Elis - Email: Elisedlund@gmail.com - Date: 2 mar 2011
 */
public class Game extends Activity {

	/** Game context */
	public static Game instance;

	protected GameNode mGameRoot = null;

	private Vibrator mVibrator;

	private PowerManager mPowerManager;
	private PowerManager.WakeLock mWakeLock;

	private GameEngine mGameEngine;

	/** Width of the game NOT the screen width. */
	private int mGameWidth=320;

	/** Height of the game NOT the screen height. */
	private int mGameHeight=480;

	private Rectangle sGameRectangle;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{	
		super.onCreate(savedInstanceState);

		instance = this;
		GameSettings.reset(this);
		GameInput.reset();
		TextureHandler.reset();

		loadSettings();

		//TODO MOVE TO SETTINGS.
		// No Title bar
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		// No Status bar.
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);		
		GameSettings.incStartedCount();
		startGame();
		if(GameSettings.DEVELOPER_MAIL != null)
		{
			GameErrorReporter.getInstance();
		}

		Debug.print("activity created");
		sGameRectangle = new Rectangle(0f,0f,mGameWidth,mGameHeight);
	}

	public void onStart()
	{
		super.onStart();
	}

	@Override
	public void onPause()
	{
		mGameEngine.onPause();
		releaseWakeLock();
		super.onPause();
	}


	/**
	 * Will always run at startup or when resuming game.
	 */	
	@Override
	public void onResume()
	{
		mGameEngine.onResume();
		acquireWakeLock();		
		super.onResume();
	}

	@Override
	public void onRestart()
	{	
		super.onRestart();
		AbstractRenderer.sReloadTextures = true; //game restarted load all textures again.
		//TODO pause screen .tap screen to resume playing.
	}

	@Override
	public void onDestroy()
	{
		Debug.print("Game activity onDestroy()");
		GameInput.reset(); // removes all input.
		GameEngine.sGameThread.quitGame();
		boolean retry = true;
		while(retry)
		{
			try
			{
				Debug.print("join update thread");
				GameEngine.sGameThread.join();
				retry = false;
			} catch (InterruptedException e) {
				Debug.print("Exception join thread");
				e.printStackTrace();
			}
		}
		GameEngine.sGameThread = null;
		instance = null;
		super.onDestroy();
	}

	public static void setClearColor(float red, float green, float blue)
	{
		AbstractRenderer.setColor(red,green,blue);
	}

	public static void setGameRoot(GameNode gameroot) {

		if(instance.mGameRoot != null) //remove(clear from input) last one.
		{
			instance.mGameRoot.remove();
		}

		instance.mGameRoot = gameroot;

		//only possible at start. but they will get the root anyway and it will init after loading.
		if(GameEngine.sGameThread != null)
		{
			GameEngine.sGameThread.setGameRoot(gameroot);
			AbstractRenderer.setGameRoot(gameroot);
			gameroot.init();
		}
	}

	public static void setLoader(ILoadable loader) {
		AbstractRenderer.mLoader = loader;
	}

	public static int getHeight() {
		return instance.mGameHeight;
	}

	public static int getWidth() {
		return instance.mGameWidth;
	}

	public static float getRandomX()
	{
		return (float)(Math.random() * instance.mGameWidth);
	}

	public static float getRandomY()
	{
		return (float)(Math.random() * instance.mGameHeight);
	}

	public static int getCenterX()
	{
		return instance.mGameWidth/2;
	}

	public static int getCenterY()
	{
		return instance.mGameHeight/2;
	}

	public static Rectangle getGameRectangle()
	{
		return instance.sGameRectangle;

	}

	public static void addTimedEvent(IEvent event, int time)
	{
		GameEngine.sGameThread.addTimedEvent(event, time);
	}

	/** Add a event to be invoked just before the next update.
	 *  useful when a async task like input wants to invoke a event.
	 * @param event
	 */
	public static void addSyncEvent(IEvent event)
	{
		GameEngine.sGameThread.mSyncEventsList.add(event);
	}

	public static String findString(int stringID)
	{
		return instance.getString(stringID);
	}

	public void vibrate(long time)
	{
		if(!GameSettings.getVibrate())
		{return;}
		getVibrator().vibrate(time);
	}

	public void vibrate(long[] pattern, int repeat)
	{
		if(!GameSettings.getVibrate())
		{return;}
		getVibrator().vibrate(pattern, repeat);
	}

	/**Only set it in settings before the game start. don't change it while running the game.
	 * @param width
	 * @param height
	 */
	public void setGameSize(int width, int height)
	{
		mGameWidth = width;
		mGameHeight = height;
	}
	private void startGame()
	{
		mGameEngine = new GameEngine(this);
		setContentView(mGameEngine);	
	}

	private void loadSettings() {

		Class<?> settingsClass = null;
		try 
		{
			settingsClass =  Class.forName( "com.agameframework.Settings");
		}catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}

		if(settingsClass != null)
		{
			ISettings settings = null; 
			try {
				settings = (ISettings) settingsClass.newInstance();
			} catch (IllegalAccessException e) 
			{
				e.printStackTrace();
			} catch (InstantiationException e) 
			{
				e.printStackTrace();
			}
			if (settings!=null)
				settings.loadSettings();
		}
	} //end of func

	private Vibrator getVibrator() 
	{
		if (mVibrator==null)
		{
			mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);	
		}
		return mVibrator;
	}

	private void acquireWakeLock()
	{
		if(mWakeLock == null || !mWakeLock.isHeld())
		{
			mPowerManager = (PowerManager) this.getSystemService(Context.POWER_SERVICE);
			mWakeLock = mPowerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK,"AGFWakelock");
			mWakeLock.acquire();
		}
	}

	private void releaseWakeLock()
	{
		if(mWakeLock != null && mWakeLock.isHeld())
		{
			mWakeLock.release();
		}
	}
}