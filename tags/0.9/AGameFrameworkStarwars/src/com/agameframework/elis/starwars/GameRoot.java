package com.agameframework.elis.starwars;

import javax.microedition.khronos.opengles.GL10;

import com.agameframework.Game;
import com.agameframework.Loader;
import com.agameframework.components.HighscoreText;
import com.agameframework.components.ScoreText;
import com.agameframework.interfaces.ILoadable;
import com.agameframework.object.GameNode;

/**
 * the root of the game.
 * 
 * @author 
 */
public class GameRoot extends GameNode implements ILoadable{

	protected static GameNode mPlayer;
	private static StarBackground mBackground;
	protected static GameNode mEnemyList = new GameNode();
	protected static GameNode mLaserList = new GameNode();
	
	
	public void load()
	{		
		//Make sure only the correct resources are in the folders OR it will CRASH
		//you can always use the loader to load just specific media.
		Loader.loadTexture(R.drawable.class.getFields()); //load all resources in drawable
		Loader.loadSound(R.raw.class.getFields());//load all resources in raw.
		Loader.loadText("Score:", R.drawable.font_arial_white_light);
		Loader.loadText("Highscore:", R.drawable.font_arial_white_light);
		
		mPlayer = new Player();
		mBackground = new StarBackground(200); 
		add(mBackground);
		add(mPlayer);
		add(new EnemyCreator());
		add(mLaserList);
		add(mEnemyList); 
		addUpdateable(new EnemyLaserCollision());
		
		mPlayer.print("player");
	
		ScoreText scoreText = new ScoreText("Score:", R.drawable.font_arial_white);
		scoreText.setXY(scoreText.getWidth()/2, scoreText.getHeight()/2);
		add(scoreText);
//		scoreText.getNumberNode().addUpdateable(new PulsatingOpacityUpdatable(0.1f,1f));
		
		GameNode highscoreText = new HighscoreText("Highscore:", R.drawable.font_arial_white);
		highscoreText.setXY(highscoreText.getWidth()/2, Game.getHeight() - highscoreText.getHeight()/2);
		add(highscoreText);
	}

	@Override
	public void update()
	{
		super.update();
		//You can add stuff here (not recommended)
	}

	@Override
	public void render(GL10 gl) {
		super.render(gl);
		//You can add stuff here (not recommended) 
	}

}// end of class