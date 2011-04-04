package com.agameframework;

import java.util.ArrayList;
import java.util.LinkedList;

import com.agameframework.debug.Debug;
import com.agameframework.interfaces.IEvent;
import com.agameframework.interfaces.IUpdatableAndRenderable;
import com.agameframework.object.GameNode;
import com.agameframework.settings.GameSettings;
import com.agameframework.utils.MilliTimer;
import com.agameframework.utils.PreformanceTimer;


/**
 * Custom thread used to control game updates and rendering.
 */
public class GameThread extends Thread {

	/** Root of game tree**/
	private GameNode mGameRoot;

	/** If false => Stops the animation and quits the game **/
	private volatile boolean mIsGameRunning = true; 

	/** The time a frame update should take to get desired FPS **/
	private int mMaxTimeForAFrame; 

	/** The timer **/
	private MilliTimer mTimer = new MilliTimer();

	/** If true => Stops updating and drawing **/
	private volatile boolean mIsPaused = false;

	private boolean mShowFps = GameSettings.SHOW_FPS;
	private PreformanceTimer mPreformanceTimer;
	{
		if (mShowFps)
			mPreformanceTimer = new PreformanceTimer("Average frame update", 500);
	}
	private ArrayList<IEvent> mTimedEventsList = new ArrayList<IEvent>(1);
	private ArrayList<Long> mEventTimesList = new ArrayList<Long>(1);
	private GameEngine mGameRenderer;

	protected ArrayList<IEvent> mSyncEventsList = new ArrayList<IEvent>(1);


	public GameThread(GameEngine gameEngine)
	{
		mGameRenderer = gameEngine;
	}

	public void setFps(int fps)
	{
		mMaxTimeForAFrame = 1000 / fps;
	}

	public boolean isPaused() {
		return mIsPaused;
	}

	public void setPaused(boolean isPaused) {
		mIsPaused = isPaused;
	}

	public void setGameRoot(GameNode gameNode) {
		mGameRoot = gameNode;
	}

	public void run()
	{
		long spareTime;
		long overSleepTime = 0L;

		Debug.print("Game running :" + mIsGameRunning);

		while (mIsGameRunning)// the main game loop
		{
			if (!mIsPaused)
			{
				mTimer.startTimer();

				doSyncEvents();
				doTimedEvents();
				if (mShowFps)
					mPreformanceTimer.startTimer();
				mGameRoot.update();// game state is updated
				if (mShowFps)
					mPreformanceTimer.stopTimer();

				//TODO TEST.
				mGameRenderer.requestRender();
				
				mTimer.stopTimer();

				spareTime = (mMaxTimeForAFrame - mTimer.getTime())
				- overSleepTime;
				if (spareTime > 0)//if some time left in this cycle
				{ 
					try
					{
						Thread.sleep(spareTime); 
					}
					catch (InterruptedException e)
					{
					}
					overSleepTime = mTimer.getTimeSinceTimerStop()
					- spareTime;
				}
				else
				{ // spareTime <= 0; frame took longer than the
					// maxTimeForAFrame
					overSleepTime = 0L;
				}
			}
			else
				// if isPaused then sleep.
			{
				try
				{
					Thread.sleep(500);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
					Debug.warning("Exception. Could not sleep while Pause.");
				}
			} 
		}// end of game loop

		// quitGame() has been called
		Debug.stopTrace();
		Debug.print("Game Exit");
	}// end of func



	private void doSyncEvents() {
		if (mSyncEventsList.isEmpty())
		{return;}

		int size = mSyncEventsList.size();
		for (int i = 0; i != size; i++) 
		{
			mSyncEventsList.get(i).invokeEvent();
		}
		mSyncEventsList.clear();
	}

	private void doTimedEvents() {
		if (mTimedEventsList.isEmpty())
		{return;}

		int size = mTimedEventsList.size();
		for (int i = 0; i < size; i++) 
		{
			//			Debug.print("et:" + mEventTimesList.get(i) +" rt:" + System.currentTimeMillis());
			if(mEventTimesList.get(i) < System.currentTimeMillis())
			{
				mTimedEventsList.get(i).invokeEvent();
				mTimedEventsList.remove(i);
				mEventTimesList.remove(i);
				size -= 1;
			}
		}
	}

	protected void quitGame()
	{
		mIsGameRunning = false;	
	}

	protected void addTimedEvent(IEvent event ,long time)
	{
		//TODO sorting and just trying to do the first one.
		mTimedEventsList.add(event);
		mEventTimesList.add(time + System.currentTimeMillis());
	}

}// end of GameThread class