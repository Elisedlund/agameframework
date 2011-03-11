//package com.agameframework.elis.paperpong;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//import com.agameframework.Game;
//import com.agameframework.interfaces.IUpdatable;
//import com.agameframework.object.ObjectCollision;
//import com.agameframework.sound.RandomSoundEffect;
//
//public class BallWallCollision implements IUpdatable{
//
//	private Ball mBall;
//	private StartState mOwner;
//	private static RandomSoundEffect sound; 
//
//
//	public BallWallCollision(Ball ball,StartState owner)
//	{
//		mBall=ball;
//		mOwner=owner;
//		sound = new RandomSoundEffect(
//				new ArrayList<String>(Arrays.asList("audio/BallOnTable01.ogg",
//						"audio/BallOnTable02.ogg",
//						"audio/BallOnTable03.ogg",
//						"audio/BallOnTable04.ogg"
//				)));
//
//	}
//	@Override
//	public void update()
//	{
//		if(ObjectCollision.isRightScreenEdgeCollisionAndRemoveOverlap(mBall))
//		{
//			Game.instance.vibrate(21);
//			mBall.mMovement.mXMotion = -Math.abs(mBall.mMovement.mXMotion);
//			sound.play();
//		}	
//		if(ObjectCollision.isLeftScreenEdgeCollisionAndRemoveOverlap(mBall))
//		{
//			Game.instance.vibrate(21);
//			mBall.mMovement.mXMotion = Math.abs(mBall.mMovement.mXMotion);
//			sound.play();
//		}
//		if(ObjectCollision.isTopScreenEdgeCollision(mBall))
//		{		
//			if(ObjectCollision.getTopScreenEdgeOverlap(mBall) >= mBall.getHeight())
//			{
//				mOwner.playerOneScore();
//			}
//		}
//		if(ObjectCollision.isBottomScreenEdgeCollision(mBall))
//		{
//			if(ObjectCollision.getBottomScreenEdgeOverlap(mBall) >= mBall.getHeight())
//			{
//				mOwner.playerTwoScore();
//			}	
//		}
//	}
//
//}//end of class