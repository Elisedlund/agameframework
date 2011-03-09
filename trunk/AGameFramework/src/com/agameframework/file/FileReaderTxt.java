/*
 * Copyright (C) 2010 Elis Edlund.
 */
package com.agameframework.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.agameframework.Game;
import com.agameframework.debug.Debug;
import com.agameframework.interfaces.ICreateable;
import com.agameframework.utils.GenericPair;

public abstract class FileReaderTxt<T> {

	public ArrayList<T> loadFile(String filename,ArrayList<GenericPair<ICreateable<T>,Character>> pairList)
	{
		ArrayList<T> list = new ArrayList<T>();
		BufferedReader inFile = null;
		String line;
		try {
			inFile = new BufferedReader(new InputStreamReader(Game.instance.getAssets().open(filename))); 
			for(int y=0;(line = inFile.readLine())!= null;y++)
			{
				for(int x=0;line.length()>x;x++)
				{
					for (GenericPair<ICreateable<T>,Character> pair : pairList) 
					{
						if(line.charAt(x) == (char) pair.getSecond())
						{
							T t = pair.getFirst().create();
							add(t, x, y);
							list.add(t);
						}
					}
				}
			} 
			inFile.close();
		}
		catch (IOException e) 
		{
			Debug.print("Error opening file");
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<T> loadFile(String filename,GenericPair<ICreateable<T>,Character> pair)
	{
		ArrayList<T> list = new ArrayList<T>();
		BufferedReader inFile = null;
		String line;
		try {
			inFile = new BufferedReader(new InputStreamReader(Game.instance.getAssets().open(filename))); 
			for(int y=0;(line = inFile.readLine())!= null;y++)
			{
				for(int x=0;line.length()>x;x++)
				{
					if(line.charAt(x) == (char) pair.getSecond())
					{
						T t = pair.getFirst().create();
						add(t, x, y);
						list.add(t);
					}
				}
			} 
			inFile.close();
		}
		catch (IOException e) 
		{
			Debug.print("Error opening file");
			e.printStackTrace();
		}
		return list;
	}

	protected void add(T t,int x,int y)
	{
	}

}
