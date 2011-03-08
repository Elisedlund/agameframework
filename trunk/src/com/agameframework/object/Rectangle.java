/*
 * Copyright (C) 2010 Elis Edlund.
 */
package com.agameframework.object;

import com.agameframework.debug.Debug;


public class Rectangle{

	protected float mWidth = 0;
	protected float mHeight = 0;
	protected float mCenterX = 0;
	protected float mCenterY = 0;
	protected float mLeft;
	protected float mTop;
	protected float mRight;
	protected float mBottom;
	protected float mScaleX = 1.0f;
	protected float mScaleY = 1.0f;


	public Rectangle(){}



	/**
	 * Creates a new rectangle. Note: no range
	 * checking is performed, so the caller must ensure that left <= right and
	 * top >= bottom.
	 *
	 * @param left   The X coordinate of the left side of the rectangle
	 * @param top    The Y coordinate of the top of the rectangle
	 * @param right  The X coordinate of the right side of the rectangle
	 * @param bottom The Y coordinate of the bottom of the rectangle
	 */
	public Rectangle(float left, float bottom, float right, float top) {
		this.mLeft = left;
		this.mTop = top;
		this.mRight = right;
		this.mBottom = bottom;
	}

	public void setXY(float x,float y) {
		setX(x);
		setY(y);
	}

	public void setX(float x) {
		mCenterX = x;
		mLeft = x - mWidth*0.5f;
		mRight = x + mWidth*0.5f;
	}

	public void setY(float y) {
		mCenterY = y;
		mTop = y + mHeight*0.5f;
		mBottom = y - mHeight*0.5f;
	}
	public final void incX(float x) { 
		mLeft += x;
		mRight += x;
		mCenterX += x;
	}

	public final void decX(float x){
		mLeft -= x;
		mRight -= x;
		mCenterX -= x;
	}

	public final void incY(float y) {
		mTop += y;
		mBottom += y;
		mCenterY += y;	
	}

	public final void decY(float y) {
		mTop -= y;
		mBottom -= y;
		mCenterY -= y;
	}

	public final float getX() {		
		return mCenterX;
	}

	public final float getY() {
		return mCenterY;
	}

	public final void setHeight(float height) {
		this.mHeight = height;
		mTop = mCenterY + height*0.5f;
		mBottom = mCenterY - height*0.5f;
	}

	public final void setWidth(float width) {	
		this.mWidth = width;
		mLeft = mCenterX - width*0.5f;
		mRight = mCenterX + width*0.5f;
	}

	public float getWidth() {
		return mWidth;
	}

	public float getHeight() {
		return mHeight;
	}

	public void setScale(float scale)
	{
		setWidth(mWidth*(scale/mScaleX));
		setHeight(mHeight*(scale/mScaleY));
		mScaleX=scale;
		mScaleY=scale;
	}

	public void setScale(float scaleX, float scaleY)
	{
		setWidth(mWidth*(scaleX/mScaleX));
		setHeight(mHeight*(scaleY/mScaleY));
		mScaleX=scaleX;
		mScaleY=scaleY;
	}

	public final void incScale(float inc)
	{
		setScale(mScaleX+inc,mScaleY+inc);
	}

	/** 
	 * Checks if there is a collision between two rectangles.
	 * have to check this before you do more precise tests like direction tests
	 * @param rect1
	 * @param rect2
	 * @return true if there is a collision.
	 */
	public static boolean isCollision(Rectangle rect1, Rectangle rect2)
	{
		return rect1.mTop > rect2.mBottom && rect2.mTop > rect1.mBottom 
		&& rect1.mLeft < rect2.mRight && rect2.mLeft < rect1.mRight;

		//		return rect1.top < rect2.bottom && rect2.top < rect1.bottom 
		//		&& rect1.left < rect2.right && rect2.left < rect1.right;
	}

	/** 
	 * Checks if the point (xpos,ypos) is inside the rectangle.
	 * @param xpos
	 * @param ypos
	 * @return true if point is in rectangle.
	 */
	public boolean isInside(float xpos, float ypos)
	{
		return this.mTop > ypos && ypos > this.mBottom 
		&& this.mLeft < xpos && xpos < this.mRight;
	}


	/** 
	 * Checks if there is a collision between two rectangles.
	 * have to check this before you do more precise tests like direction tests
	 * @param rect2
	 * @return true if there is a collision.
	 */
	public boolean isCollision(Rectangle rect2)
	{
		return this.mTop > rect2.mBottom && rect2.mTop > this.mBottom 
		&& this.mLeft < rect2.mRight && rect2.mLeft < this.mRight;
		//		return this.top < rect2.bottom && rect2.top < this.bottom 
		//		&& this.left < rect2.right && rect2.left < this.right;
	}


	@Override 
	public String toString()
	{
		return "left: " + mLeft + " , right: " +mRight +" , top: " + mTop + " , bottom: "
		+ mBottom + " , centerX: " + mCenterX + " , centerY: " + mCenterY +" , width: " 
		+ mWidth + " , Height: " + mHeight + " , ScaleX: "  + mScaleX+ " , ScaleY: "  + mScaleY;
	}

	public float getRandomX() {
		return mLeft +(float)(Math.random()* mWidth);
	}
	public float getRandomY() {
		return mBottom +(float)(Math.random()* mHeight);
	}

	public float getScaleX() {
		return mScaleX;
	}

	public float getScaleY() {
		return mScaleY;
	}

	public void print(String tag)
	{
		Debug.print(tag +": " + this);
	}
}