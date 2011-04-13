package com.agameframework.elis.mines;

import com.agameframework.debug.Debug;
import com.agameframework.object.GameNode;

public class Button extends GameNode{

	private int mValue = 0;
	private boolean mShow = false;
	private boolean mMine = false;
	private boolean mFlag = false;


	public Button()
	{
		super(R.drawable.closed);
	}

	//	private void setValueColor()
	//	{	
	//		if(mValue==1)
	//		{
	//			g.setColor(Color.BLUE);	
	//		}
	//		if(mValue==2)
	//		{
	//			g.setColor(Color.GREEN.darker());	
	//		}
	//		if(mValue==3)
	//		{
	//			g.setColor(Color.RED);	
	//		}
	//		if(mValue==4)
	//		{
	//			g.setColor(Color.BLUE.darker().darker().darker());	
	//		}
	//		if(mValue==5)
	//		{
	//			g.setColor(Color.RED.darker().darker().darker());	
	//		}
	//	}

	public void toggleFlag() 
	{
		mFlag =! mFlag;	
	}

	public boolean getFlag()
	{
		return mFlag;
	}

	public boolean isMine() {
		return mMine;
	}

	public void setMine(boolean mine) {
		this.mMine = mine;
	}

	public int getValue() {
		return mValue;
	}


	public void setValue(int value) {
		this.mValue = value;
	}

	public boolean isShow() {
		return mShow;
	}

	public void setShow(boolean show) {
		this.mShow = show;
		if(mMine)
		{
			setTexture(R.drawable.mine);
		}
		else if(mValue>0)//if number
		{

			setTexture(R.drawable.font_arial_white);
			this.setText(""+mValue);
			this.setRandomColor();
			GameNode back = new GameNode(R.drawable.empty);
			back.setXY(this.getX(),this.getY());
			add(back);
			Debug.print("added nr");
		}
		else
		{
			setTexture(R.drawable.empty);
		}
	}

}//end of class