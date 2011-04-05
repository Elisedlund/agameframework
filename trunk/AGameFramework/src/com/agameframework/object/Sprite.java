package com.agameframework.object;

import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11Ext;

import com.agameframework.interfaces.IRenderable;
import com.agameframework.interfaces.ITexture;
import com.agameframework.text.Text;
import com.agameframework.texture.TextureHandler;

public class Sprite extends Rectangle implements IRenderable{

	private ITexture mTexture;
	private Text mText; // Only for dynamic text.

	//	public float mRotationZ; //TODO use

	public float mOpacity = 1f;
	private float mRed = 1f;
	private float mGreen = 1f;
	private float mBlue = 1f;
//	private boolean mColorChange = false;

	private boolean mMirrorX = false;
	private boolean mMirrorY = false;


	public Sprite()
	{
		super();
	}

	public Sprite(ITexture tex) {
		super();
		setTexture(tex);
	}

	public Sprite(String text) {
		this(TextureHandler.getTexture(text));
	}

	public Sprite(String text,ITexture texture)
	{
		super();
		this.mTexture = texture;
		setText(text);
	}


	@Override
	public void render(GL10 gl) {

		//TODO only if mRed, mGreen, mBlue, mOpacity have changed form 1? '
		//TODO do a preformance test.


		//			gl.glTexEnvx(GL10.GL_TEXTURE_ENV, GL10.GL_TEXTURE_ENV_MODE, GL10.GL_MODULATE);
		gl.glColor4f(mRed, mGreen, mBlue, mOpacity);


		TextureHandler.bindTextureName(mTexture.getTextureName());

		if(mText != null) //if text.
		{
			mText.render(gl,mLeft,mBottom,mScaleX,mScaleY);
			return;
		}
		//if not text.

		float width = mTexture.getTextureWidth()*mScaleX;
		float height = mTexture.getTextureHeight()*mScaleY;
		float x = mCenterX-(width)/2;
		float y = mCenterY-(height)/2;
		((GL11Ext) gl).glDrawTexfOES(x,y, 0, width, height);
	}

	public void setTexture(ITexture texture) {
		this.mTexture = texture;

		setWidth(texture.getImageWidth() * mScaleX);
		setHeight(texture.getImageHeight() * mScaleY);
	}

	public void setTexture(int resourceID)
	{
		setTexture(TextureHandler.getTexture(resourceID));
	}

	public void setTexture(String text)
	{
		setTexture(TextureHandler.getTexture(text));
	}

	public ITexture getTexture() {
		return mTexture;
	}

	public void setText(String text)
	{
		mText = new Text();
		mText.setText(text);
		//		Debug.print("scale: " +mScaleX +" , " + mScaleY+ " : height:" +  mText.getTextHeight()+"set: " + (mText.getTextHeight() * mScaleY));
		setWidth(mText.getTextWidth() * mScaleX);
		setHeight(mText.getTextHeight() * mScaleY);
	}

	public void setColor(float red, float green, float blue)
	{
		mRed = red;
		mGreen = green;
		mBlue = blue;
//		mColorChange=true;
	}

	public void setRed(float red)
	{
		mRed = red;
//		mColorChange=true;
	}

	public void setGreen(float green)
	{
		mGreen = green;
//		mColorChange=true;
	}

	public void setBlue(float blue)
	{
		mBlue = blue;
//		mColorChange=true;
	}

	public void incRed(float red)
	{
		mRed += red;
//		mColorChange=true;
	}

	public void incGreen(float green)
	{
		mGreen += green;
//		mColorChange=true;
	}

	public void incBlue(float blue)
	{
		mBlue += blue;
//		mColorChange=true;
	}


	public void setRandomColor()
	{
		mRed = (float) Math.random();
		mGreen = (float) Math.random();
		mBlue = (float) Math.random();
//		mColorChange=true;
	}

} // end of class
