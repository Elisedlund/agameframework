package com.agameframework.elis.firstgame;

import com.agameframework.Game;
import com.agameframework.components.HighscoreText;
import com.agameframework.components.LabeledNumbers;
import com.agameframework.components.MotionBlur;
import com.agameframework.components.ScoreText;
import com.agameframework.event.ChangeStateEvent;
import com.agameframework.event.CompositeEvent;
import com.agameframework.event.InvertXMotionEvent;
import com.agameframework.event.InvertYMotionEvent;
import com.agameframework.event.ScoreIncEvent;
import com.agameframework.event.SoundAndVibrateEvent;
import com.agameframework.input.components.DoEventOnTouchDown;
import com.agameframework.interfaces.IEvent;
import com.agameframework.object.GameNode;
import com.agameframework.updatables.MovementUpdatable;
import com.agameframework.updatables.StayOnScreenUpdatable;

/**
 * the root of the game.
 * @author 
 */
public class GameRoot extends GameNode{

	
	private static String scoreLabel = Game.string(R.string.label_score);
	private static String highscoreLabel = Game.string(R.string.label_highscore);
	@Override
	public void init()
	{
		//add highscore
		GameNode highscore = new HighscoreText(highscoreLabel, R.drawable.font_arial_white);
		highscore.setXY(highscore.getWidth()/2, Game.getHeight() - highscore.getHeight()/2);
		add(highscore);

		//add score
		LabeledNumbers score = new ScoreText(scoreLabel, R.drawable.font_arial_white);
		score.setXY(Game.getCenterX(), Game.getCenterY());
		score.setScale(2f);
		score.getNumbers().setScale(2f);
		MovementUpdatable mu = new MovementUpdatable();
		mu.mXMotion = 5;
		mu.mYMotion = 5;
		score.addUpdateable(mu);
		score.addUpdateable(new StayOnScreenUpdatable(
				new InvertXMotionEvent(mu),
				new InvertYMotionEvent(mu)));	
		score.add(new MotionBlur(-0.7f, 0.05f));
		add(score);
		
		//pressing for scoring.
		IEvent sound = new SoundAndVibrateEvent(R.raw.snd_poing, 50);
		IEvent scoreEvent = new ScoreIncEvent(1);
		IEvent tot = new CompositeEvent(sound,scoreEvent);
		DoEventOnTouchDown.add(score,tot);

		//game time.
		IEvent changeState = new ChangeStateEvent(new RestartRoot());
		Game.addTimedEvent(changeState, 20*1000);
		
	}
	
	
}// end of class