package com.agameframework.elis.starwars;

import com.agameframework.object.GameNode;
import com.agameframework.updatables.MovementUpdatable;

public class StarBackground extends GameNode{

	private static int[] resList = {R.drawable.spr_star2,R.drawable.spr_star3};

	public StarBackground(int num)
	{
		GameNode star;
		int res = 0;
		for(int i=1;i<num;i++)
		{
			if(i < num/2)
			{
			res = 0;
			}
			else
			{
			res = 1;
			}
			
			star = new Star(resList[res]);
			add(star);	
			//gravity updatable.
			MovementUpdatable sm = new MovementUpdatable();
			sm.mYMotion= -0.1f * (res+1);
			star.addUpdateable(sm);
		}
	}
}
