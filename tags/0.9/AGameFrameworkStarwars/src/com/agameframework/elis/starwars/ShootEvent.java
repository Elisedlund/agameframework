package com.agameframework.elis.starwars;

import com.agameframework.interfaces.IEvent;
import com.agameframework.object.GameNode;

public class ShootEvent implements IEvent{

	private final Player mPlayer;

	public ShootEvent(Player player) {
		this.mPlayer = player;
	}

	@Override
	public void invokeEvent() {
		GameNode laser = new Laser(mPlayer);
		GameRoot.mLaserList.add(laser);
	}

}
