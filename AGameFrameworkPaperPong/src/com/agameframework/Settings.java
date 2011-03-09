package com.agameframework;

import com.agameframework.elis.paperpong.MenuRoot;
import com.agameframework.interfaces.ISettings;
import com.agameframework.settings.GameSettings;

public class Settings implements ISettings{

	@Override
	public void loadSettings() {

		//Here can you do some general settings with "GameSettings"
		GameSettings.DEBUG_LEVEL1 = true; //enable/disable printing to log.
		GameSettings.SHOW_FPS = true; 
		GameSettings.DEVELOPER_MAIL = "elisedlund@gmail.com";//set an email to enable error reporter.
		
		Game.setClearColor(1f, 1f, 1f);
		MenuRoot game = new MenuRoot(); //Creates the starting GameNode. 
		Game.setLoader(game); //Sets the loader. Dont have to be the same as the GameNode(FirstRoot)
		Game.setGameRoot(game); //Sets the root GameNode
	}

}
