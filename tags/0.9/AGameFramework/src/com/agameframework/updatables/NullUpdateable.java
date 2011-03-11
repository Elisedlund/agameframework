package com.agameframework.updatables;

import com.agameframework.object.Updatable;


/**
 * an Updateable that don't do anything. Can be used when you have a Updateable 
 * reference that not going to be used temporary 
 * @author Elis
 */
public class NullUpdateable extends Updatable {

	@Override
	public void update() {}

	@Override
	public void init() {}

}
