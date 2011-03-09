/*
 * Copyright (C) 2010 Elis Edlund.
 */
package com.agameframework.utils;

import com.agameframework.interfaces.ICloneable;
import com.agameframework.interfaces.ICreateable;


public final class GenericPrototype<T> implements ICreateable<T> , ICloneable<T>
{
	private ICloneable<T> mPrototype;

	public GenericPrototype(ICloneable<T> p)
	{
		this.mPrototype = p;
	}
	
	public T clone()
	{ 
		return mPrototype.clone();
	}	
	
	/**
	 * does the same as clone.
	 * @return
	 */
	public T create()
	{
		return mPrototype.clone();
	}	
}