package com.agameframework;

import com.agameframework.YOURNAME.YOURGAME.GameRoot;
import com.agameframework.interfaces.ISettings;
import com.agameframework.settings.GameSettings;

public class Settings implements ISettings{

	@Override
	public void loadSettings() {

		//Here can you do some general settings with "GameSettings"
		GameSettings.DEBUG_LEVEL1 = true; //enable printing to log.
		GameSettings.SHOW_FPS = true;//show possible updates per second.
		GameSettings.DEVELOPER_MAIL = "elisedlund@gmail.com";//set an email to enable error reporter.

		
		GameRoot game = new GameRoot(); //Creates the starting GameNode. 
		Game.setLoader(game); //Sets the loader. Dont have to be the same as the GameNode(GameRoot)
		Game.setGameRoot(game); //Sets the root GameNode
	}

}
