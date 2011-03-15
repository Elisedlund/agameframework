package com.agameframework.elis.paperpong;

import javax.microedition.khronos.opengles.GL10;

import com.agameframework.Game;
import com.agameframework.components.LabeledNumbers;
import com.agameframework.components.ScoreText;
import com.agameframework.components.Shadow;
import com.agameframework.debug.Debug;
import com.agameframework.object.GameNode;

/**
 * the root of the game.
 * @author 
 */
public class GameRoot extends GameNode{

	private static final int paddleoffset=30;


	@Override 
	public void init()
	{
		Ball ball = new Ball(Game.getCenterX(),Game.getCenterY());
		add(ball);

		Paddle aIPaddle = new Paddle(Game.getCenterX(),Game.getHeight()-paddleoffset);
		aIPaddle.addUpdateable(new PaddleAIMovement(aIPaddle,ball));
		aIPaddle.addUpdateable(new PaddleBallCollision(ball,aIPaddle));
		add(aIPaddle); 

		Paddle playerPaddle = new Paddle(Game.getCenterX(),paddleoffset);
		PaddlePlayerMovement.add(playerPaddle);
		playerPaddle.addUpdateable(new PaddleBallCollision(ball,playerPaddle));
		add(playerPaddle);
	

		ScoreText score1 = new ScoreText(R.drawable.font_arial_white);
		score1.getNumbers().setColor(64/255f, 64/255f, 64/255f);
		score1.setXY(score1.getNumbers().getWidth()/2,Game.getCenterY()-score1.getNumbers().getHeight()/2);
		add(score1);

		ScoreText score2 = new ScoreText(R.drawable.font_arial_white);
		score2.getNumbers().setColor(64/255f, 64/255f, 64/255f);
		score2.setPlayer(2);
//		Debug.print("h:" + score2.getHeight() +" w: " +score2.getWidth());
		score2.setXY(score2.getNumbers().getWidth()/2,Game.getCenterY()+score2.getNumbers().getHeight()/2);
		add(score2);

	}



	@Override
	public void update()
	{
		super.update();
		//You can add stuff here but don't have to (not recommended)
	}

	@Override
	public void render(GL10 gl) {
		super.render(gl);
		//You can add stuff here but don't have to (not recommended)
	}

}// end of class