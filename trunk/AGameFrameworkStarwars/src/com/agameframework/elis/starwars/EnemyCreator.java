package com.agameframework.elis.starwars;

import com.agameframework.object.GameNode;

public class EnemyCreator extends GameNode{

	public EnemyCreator()
	{
	}

	public void update()
	{
		super.update();

		if(((int)(Math.random()*60)) == 1)
		{
			GameRoot.mEnemyList.add(new Enemy());
		}
	}
}
