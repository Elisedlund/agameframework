package com.agameframework.components;

import java.util.ArrayList;

import com.agameframework.Game;
import com.agameframework.event.CompositeEvent;
import com.agameframework.input.components.DoEventOnTouchUp;
import com.agameframework.interfaces.IEvent;
import com.agameframework.object.GameNode;
import com.agameframework.updatables.RainbowUpdatable;


public class Menu extends GameNode{

	private ArrayList<GameNode> mList = new ArrayList<GameNode>();
	private int lineSpace = 0;


	public Menu(String[] strings,IEvent[] events, IEvent pressEvent)
	{
		int size = strings.length;
		for(int i=0; i<size ;i++)
		{
			addMenuItem(strings[i],new CompositeEvent(events[i],pressEvent));
		}
		setXY(Game.getCenterX(),Game.getCenterY());
	}

	public Menu(String[] strings,IEvent[] events)
	{
		int size = strings.length;
		for(int i=0; i<size ;i++)
		{
			addMenuItem(strings[i],events[i]);
		}
		setXY(Game.getCenterX(),Game.getCenterY());
	}



	public void addMenuItem(String str, IEvent event)
	{

		GameNode node = new GameNode(str);
		DoEventOnTouchUp.add(node,event);
		mList.add(node);
		add(node);
	}

	public void setLineSpace(int space)
	{
		lineSpace = space;
		setXY(getX(),getY());
	}

	@Override 
	public void setScale(float x,float y)
	{
		super.setScale(x,y);//not really needed.

		int size = mList.size();
		for(int i=0;i<size;i++)
		{
			GameNode node = mList.get(i);
			node.setScale(x,y);
		}
		setXY(getX(),getY());
	}

	@Override 
	public void setScale(float scale)
	{
		this.setScale(scale, scale);
	}


	@Override 
	public void setX(float x)
	{
		super.setX(x);
		int size = mList.size();
		for(int i=0;i<size;i++)
		{
			GameNode node = mList.get(i);
			node.setX(x);
		}

	}
	@Override 
	public void setY(float y)
	{
		super.setY(y);

		int size = mList.size();
		for(int i=0;i<size;i++)
		{
			GameNode node = mList.get(i);
			//TODO fix linespace. size-1*linespace.
			node.setY(
					y + (size*(node.getHeight()+lineSpace))/2
					- ((i+0.5f)*(node.getHeight()+lineSpace)));
		}
	}

	public void effectGrow()
	{
		int size = mList.size();
		for(int i=0;i<size;i++)
		{
			mList.get(i).add(new GrowOnTouchEffect());
		}
	}
	
	public void effectRainbow()
	{
		int size = mList.size();
		for(int i=0;i<size;i++)
		{
			mList.get(i).addUpdateable(new RainbowUpdatable(i/10f));
		}
	}
	
	public void setColor(float red, float green, float blue)
	{
		int size = mList.size();
		for(int i=0;i<size;i++)
		{
			mList.get(i).setColor(red, green, blue);
		}
	}
	
	public void setShadow(float opacity,float offsetX,float offsetY)
	{
		int size = mList.size();
		for(int i=0;i<size;i++)
		{
			
			Shadow shadow = new Shadow();
			shadow.mOpacity = opacity;
			shadow.setOffset(offsetX, offsetY);
			mList.get(i).add(shadow); 
		}
	}
	
	
	public ArrayList<GameNode> getList()
	{
		return mList;
	}


	@Override 
	public void setXY(float x,float y)
	{
		setX(x);
		setY(y);
	}	
}