/*
 * Copyright (C) 2010 Elis Edlund.
 */
package com.agameframework.utils;

public final class GenericPair<F, S>
{
	private final F first;
	private final S second;
	
	public GenericPair(F f, S s)
	{ 
		first = f;
		second = s;   
	}

	public F getFirst()
	{
		return first;
	}

	public S getSecond()   
	{
		return second;
	}

	public String toString()  
	{ 
		return "(" + first.toString() + ", " + second.toString() + ")"; 
	}
}
