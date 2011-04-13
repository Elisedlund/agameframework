package com.agameframework.elis.mines;

import java.util.ArrayList;

import android.view.MotionEvent;

import com.agameframework.Game;
import com.agameframework.Loader;
import com.agameframework.debug.Debug;
import com.agameframework.input.GameInput;
import com.agameframework.input.TouchUpListener;
import com.agameframework.interfaces.ILoadable;
import com.agameframework.object.GameNode;

/**
 * the root of the game.
 * @author 
 */
public class GameRoot extends GameNode implements ILoadable, TouchUpListener{

	private Button[][] mButtons; 
	private int mHeight = 10;
	private int mWidth = 10;
	private int mMineCount = 16;
	private boolean lost = false; 

	/**
	 * Load textures and sounds here. you should also static text textures here 
	 */
	public void load()
	{
		//lazy loading just loads everything .Make sure only the 
		//correct resources are in the folders OR it will CRASH
		Loader.loadTexture(R.drawable.class.getFields()); //load all resources in drawable
		Loader.loadSound(R.raw.class.getFields());//load all resources in raw.
		//you can always use the loader to load just specific media. if your not lazy.
	}//end of load()

	@Override
	public void init()
	{
		createNewLevel();
		GameInput.addTouchUpListner(this);
	}

	@Override
	public void remove()
	{
		GameInput.removeTouchUpListner(this);
	}

	private void createNewLevel()
	{

		this.removeAll(Button.class);
		this.update();
		ArrayList<Button> list = this.findAll(Button.class);
		Debug.print("l:" + list);
		

		mButtons = new Button[mWidth][mHeight];
		createButtons();
		placeMines(mMineCount);
		countAllButtons();
	}

	private void createButtons()
	{
		for(int i=0; i<mWidth ;i++)
		{
			for(int j=0; j<mHeight ;j++)
			{
				Button temp = new Button();
				add(temp);
				temp.setXY(16+i*32,16+j*32);
				mButtons[i][j]=temp;
			}
		}
	}

	private void placeMines(int numberOfMines)
	{
		for(int i=0; i<numberOfMines ;i++)
		{
			int randX = (int)(Math.random()*mWidth);
			int randY = (int)(Math.random()*mHeight);
			if (!mButtons[randX][randY].isMine())
			{
				mButtons[randX][randY].setMine(true);
			}
			else
			{
				i--;//did not find;
			}
		}
	}

	private int countButton(int x, int y)
	{
		int count=0;
		if(isInsideButtons(x-1,y-1) && mButtons[x-1][y-1].isMine())
		{
			count++;
		}
		if(isInsideButtons(x-1,y) && mButtons[x-1][y].isMine())
		{
			count++;
		}
		if(isInsideButtons(x-1,y+1) && mButtons[x-1][y+1].isMine())
		{
			count++;
		} 
		if(isInsideButtons(x,y-1) && mButtons[x][y-1].isMine())
		{
			count++;
		}
		if(isInsideButtons(x,y+1) && mButtons[x][y+1].isMine())
		{
			count++;
		}
		if(isInsideButtons(x+1,y-1) && mButtons[x+1][y-1].isMine())
		{
			count++;
		}
		if(isInsideButtons(x+1,y) && mButtons[x+1][y].isMine())
		{
			count++;
		}
		if(isInsideButtons(x+1,y+1) && mButtons[x+1][y+1].isMine())
		{
			count++;
		}
		return count;
	}

	private void countAllButtons()
	{
		for(int i=0; i<mWidth ;i++)
		{
			for(int j=0;j<mHeight;j++)
			{
				mButtons[i][j].setValue(countButton(i,j));
			}	
		}
	}



	private boolean isInsideButtons(int x,int y)
	{	
		return (x >= 0 && y >=0 && x < mWidth && y < mHeight);
	}

	private void openZeroButtons(int x,int y)
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if (isInsideButtons(x-1+i,y-1+j))
				{
					if(mButtons[x-1+i][y-1+j].getValue()==0 && !(x-1+i==x && y-1+j==y) && !mButtons[x-1+i][y-1+j].isShow())
					{
						openZeroButtons(x-1+i,y-1+j);
					}
					mButtons[x-1+i][y-1+j].setShow(true);	
				}
			}
		}
	}

	private void showAll()
	{
		for(int i=0;i<mWidth;i++)
		{
			for(int j=0;j<mHeight;j++)
			{
				mButtons[i][j].setShow(true);
			}
		}
	}

	@Override
	public void touchUp(MotionEvent event) {
		int x = (int) (event.getX() / 32.0f);
		int y = (int) (Math.abs(event.getY()-Game.getHeight()) / 32.0f);
//		Debug.print("t: "+ event.getX() +"," +event.getY() +"  index:" + x +"," +y );
		if (lost)
		{
			lost = false;
			createNewLevel();
			return;
		}
		if (!mButtons[x][y].getFlag())
		{
			if (mButtons[x][y].getValue()==0 && !mButtons[x][y].isMine() && !mButtons[x][y].isShow())
			{
				openZeroButtons(x,y);
			}
			mButtons[x][y].setShow(true);
			if(mButtons[x][y].isMine())
			{
				showAll();
				lost=true;
			}
		}

	}

}// end of class