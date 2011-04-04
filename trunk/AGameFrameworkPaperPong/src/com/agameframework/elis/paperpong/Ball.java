package com.agameframework.elis.paperpong;

import com.agameframework.Game;
import com.agameframework.components.MotionBlur;
import com.agameframework.conditions.YLargerThenCondition;
import com.agameframework.conditions.YSmallerThenCondition;
import com.agameframework.event.CompositeEvent;
import com.agameframework.event.ConditionEvent;
import com.agameframework.event.InvertXMotionEvent;
import com.agameframework.event.NullEvent;
import com.agameframework.event.RandomEvent;
import com.agameframework.event.ScoreIncEvent;
import com.agameframework.event.SetPositionEvent;
import com.agameframework.event.SoundAndVibrateEvent;
import com.agameframework.interfaces.ICondition;
import com.agameframework.interfaces.IEvent;
import com.agameframework.object.GameNode;
import com.agameframework.updatables.EventUpdatable;
import com.agameframework.updatables.MovementUpdatable;
import com.agameframework.updatables.StayOnScreenUpdatable;

public class Ball extends GameNode {

	public MovementUpdatable mMovement;
	private final int VIBRATE_LENGHT = 25;
	
	public Ball(int x, int y) 
	{
		super(R.drawable.ball);
		setXY(x,y);	
		setScale(0.8f);
		mMovement = new MovementUpdatable();
		mMovement.setMotion(8, (float)Math.PI/4);
		addUpdateable(mMovement);	


		RandomEvent randomSound = new RandomEvent();
		randomSound.add(new SoundAndVibrateEvent(R.raw.ball_on_table01,VIBRATE_LENGHT));
		randomSound.add(new SoundAndVibrateEvent(R.raw.ball_on_table02,VIBRATE_LENGHT));
		randomSound.add(new SoundAndVibrateEvent(R.raw.ball_on_table03,VIBRATE_LENGHT));
		randomSound.add(new SoundAndVibrateEvent(R.raw.ball_on_table04,VIBRATE_LENGHT));

		CompositeEvent soundandbounce = new CompositeEvent(
				new InvertXMotionEvent(mMovement),randomSound);

		StayOnScreenUpdatable stay = new StayOnScreenUpdatable(
				soundandbounce, new NullEvent());
		stay.setActive(true, false, true, false);
		addUpdateable(stay);
		
		CompositeEvent soundAndReset = new CompositeEvent();
		soundAndReset.add(new SetPositionEvent(this, Game.getCenterX(), Game.getCenterY()));
		soundAndReset.add(new SoundAndVibrateEvent(R.raw.pong,50));
		
		//player one score
		ICondition p1score = new YLargerThenCondition(this,Game.getHeight()+this.getWidth()/2);
		IEvent score1 = new ScoreIncEvent(1);
		ConditionEvent condEvent = new ConditionEvent(new CompositeEvent(soundAndReset,score1),p1score);
		addUpdateable(new EventUpdatable(condEvent));

		//player two score
		ICondition p2score = new YSmallerThenCondition(this,0-this.getWidth()/2);
		IEvent score2 = new ScoreIncEvent(1,2);
		ConditionEvent condEvent2 = new ConditionEvent(new CompositeEvent(soundAndReset,score2),p2score);
		addUpdateable(new EventUpdatable(condEvent2));

	
		add(new MotionBlur(-0.8f, 0.01f));
	

	}	
}
