package com.agameframework.interfaces;

public interface ITexture {

	public int getTextureName();
	public int getTextureWidth();
	public int getTextureHeight();
	public int getImageWidth();
	public int getImageHeight();
	public boolean isScaled();
	
	public void setTextureName(int name);
	public void setTextureWidth(int twidth);
	public void setTextureHeight(int theight);
	public void setImageWidth(int iwidth);
	public void setImageHeight(int iheight);
	public void setScaled(boolean scaled);
}
