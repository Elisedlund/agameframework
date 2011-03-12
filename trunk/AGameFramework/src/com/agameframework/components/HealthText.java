package com.agameframework.components;

import com.agameframework.object.GameNode;
import com.agameframework.settings.GameSettings;


/**
 *
 * @author Elis - Email: Elisedlund@gmail.com - Date: 11 mar 2011
 */
public class HealthText extends LabeledNumbers{


	private int lastHealth = GameSettings.getHealth();

	public HealthText(int fontResourceID) {
		super();
		mNumbers = new GameNode(GameSettings.getHealthString(),fontResourceID);
	}

	public HealthText(String label, int fontResourceID) {
		super(label);
		mNumbers = new GameNode(GameSettings.getHealthString(),fontResourceID);
	}

	protected void updateNumbers()
	{ 
		if (lastHealth != GameSettings.getHealth())
		{
			//TODO event on health change.
			mNumbers.setText(GameSettings.getHealthString());
			lastHealth = GameSettings.getHealth();
		}
	}
}