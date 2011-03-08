package com.agameframework.texture;

import com.agameframework.debug.Debug;
import com.agameframework.interfaces.ITexture;

public class Texture implements ITexture{
	public int mId;

	public int mName;
	public int mTextureWidth;
	public int mTextureHeight;
	public int mImageHeight;
	public int mImageWidth;
	public String mText;
	
	private boolean mScaled; // to nearest 2^x //TODO use
	
	public void copyFromTexture(ITexture t)
	{
			mName = t.getTextureName();
			mTextureWidth = t.getTextureWidth();
			mTextureHeight = t.getTextureHeight();
			mImageHeight = t.getImageHeight();
			mImageWidth = t.getImageWidth();
			mScaled = t.isScaled();
	}
	
	public void fromTextureID(int id)
	{
		copyFromTexture(TextureHandler.getTexture(id));
	}
	
	public int getTextureName() {
		return mName;
	}

	@Override
	public int getImageHeight() {
		return mImageHeight;
	}

	@Override
	public int getImageWidth() {
		return mImageWidth;
	}

	@Override
	public int getTextureHeight() {
		return mTextureHeight;
	}

	@Override
	public int getTextureWidth() {
		return mTextureWidth;
	}

	@Override
	public void setImageHeight(int iheight) {
		mImageHeight = iheight;
		
	}

	@Override
	public void setImageWidth(int iwidth) {
		mImageWidth = iwidth;
	}


	@Override
	public void setTextureName(int name) {
		mName = name;		
	}
	
	@Override
	public void setTextureHeight(int theight) {
		mTextureHeight = theight;	
	}

	@Override
	public void setTextureWidth(int twidth) {
		mTextureWidth = twidth;
	}

	public void setScaled(boolean mScaled) {
		this.mScaled = mScaled;
	}

	public boolean isScaled() {
		return mScaled;
	}
	
	@Override 
	public String toString()
	{
		return "id: " + mId + " , name: " + mName +" , texW: " + mTextureWidth + " , texH: "
		+ mTextureHeight + " , imgW: " + mImageWidth + " , imgH: " + mImageHeight +" , scaled: " 
		+ mScaled;
	}
	
	public void print(String tag)
	{
		Debug.print(tag +": " + this);
	}
	
}