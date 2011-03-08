package com.agameframework.object;

import com.agameframework.interfaces.IRemovable;
import com.agameframework.interfaces.IUpdatable;

abstract public class Updatable implements IUpdatable , IRemovable{

	protected GameNode mParent;

	public void add(GameNode gamenode)
	{
		gamenode.addUpdateable(this);
	}
	
	@Override
	abstract public void update();
	
	abstract public void init();
	
	public void remove()
	{
		mParent.removeUpdateable(this);
	}

	public Updatable move()
	{
		Updatable obj = this;
		remove();
		return obj;
	}

}
