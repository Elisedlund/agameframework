package com.agameframework.elis.starwars;

import javax.microedition.khronos.opengles.GL10;

import com.agameframework.Game;
import com.agameframework.Loader;
import com.agameframework.components.HealthText;
import com.agameframework.components.HighscoreText;
import com.agameframework.components.ScoreText;
import com.agameframework.interfaces.ILoadable;
import com.agameframework.object.GameNode;
import com.agameframework.settings.GameSettings;

/**
 * the root of the game.
 * 
 * @author 
 */
public class GameRoot extends GameNode implements ILoadable{

	protected static GameNode mPlayer;
	protected static GameNode mEnemyList;
	protected static GameNode mLaserList;
	
	private StarBackground mBackground;
	
	private String scoreString = Game.string(R.string.score);
	private String highscoreString = Game.string(R.string.highscore);
	private String healthString = Game.string(R.string.health);
	public void load()
	{		
		//Make sure only the correct resources are in the folders OR it will CRASH
		//you can always use the loader to load just specific media.
		Loader.loadTexture(R.drawable.class.getFields()); //load all resources in drawable
		Loader.loadSound(R.raw.class.getFields());//load all resources in raw.
		Loader.loadText(scoreString, R.drawable.font_arial_white_light);
		Loader.loadText(highscoreString, R.drawable.font_arial_white_light);
		Loader.loadText(healthString, R.drawable.font_arial_white_light);

	}
	
	public void init()
	{
		mEnemyList = new GameNode();
		mLaserList = new GameNode();
		
		mPlayer = new Player();
		mBackground = new StarBackground(200); 
		add(mBackground);
		add(mLaserList);
		add(mPlayer);
		add(mEnemyList); 
		add(new EnemyCreator());
		addUpdateable(new EnemyLaserCollision());
		
		mPlayer.print("player");
	
		ScoreText scoreText = new ScoreText(scoreString, R.drawable.font_arial_white);
		scoreText.setXY(scoreText.getWidth()/2, scoreText.getHeight()/2);
		add(scoreText);
		
		GameNode highscoreText = new HighscoreText(highscoreString, R.drawable.font_arial_white);
		highscoreText.setXY(highscoreText.getWidth()/2, Game.getHeight() - highscoreText.getHeight()/2);
		add(highscoreText);
		
		GameSettings.setHealth(100);
		HealthText healthText = new HealthText(healthString, R.drawable.font_arial_white);
		healthText.setXY(
				Game.getWidth() - (healthText.getWidth()/2 + healthText.getNumbers().getWidth()),
				healthText.getHeight()/2);
		add(healthText);
		
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