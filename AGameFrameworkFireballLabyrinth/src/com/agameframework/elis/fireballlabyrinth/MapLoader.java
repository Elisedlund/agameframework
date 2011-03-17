/*
 * Copyright (C) 2010 Elis Edlund.
 */
package com.agameframework.elis.fireballlabyrinth;

import com.agameframework.file.FileReaderTxt;
import com.agameframework.object.GameNode;

public class MapLoader<T> extends FileReaderTxt<T> {
	
	@Override
	protected void add(T t,int x,int y)
	{
		((GameNode) t).setX(x*32.0f + 16f);
		((GameNode) t).setY(y*32.0f + 16f);
	}
}
