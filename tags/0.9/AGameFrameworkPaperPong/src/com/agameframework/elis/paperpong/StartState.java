//package com.agameframework.elis.paperpong;
//
//import javax.microedition.khronos.opengles.GL10;
//
//import android.view.MotionEvent;
//
//import com.agameframework.Game;
//import com.agameframework.YOURNAME.YOURGAME.R;
//import com.agameframework.debug.Debug;
//import com.agameframework.input.GameInput;
//import com.agameframework.input.TouchUpListener;
//import com.agameframework.interfaces.ILoadable;
//import com.agameframework.object.GameNode;
//import com.agameframework.object.Updatable;
//import com.agameframework.settings.GameSettings;
//import com.agameframework.sound.SoundEffectPlayer;
//import com.agameframework.texture.Texture;
//import com.agameframework.texture.TextureHandler;
//
////16%
////TODO fix screen orientation. flip score ect.
////TODO serve.
///**
// * a state where you play the game.
// * 
// * @author Elis
// * 
// */
//public class StartState extends GameNode implements ILoadable , TouchUpListener{
//
//
////	private GameNode mList = new GameNode();
////	private GradientDrawable grad;
//	private int playerOneScore = 0;
//	private int playerTwoScore = 0;
//
//	private Ball mBall;
//	private boolean mWinner = false;
//
//	private boolean mSwapinput = true;
//	private PaddleAIMovement mAIMovement;
//	private PaddlePlayerMovement mPlayerMovement;
//	private Paddle mPlayerPaddle;
//	private Paddle mAIPaddle;
//
//
//	@Override
//	public void load(GL10 gl) {
//	GameInput.addTouchUpListner(this);
//		GameSettings.setFPS(60);
//		Texture tex1 = TextureHandler.getLoadTextureAndGetTexture(gl, R.drawable.pingpongball);
//		Texture tex2 = TextureHandler.getLoadTextureAndGetTexture(gl, R.drawable.paddle2);
////		Debug.print("t1n " + tex1.mName);
//
//		//ball
//		mBall = new Ball(50, 100);
//		resetBall();
//
//		mBall.addUpdateable(new BallWallCollision(mBall,this));
//
//		mPlayerPaddle = new Paddle(110,17);
//		mPlayerMovement = new PaddlePlayerMovement(mPlayerPaddle);
//		Debug.print("xy:" + mPlayerPaddle.getX() +"," + mPlayerPaddle.getY());
//		add(mPlayerPaddle);
//		
//		mAIPaddle = new Paddle(110,Game.getHeight()-17);
//		
//		//TODO Updateable/or gamepart? should know its parent?.¨
//		mAIMovement = new PaddleAIMovement(mAIPaddle,mBall);
//		mAIPaddle.addUpdateable(mAIMovement);
//		add(mAIPaddle);
//
//
//		add(mBall);
//
//		//collisions
//		mBall.addUpdateable(new PaddleBallCollision(mBall,mPlayerPaddle));
//		mBall.addUpdateable(new PaddleBallCollision(mBall,mAIPaddle));
//
//		SoundEffectPlayer.load("score","audio/pong.ogg");
//	}
//

//
//	private void resetBall()
//	{		
//		mBall.setX(Game.getWidth()/2);
//		mBall.setY(Game.getHeight()/2);
//	}
//
//	@Override
//	public void touchUp(MotionEvent event) {		
//		Debug.print("touch");
//		mAIMovement.mDir *= -1f ;
//		if(mSwapinput)
//		{
//			 Updatable temp = mAIMovement.move();
//			 mAIMovement.setPaddle(mPlayerPaddle);
//			 mPlayerPaddle.addUpdateable(temp);
//			 
//			 mPlayerMovement.setPaddle(mAIPaddle);
//			 mSwapinput=false;
//		}
//		else
//		{
//			 Updatable temp = mAIMovement.move();
//			 mAIPaddle.addUpdateable(temp);
//			 mAIMovement.setPaddle(mAIPaddle);
//			 mPlayerMovement.setPaddle(mPlayerPaddle);
//			 mSwapinput=true;
//		}
//	}
//
//}// end of class