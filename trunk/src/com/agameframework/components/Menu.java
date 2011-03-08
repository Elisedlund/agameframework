package com.agameframework.components;

import java.util.ArrayList;

import com.agameframework.Game;
import com.agameframework.Updatables.GrowShrinkToUpdatable;
import com.agameframework.event.AddUpdatableEvent;
import com.agameframework.event.CompositeEvent;
import com.agameframework.input.components.DoEventOnTouchMove;
import com.agameframework.input.components.DoEventOnTouchUp;
import com.agameframework.interfaces.IEvent;
import com.agameframework.object.GameNode;
import com.agameframework.object.Updatable;


public class Menu extends GameNode{

	private ArrayList<GameNode> mList = new ArrayList<GameNode>();
	private int lineSpace = 0;


	public Menu(String[] strings,IEvent[] events, IEvent pressEvent)
	{
		int size = strings.length;
		for(int i=0; i<size ;i++)
		{
			add(strings[i],new CompositeEvent(events[i],pressEvent));
		}
		setXY(Game.getCenterX(),Game.getCenterY());
	}

	public Menu(String[] strings,IEvent[] events)
	{
		int size = strings.length;
		for(int i=0; i<size ;i++)
		{
			add(strings[i],events[i]);
		}
		setXY(Game.getCenterX(),Game.getCenterY());
	}



	public void add(String str, IEvent event)
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
			GameNode node = mList.get(i);
			float scale = node.getScaleX();
			float speed = scale/100;
			Updatable shrink = new GrowShrinkToUpdatable(-speed,-0.5f);
			IEvent addShrink = new AddUpdatableEvent(shrink,node);
			Updatable grow = new GrowShrinkToUpdatable(addShrink,speed, 0.5f);
			IEvent addGrow = new AddUpdatableEvent(grow,node);
			DoEventOnTouchMove.add(node,addGrow);
		}
	}

	@Override 
	public void setXY(float x,float y)
	{
		setX(x);
		setY(y);
	}	
}