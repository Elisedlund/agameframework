package com.agameframework.components;

import javax.microedition.khronos.opengles.GL10;

import com.agameframework.object.GameNode;


/**
 *
 * @author Elis - Email: Elisedlund@gmail.com - Date: 11 mar 2011
 */
public abstract class LabeledNumbers extends GameNode{

	protected GameNode mNumbers;


	public LabeledNumbers()
	{
		super();
	}

	public LabeledNumbers(String label) 
	{
		super(label);
	}


	@Override
	public void render(GL10 gl)
	{
		updateNumbers();
		mNumbers.setX(mRight + mNumbers.getWidth()/2);
		mNumbers.setY(getY());
		super.render(gl);
		mNumbers.render(gl);
	}

	public GameNode getNumbers()
	{
		return mNumbers;	
	}
	
	protected abstract void updateNumbers();
}