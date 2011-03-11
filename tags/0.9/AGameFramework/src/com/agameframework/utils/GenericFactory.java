/*
 * Copyright (C) 2010 Elis Edlund.
 */
package com.agameframework.utils;

import com.agameframework.interfaces.ICreateable;


public final class GenericFactory<T> implements ICreateable<T>
{
	private Class<T> mClass;

	public GenericFactory(Class c)
	{
		this.mClass = c;
	}

	public T create()
	{ 
		try {
			return mClass.newInstance();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		return null;
	}
}