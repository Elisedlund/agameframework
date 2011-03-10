package com.agameframework.texture;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;
import javax.microedition.khronos.opengles.GL11Ext;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.opengl.GLUtils;

import com.agameframework.Game;
import com.agameframework.debug.Debug;
import com.agameframework.text.Text;


/**
 * Handels textures.
 * @author Elis
 *
 */
public class TextureHandler {

	//sets preferred config to RGB_565.
	private static BitmapFactory.Options sBitmapOptions = new BitmapFactory.Options();
	static{
		sBitmapOptions.inPreferredConfig = Bitmap.Config.RGB_565;
	}

	// Pre-allocated arrays 
	private static int[] sTextureNameWorkspace = new int[1];
	private static int[] sCropWorkspace= new int[4];

	private static int sCurrentTextureName = -1;

	private static HashMap<Integer, Texture> sTextureMap = new HashMap<Integer, Texture>();
	private static HashMap<String, Texture> sTextTextureMap = new HashMap<String, Texture>(); 
	private static ArrayList<Texture> sTextureList = new ArrayList<Texture>();

	private static GL10 sGl;


	public static void setGL(GL10 gl) {
		sGl = gl;
	}

	public static void reset()
	{
		sTextureMap = new HashMap<Integer, Texture>();
		sTextTextureMap = new HashMap<String, Texture>(); 
		sTextureList = new ArrayList<Texture>();
	}

	/**
	 * checks if a resource has been loaded.
	 * @param resourceId
	 * @return
	 */
	public static boolean isIdLoaded(int resourceId) {
		return sTextureMap.containsKey(resourceId);
	}

	/**
	 * checks if a resource has been loaded.
	 * @param resourceId
	 * @return
	 */
	public static boolean isIdLoaded(String str) {
		return sTextTextureMap.containsKey(str);
	}

	/**
	 * Binds the texture so it can be rendered. The texture is chosen with its opengl name
	 * for a direct binding. The texture has to be loaded before a binding can be done.
	 * @param gl
	 * @param textureName
	 */
	public static void bindTextureName(int textureName)
	{
		if(sCurrentTextureName != textureName)
		{
			sCurrentTextureName = textureName;
			sGl.glBindTexture(GL10.GL_TEXTURE_2D, textureName);
		}
	}

	/** 
	 * Loads a bitmap into OpenGL and sets up the common parameters for 
	 * 2D texture . 
	 */
	public static void loadTexture(int resourceId) {

		if(isIdLoaded(resourceId))//return. The resource is loaded already
		{return;} 
//		Debug.print("loading: " + resourceId);
		Bitmap bitmap = loadBitmap(resourceId);

		Texture texture = new Texture();
		loadTexture(bitmap,texture);
		texture.mId = resourceId;
		sTextureMap.put(resourceId, texture);
		sTextureList.add(texture);

	}


	public static void loadStaticTextTexture(int fontResourceID , String str)
	{
		if(isIdLoaded(str))//return. The resource is loaded already
		{return;} 
		Text text = new Text(); //TODO once? 
		text.setText(str);
		Bitmap textBitmap = text.TextToBitmap(fontResourceID);
		Texture texture = new Texture();
		loadTexture(textBitmap,texture);
		texture.mId = fontResourceID;
		texture.mText = str;
		sTextureList.add(texture);
		sTextTextureMap.put(str, texture);
	}

