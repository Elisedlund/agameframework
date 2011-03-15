package com.agameframework.components;

import javax.microedition.khronos.opengles.GL10;

import com.agameframework.object.GameNode;

public class Shadow extends GameNode{

	private float mYOffset = -3f;
	private float mXOffset = 3f;

	public Shadow()
	{}
	
	public void setOffset(float x, float y)
	{
		mXOffset = x;
		mYOffset = y;
	}
	
	public void setOffsetX(float x)
	{
		mXOffset = x;
	}
	
	public void setOffsetY(float y)
	{
		mYOffset = y;
	}
	
	@Override
	public void init()
	{
		setColor (0f,0f,0f); //make black.
	}
	
	@Override
	public void render(GL10 gl)
	{
		//slow but will always work.
		this.setTexture(mParent.getTexture()); 
		this.setScale(mParent.getScaleX(), mParent.getScaleY());
		this.setXY(mParent.getX() + mXOffset, mParent.getY()+mYOffset);
		super.render(gl);
	}
}
