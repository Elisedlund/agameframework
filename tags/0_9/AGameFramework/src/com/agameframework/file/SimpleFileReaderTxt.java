package com.agameframework.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.agameframework.Game;
import com.agameframework.debug.Debug;

public abstract class SimpleFileReaderTxt {

	public void loadFile(String filename)
	{
		BufferedReader inFile = null;
		String line;
		try {
			inFile = new BufferedReader(new InputStreamReader(Game.instance.getAssets().open(filename))); 
			for(int y=0;(line = inFile.readLine())!= null;y++)
			{
				for(int x=0;line.length()>x;x++)
				{
					add(line.charAt(x),x,y);	
				}
			} 
			inFile.close();
		}
		catch (IOException e) 
		{
			Debug.warning("Error opening file");
			e.printStackTrace();
		}
	}
	
	protected void add(char charAt, int x, int y) 
	{

	}
}
