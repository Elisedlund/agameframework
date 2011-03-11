package com.agameframework.elis.paperpong;

import javax.microedition.khronos.opengles.GL10;

import com.agameframework.Game;
import com.agameframework.components.ScoreText;
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

		GameNode score1 = new ScoreText(R.drawable.font_arial_black_shadow);
		score1.setXY(score1.getWidth()/2,Game.getCenterY()-score1.getHeight()/2);
		add(score1);

		ScoreText score2 = new ScoreText(R.drawable.font_arial_black_shadow);
		score2.setPlayer(2);
		score2.setXY(score2.getWidth()/2,Game.getCenterY()+score2.getHeight()/2);
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


	//	public void playerOneScore()
	//	{
	//		if(mWinner){return;}
	//		playerOneScore++;
	//		SoundEffectPlayer.play("score");
	//		if(playerOneScore >= 9)
	//		{
	//			mWinner = true;	
	//			remove(mBall);
	//			mBall=null;
	//		}
	//		else
	//		{ 
	//
	//			resetBall();
	//		}
	//	}
	//
	//	public void playerTwoScore()
	//	{
	//		if(mWinner){return;}
	//		playerTwoScore++;
	//		SoundEffectPlayer.play("score");
	//		if(playerTwoScore >= 9)
	//		{
	//			mWinner = true;	
	//			remove(mBall);
	//			mBall=null;
	//		}
	//		else
	//		{
	//			//TODO give serve.
	//			resetBall();
	//		}
	//	}
}// end of class