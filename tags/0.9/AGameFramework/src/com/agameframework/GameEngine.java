/*
 * Copyright (C) 2009 Elis Edlund.
 */

package com.agameframework;

import android.content.Context;
import android.graphics.PixelFormat;
import android.opengl.GLSurfaceView;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import com.agameframework.debug.Debug;
import com.agameframework.input.GameInput;
import com.agameframework.settings.GameSettings;


/**
 * @author Elis
 *
 */
public class GameEngine extends GLSurfaceView {

	/** Game thread **/
	public static GameThread sGameThread;

	private AbstractRenderer mRenderer;


	/**
	 * 
	 * @param context
	 * @param state
	 */
	public GameEngine(Context context)
	{
		super(context);
		init();	
	}

	/**
	 * Shall only be called from the constructor.
	 * @param context
	 * @param state
	 */
	private void init()
	{
		Debug.startTrace();
		SurfaceHolder holder = getHolder();
		holder.setFormat(PixelFormat.RGB_565); // ...
		holder.addCallback(this);
		setFocusable(true);//needed for input.
		System.gc();//garbage collect.

		mRenderer  = new Renderer2D();
		setRenderer(mRenderer);
		Debug.print("init engine");
		this.setRenderMode(RENDERMODE_WHEN_DIRTY);
		sGameThread = new GameThread(this);
		sGameThread.setGameRoot(Game.instance.mGameRoot);
		sGameThread.setFps(GameSettings.getFPS());
	}


	/**
	 * This is called immediately before a surface is being destroyed.
	 */
	public void surfaceDestroyed(SurfaceHolder holder)
	{
		sGameThread.setPaused(true);
		Debug.print("Surface destroyed");
		super.surfaceDestroyed(holder);
	}

	/* INPUT */
	/**
	 * Standard override to get key-press events.
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent msg) {
		GameInput.doKeyDown(keyCode, msg);
		
		//TODO more control
		return false; // so back and soundbottons work
	}

	/**
	 * Standard override to get key-up events.
	 */
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent msg) {
		GameInput.doKeyUp(keyCode, msg);
		//TODO more control
		return false; // so back and soundbottons work
	}

	/**
	 * Standard override to get touch events.
	 */
	@Override
	public boolean onTouchEvent(final MotionEvent event) 
	{	
		GameInput.onTouchEvent(event);
		return true;
	}

	/**
	 * Standard override to get trackball events.
	 */
	@Override
	public boolean onTrackballEvent(MotionEvent event)
	{
		return GameInput.onTrackballEvent(event);
	}

}// end of GameEngine 
