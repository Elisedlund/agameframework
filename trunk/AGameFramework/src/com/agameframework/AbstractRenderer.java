package com.agameframework;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView;

import com.agameframework.debug.Debug;
import com.agameframework.interfaces.ILoadable;
import com.agameframework.interfaces.IUpdatableAndRenderable;
import com.agameframework.object.GameNode;
import com.agameframework.texture.TextureHandler;


public abstract class AbstractRenderer implements GLSurfaceView.Renderer 
{

	protected static float mRed=0f;
	protected static float mGreen=0f;
	protected static float mBlue=0f;
	protected static GameNode mGameRoot;
	protected static ILoadable mLoader;
	protected static boolean sReloadTextures = false;

	public AbstractRenderer() 
	{
		mGameRoot = Game.instance.mGameRoot; 
		Debug.print("renderer constructor");
	}
	
	public void onSurfaceCreated(GL10 gl, EGLConfig config)
	{
		TextureHandler.setGL(gl);
		if(GameEngine.sGameThread.getState() == Thread.State.NEW)
		{
			if(mLoader != null)
			{
				Debug.print("loading.....");
				mLoader.load();
				mGameRoot.init();
				Debug.print("Done loading!");
			}
			GameEngine.sGameThread.start();
		}
		else if(sReloadTextures)
		{
			Debug.print("Reloads textures");
			TextureHandler.reloadTextures(); //reloads all textures.
			GameEngine.sGameThread.setPaused(false); //Start gameloop again
			sReloadTextures = false; //this line wont make a difference.
		}
	}

	/** 
	 * Draws the whole game
	 * @see android.opengl.GLSurfaceView.Renderer#onDrawFrame(javax.microedition.khronos.opengles.GL10)
	 */
	abstract public void onDrawFrame(GL10 gl);

	abstract public void onSurfaceChanged(GL10 gl, int w, int h);

	protected void info(GL10 gl)
	{
		String extensions = gl.glGetString(GL10.GL_EXTENSIONS); 
		String version = gl.glGetString(GL10.GL_VERSION);
		String renderer = gl.glGetString(GL10.GL_RENDERER);
		boolean isSoftwareRenderer = renderer.contains("PixelFlinger");
		boolean isOpenGL10 = version.contains("1.0");
		boolean supportsDrawTexture = extensions.contains("draw_texture");
		// VBOs are standard in GLES1.1
		// No use using VBOs when software renderering, esp. since older versions of the software renderer
		// had a crash bug related to freeing VBOs.
		boolean supportsVBOs = !isSoftwareRenderer && (!isOpenGL10 || extensions.contains("vertex_buffer_object"));
		Debug.print("Graphics Support: " + version + " (" + renderer + "): " +(supportsDrawTexture ?  "draw texture," : "") + (supportsVBOs ? "vbos" : ""));
	}

	protected static void setColor(float r,float g,float b)
	{
		mRed = r;
		mGreen = g;
		mBlue = b; 
	} 
	
	protected static void setGameRoot(GameNode s)
	{
		mGameRoot = s;
	}

}