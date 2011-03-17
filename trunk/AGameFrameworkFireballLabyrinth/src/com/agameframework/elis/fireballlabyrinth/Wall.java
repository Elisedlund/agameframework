package com.agameframework.elis.fireballlabyrinth;

import com.agameframework.components.Shadow;
import com.agameframework.object.GameNode;

public class Wall extends GameNode{


	public Wall()
	{
		super(R.drawable.wall);
	}
	
	@Override 
	public void init()
	{
		Shadow shadow = new Shadow();
		shadow.mOpacity = 0.4f;
		shadow.setOffset(4,4);
		add(shadow);
	}


}