	public static Bitmap loadBitmap(int resourceId)
	{
		InputStream is = Game.instance.getResources().openRawResource(resourceId);
		try {
			//			// This will tell the BitmapFactory to not scale based on the device's pixel density:
			//		    BitmapFactory.Options opts = new BitmapFactory.Options();
			//		    opts.inScaled = false;
			return BitmapFactory.decodeStream(is, null, sBitmapOptions);
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				Debug.warning("io close exception");
				e.printStackTrace();
			}
		}
	}

	/**
	 * returns a reference to texture if the resource id has been loaded. 
	 * if there is no such ID OR the ID never has been loaded it returns null
	 * @param resourceId
	 * @return
	 */
	public static Texture getTexture(int resourceId)
	{
		if(isIdLoaded(resourceId))
		{
			return sTextureMap.get(resourceId);
		}
		Debug.print("the texture of id: " + resourceId + " is not loaded");
		//TODO load texture if not loaded?
		return null;
	}

	/**
	 * returns a reference to texture if the string has been loaded. 
	 * if there is no such string OR the string have never has been loaded it returns null
	 * @param str
	 * @return
	 */
	public static Texture getTexture(String str)
	{
		if(isIdLoaded(str))
		{
			return sTextTextureMap.get(str);
		}
		Debug.warning("the texture of the text: " + str + " is not loaded!");
		//TODO load texture if not loaded?
		return null;
	}


	public static void reloadTextures()
	{
		sCurrentTextureName = -1;
		for(Texture tex : sTextureList) //TODO no gc.
		{
			if(tex.mText == null)
			{
				reloadTexture(tex);
			}
			else 
			{
				reloadStaticTextTexture(tex);
			}
		}
	}

	/** 
	 * Loads a bitmap into OpenGL and sets up the common parameters for 
	 * 2D texture . 
	 */
	private static void loadTexture(Bitmap bitmap, Texture texture) {
		GL10 gl = sGl;
		int textureName = -1;
		if (Game.instance != null && gl != null) {

			gl.glGenTextures(1, sTextureNameWorkspace, 0);

			textureName = sTextureNameWorkspace[0];
			gl.glBindTexture(GL10.GL_TEXTURE_2D, textureName);

			gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST);
			gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);

			gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_S, GL10.GL_CLAMP_TO_EDGE);
			gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_T, GL10.GL_CLAMP_TO_EDGE);

			gl.glTexEnvf(GL10.GL_TEXTURE_ENV, GL10.GL_TEXTURE_ENV_MODE, GL10.GL_REPLACE);

			texture.mImageHeight = bitmap.getHeight(); //size before resizeing if NPOT
			texture.mImageWidth = bitmap.getWidth(); //size before resizeing if NPOT
			if ((isToThePowerOfTwo(bitmap.getWidth()) == false) || 
					(isToThePowerOfTwo(bitmap.getHeight()) == false))
			{
				int width = nearestPowerOfTwo(bitmap.getWidth());
				int height = nearestPowerOfTwo(bitmap.getHeight());

//				Debug.print("NPOT");
				//TODO load bitmap with padding instead?.
				bitmap = enlargeBitmap(bitmap,width,height);
			}

			//mipmap level. (http://blog.poweredbytoast.com/loading-opengl-textures-in-android) 
			GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bitmap, 0);

			bitmap.recycle();

			sCropWorkspace[0] = 0;
			sCropWorkspace[1] = bitmap.getHeight();
			sCropWorkspace[2] = bitmap.getWidth();
			sCropWorkspace[3] = -bitmap.getHeight();

			((GL11) gl).glTexParameteriv(GL10.GL_TEXTURE_2D, 
					GL11Ext.GL_TEXTURE_CROP_RECT_OES, sCropWorkspace, 0);

			texture.mTextureHeight = bitmap.getHeight(); //size after resizeing
			texture.mTextureWidth = bitmap.getWidth(); //size after resizeing

			//TODO compare debug.
			texture.mName = textureName;
			if(texture == null)
			{
				Debug.print("texture loading error. texture=null");
			}
		}//end of if.

	}//end of func 

	private static void reloadTexture(Texture textureThatNeedReload) {
		Bitmap bitmap = loadBitmap(textureThatNeedReload.mId);
		loadTexture(bitmap,textureThatNeedReload);
	}//end of func 

	private static void reloadStaticTextTexture(Texture textureThatNeedReload) {
		Text text = new Text(); //TODO only do once?.
		text.setText(textureThatNeedReload.mText);
		Bitmap textBitmap = text.TextToBitmap(textureThatNeedReload.mId);
		loadTexture(textBitmap,textureThatNeedReload);
	}

	/**
	 * Checks if a number is a number power of two 2^x (2^1 2^2 ...)
	 * @param number an integer
	 * @return true if the number is power of two else false
	 */
	private static boolean isToThePowerOfTwo(int number) {
		//		return number == 32 || number == 64 ||number == 16 || number == 128 || 
		//		number == 1 || number == 2 ||number == 4 ||number == 8 || 
		//		number == 16 ||number == 64 ||number == 128 ||
		//		number == 256 ||number == 512 ||number == 1024 ||number == 2048 ||
		//		number == 4096 || number == 8192;
		return ((Math.log((double)number)/Math.log(2.0)) 
				- Math.floor((Math.log((double)number)/Math.log 
						(2.0)))) == 0;
	}

	/**
	 * Finds and returns the nearest LARGER power of two number. if "number" 
	 * already is a in power of two then it does nothing. 
	 * @param number an integer
	 * @return a power of two integer
	 */
	private static int nearestPowerOfTwo(int number)
	{
		return (int) Math.pow(2,Math.ceil(Math.log((double) 
				number)/Math.log(2.0))); 
	}

	/**
	 * Creates a new larger bitmap from an existing bitmap. no scaling involved.
	 * For example useful because opengl takes bitmap in power of two.
	 * @param oldBitmap
	 * @param newWidth
	 * @param newHeight
	 * @return
	 */
	private static Bitmap enlargeBitmap(Bitmap oldBitmap, int newWidth,int newHeight) {
		Bitmap newBitmap;
		Canvas canvas;
		Bitmap.Config config;

		config = Bitmap.Config.ARGB_8888;

//		Debug.print("conf: " + config.name()); 
		newBitmap = Bitmap.createBitmap(newWidth,newHeight,config);

		canvas = new Canvas(newBitmap);  

		//ALT.  set texture cords and use vbo?
		
//		Debug.print("nW: " +newWidth + " oW: " + oldBitmap.getWidth());
//		Debug.print("nH: " +newHeight + " oH: " + oldBitmap.getHeight());
		canvas.drawBitmap(oldBitmap, (newWidth-oldBitmap.getWidth())/2, (newHeight-oldBitmap.getHeight())/2, null); 
		return newBitmap;
	}
}//end of class