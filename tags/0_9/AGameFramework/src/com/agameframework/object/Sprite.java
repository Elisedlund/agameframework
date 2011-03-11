package com.agameframework.object;

import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11Ext;

import com.agameframework.interfaces.IRenderable;
import com.agameframework.interfaces.ITexture;
import com.agameframework.text.Text;
import com.agameframework.texture.TextureHandler;

public class Sprite extends State implements IRenderable{

	//	private float mDepth = 0; //TODO MAKE USE OF.
	private ITexture mTexture;

	private Text mText; // Only for dynamic text.


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

	public Sprite(ITexture texture, String text)
	{
		this.mTexture = texture;
		setText(text);
	}

	public Sprite(int resourceID, String text)
	{
		this(TextureHandler.getTexture(resourceID),text);
	}

	@Override
	public void render(GL10 gl) {
		if(mOpacity != 1f)
		{
			gl.glTexEnvx(GL10.GL_TEXTURE_ENV, GL10.GL_TEXTURE_ENV_MODE, GL10.GL_MODULATE);
			gl.glColor4f(1f, 1f, 1f, mOpacity);
		}
		TextureHandler.bindTextureName(mTexture.getTextureName());

		if(mText == null) //if not text.
		{
			//TODO transformations. rot . skew.

			//TODO performance.  fix in rectangle? 
			float x = mCenterX-(mTexture.getTextureWidth()*mScaleX)/2;
			float y = mCenterY-(mTexture.getTextureHeight()*mScaleY)/2;
			((GL11Ext) gl).glDrawTexfOES(x,y, 0, mTexture.getTextureWidth()*mScaleX, mTexture.getTextureHeight()*mScaleY);
		}
		else // if render dynamicText.
		{
			mText.render(gl,mLeft,mBottom,mScaleX,mScaleY);
		}
		gl.glColor4f(1f, 1f, 1f, 1f);
	}

	public void setTexture(ITexture texture) {
		this.mTexture = texture;
		setWidth(texture.getImageWidth());
		setHeight(texture.getImageHeight());
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
		setWidth(mText.getTextWidth());
		setHeight(mText.getTextHeight());
	}

	//	public void setDepth(float mDepth) {
	//		this.mDepth = mDepth;
	//	}
	//
	//	public float getDepth() {
	//		return mDepth;
	//	}

} // end of class
