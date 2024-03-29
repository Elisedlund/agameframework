package com.agameframework;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView;

import com.agameframework.debug.Debug;
import com.agameframework.settings.GameSettings;
import com.agameframework.utils.PerformanceTimer;


public class Renderer2D extends AbstractRenderer implements GLSurfaceView.Renderer{

	private boolean mShowFps = GameSettings.SHOW_FPS;
	private PerformanceTimer mPerformanceTimer;
	{
		if (mShowFps)
			mPerformanceTimer = new PerformanceTimer("Average frame render", 500);
	}
	
	public Renderer2D() {
		super();	
	}

	public void onSurfaceCreated(GL10 gl, EGLConfig config) {

		Debug.print("Renderer onSurfaceCreated");

		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);

		gl.glClearColor(mRed, mGreen, mBlue, 1f);//TODO alpha? blurry?
		gl.glShadeModel(GL10.GL_FLAT); //TODO remove?
		gl.glEnable(GL10.GL_BLEND);
		gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
//		gl.glBlendFunc(GL10.GL_ONE, GL10.GL_ONE_MINUS_SRC_ALPHA);
		gl.glColor4x(0x10000, 0x10000, 0x10000, 0x10000);
		gl.glDisable(GL10.GL_DEPTH_TEST);//TODO enable? to controll depth of sprites?
		gl.glEnable(GL10.GL_TEXTURE_2D);

		/*
		 * By default, OpenGL enables features that improve quality but reduce
		 * performance. One might want to tweak that especially on software
		 * renderer.
		 */
		gl.glDisable(GL10.GL_DITHER);
		gl.glDisable(GL10.GL_LIGHTING);

		gl.glTexEnvx(GL10.GL_TEXTURE_ENV, GL10.GL_TEXTURE_ENV_MODE, GL10.GL_MODULATE);


		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

		info(gl);
		super.onSurfaceCreated(gl, config);
	}

	/** 
	 * Draws the whole game
	 */
	public void onDrawFrame(GL10 gl) {

	
		if(mGameRoot != null)
		{
			if (mShowFps)
				mPerformanceTimer.startTimer();
			gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
			gl.glMatrixMode(GL10.GL_MODELVIEW);
			
			//Needed to change opacity and color.
			gl.glTexEnvx(GL10.GL_TEXTURE_ENV, GL10.GL_TEXTURE_ENV_MODE, GL10.GL_MODULATE); 
			
			mGameRoot.render(gl);
			if (mShowFps)
				mPerformanceTimer.stopTimer();
		}
	}

	public void onSurfaceChanged(GL10 gl, int width, int height) {


		float scaleX = (float)width / Game.getWidth();
		float scaleY =  (float)height / Game.getHeight();
		final int viewportWidth = (int)(Game.getWidth() * scaleX);
		final int viewportHeight = (int)(Game.getHeight() * scaleY);
		gl.glViewport(0, 0, viewportWidth, viewportHeight);
		//		mScaleX = scaleX;
		//		mScaleY = scaleY;

		// ensure the same aspect ratio as the game
		float ratio = (float) Game.getWidth() / Game.getHeight();
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glFrustumf(-ratio, ratio, -1, 1, 1, 10);
	}

}