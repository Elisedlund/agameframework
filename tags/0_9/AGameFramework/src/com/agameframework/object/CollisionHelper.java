package com.agameframework.object;

import com.agameframework.Game;
import com.agameframework.debug.Debug;
import com.agameframework.updatables.MovementUpdatable;

/**
 * TODO doc i hela.
 * @author Elis
 *
 */
public class CollisionHelper {

	//TODO enum.
	public final static int EAST=0;
	public final static int NORTH=1;
	public final static int WEST=2;
	public final static int SOUTH=3;


	/**
	 * check if it was an horizontal collision
	 * must make sure there is a collision first with isCollision()
	 * @param sprite1
	 * @param sprite2
	 * @return
	 */
	public static boolean isHorizontalCollision(Rectangle sprite1,Rectangle sprite2)
	{
		if (sprite1.mLeft < sprite2.mLeft &&
				(sprite1.mRight) > sprite2.mLeft)
		{return true;}

		if (sprite2.mLeft < sprite1.mLeft &&
				(sprite2.mRight) > sprite1.mLeft)
		{return true;}
		return false;
	}

	/**
	 * check if it was an vertical collision
	 * must make sure there is a collision first with isCollision()
	 * @param sprite1
	 * @param sprite2
	 * @return
	 */
	public static boolean isVerticalCollision(Rectangle sprite1,
			Rectangle sprite2)
	{
		if (sprite1.mTop < sprite2.mTop &&
				(sprite1.mBottom) > sprite2.mTop)
		{return true;}

		if (sprite2.mTop < sprite1.mTop &&
				(sprite2.mBottom) > sprite1.mTop)
		{return true;}
		return false;
	}


	/**
	 * check if it was an south collision
	 * must make sure there is a collision first with isCollision()
	 * @param movingSprite typically a moving sprite
	 * @param northSprite typically a stationary sprite
	 * @return
	 */
	public static boolean isSouthCollision(Rectangle movingSprite,
			Rectangle northSprite)
	{
		if (northSprite.mTop < movingSprite.mTop &&
				(northSprite.mBottom) > movingSprite.mTop &&
				(northSprite.mBottom) < (movingSprite.mBottom))
		{return true;}
		return false;
	}

	/**
	 * checks if it was an south collision
	 * collision
	 * must make sure there is a collision first with isCollision()
	 * @param southSprite typically a moving sprite
	 * @param northSprite typically a stationary sprite
	 * @return collision?
	 */
	public static boolean isSouthCollision(MovementUpdatable southSprite, 
			Rectangle northSprite)
	{
		if(southSprite.mYMotion >= 0)
		{
			return false;
		}
		return isSouthCollision(southSprite.mParent,northSprite);
	}


	/**
	 * check if it was an north collision
	 * must make sure there is a collision first with isCollision()
	 * @param northSprite typically a moving sprite
	 * @param southSprite typically a stationary sprite
	 * @return
	 */
	public static boolean isNorthCollision(Rectangle northSprite, 
			Rectangle southSprite)
	{
		return isSouthCollision(southSprite,northSprite);
	}

	/**
	 * checks if it was an north collision
	 * collision
	 * must make sure there is a collision first with isCollision()
	 * @param northSprite typically a moving sprite
	 * @param southSprite typically a stationary sprite
	 * @return collision?
	 */
	public static boolean isNorthCollision(MovementUpdatable northSprite, 
			Rectangle southSprite)
	{
		if(northSprite.mYMotion <= 0)
		{
			return false;
		}
		return isNorthCollision(northSprite.mParent,southSprite);
	}

	/**
	 * check if it was an west collision
	 * must make sure there is a collision first with isCollision()
	 * @param westSprite typically a moving sprite
	 * @param eastSprite typically a stationary sprite
	 * @return
	 */
	public static boolean isWestCollision(Rectangle westSprite,
			Rectangle eastSprite)
	{
		if (westSprite.mLeft < eastSprite.mLeft &&
				(westSprite.mBottom) > eastSprite.mTop &&
				(westSprite.mBottom) < (eastSprite.mBottom))			
		{return true;}
		return false;
	}

	/**
	 * checks if it was an west collision
	 * collision
	 * must make sure there is a collision first with isCollision()
	 * @param westSprite typically a moving sprite
	 * @param eastSprite typically a stationary sprite
	 * @return collision?
	 */
	public static boolean isWestCollision(MovementUpdatable westSprite, 
			Rectangle eastSprite)
	{
		if(westSprite.mXMotion <= 0)
		{
			return false;
		}
		return isWestCollision(westSprite.mParent,eastSprite);
	}

	/**
	 * check if it was an east collision
	 * must make sure there is a collision first with isCollision()
	 * @param eastSprite typically a moving sprite
	 * @param westSprite typically a stationary sprite
	 * @return
	 */
	public static boolean isEastCollision(Rectangle eastSprite,
			Rectangle westSprite)
	{
		return isWestCollision(westSprite,eastSprite);	
	}

	/**
	 * checks if it was an east collision
	 * collision
	 * must make sure there is a collision first with isCollision()
	 * @param eastSprite typically a moving sprite
	 * @param westSprite typically a stationary sprite
	 * @return collision?
	 */
	public static boolean isEastCollision(MovementUpdatable eastSprite, 
			Rectangle westSprite)
	{
		if(eastSprite.mXMotion > 0)
		{
			return false;
		}
		return isEastCollision(eastSprite.mParent,westSprite);
	}


	/**
	 * check if the sprite collides with the screen edge
	 * @param sprite 
	 * @return
	 */
	public static boolean isBottomScreenEdgeCollision(Rectangle sprite)
	{
		return 0 >= sprite.mBottom;  	
	}

	/**
	 * check if the sprite collides with the screen edge
	 * @param sprite 
	 * @return
	 */
	public static boolean isTopScreenEdgeCollision(Rectangle sprite)
	{
		return sprite.mTop >= Game.getHeight();
	}

	/**
	 * check if the sprite collides with the screen edge
	 * @param sprite 
	 * @return
	 */
	public static boolean isLeftScreenEdgeCollision(Rectangle sprite)
	{
		return sprite.mLeft < 0;
	}

	/**
	 * check if the sprite collides with the screen edge
	 * @param sprite 
	 * @return
	 */
	public static boolean isRightScreenEdgeCollision(Rectangle sprite)
	{	
		return Game.getWidth() <= sprite.mRight; 
	}

	//CollisionOverlap


	/**
	 * must make sure there is a collision first with isSouthCollision()
	 * @param southSprite
	 * @param northSprite
	 * @return the overlap
	 */
	public static float getSouthCollisionOverlap(Rectangle southSprite,
			Rectangle northSprite)
	{	
		return getNorthCollisionOverlap(northSprite,southSprite);
	}
	
	/**
	 * must make sure there is a collision first with isSouthCollision()
	 * @param southSprite
	 * @param northSprite
	 * @return the overlap
	 */
	public static float getNorthCollisionOverlap(Rectangle southSprite,
			Rectangle northSprite)
	{	
		return southSprite.mTop - northSprite.mBottom;	
	}

	/**
	 * must make sure there is a collision first with isEastCollision()
	 * @param eastSprite
	 * @param westSprite
	 * @return the overlap
	 */
	public static float getEastCollisionOverlap(Rectangle eastSprite,
			Rectangle westSprite)
	{	
		return westSprite.mRight - eastSprite.mLeft;
	}

	/**
	 * must make sure there is a collision first with isWestCollision()
	 * @param westSprite
	 * @param eastSprite
	 * @return the overlap
	 */
	public static float getWestCollisionOverlap(Rectangle westSprite,
			Rectangle eastSprite)
	{	
		return westSprite.mRight - eastSprite.mLeft;
	}

	/**
	 * must make sure there is a collision first with isSouthScreenEdgeCollision()
	 * @param sprite
	 * @return the overlap
	 */
	public static float getBottomScreenEdgeOverlap(Rectangle sprite)
	{

		return Math.abs(sprite.mBottom);
		
	}

	/**
	 * must make sure there is a collision first with isNorthScreenEdgeCollision()
	 * @param sprite
	 * @return the overlap
	 */
	public static float getTopScreenEdgeOverlap(Rectangle sprite)
	{
		
		return (sprite.mTop - Game.getHeight()) + 1;
	}

	/**
	 * must make sure there is a collision first with isWestScreenEdgeCollision()
	 * @param sprite
	 * @return the overlap
	 */
	public static float getLeftScreenEdgeOverlap(Rectangle sprite)
	{
		return Math.abs(sprite.mLeft);
	}

	/**
	 * must make sure there is a collision first with isEastScreenEdgeCollision()
	 * @param sprite
	 * @return the overlap
	 */
	public static float getRightScreenEdgeOverlap(Rectangle sprite)
	{

	return (sprite.mRight - Game.getWidth()) + 1; 

	}

	/**
	 * checks if it was an north collision and removes the overlap if there was a
	 * collision
	 * must make sure there is a collision first with isCollision()
	 * @param northSprite typically a moving sprite
	 * @param southSprite typically a stationary sprite
	 * @return collision?
	 */
	public static boolean isNorthCollisionAndRemoveOverlap(Rectangle northSprite, 
			Rectangle southSprite)
	{
		if(isNorthCollision(northSprite, southSprite))
		{
			northSprite.incY(CollisionHelper.getNorthCollisionOverlap(northSprite, southSprite));
			return true;
		}
		return false;
	}
	/**
	 * checks if it was an north collision and removes the overlap if there was a
	 * collision
	 * must make sure there is a collision first with isCollision()
	 * @param northSprite typically a moving sprite
	 * @param southSprite typically a stationary sprite
	 * @return collision?
	 */
	public static boolean isNorthCollisionAndRemoveOverlap(MovementUpdatable northSprite, 
			Rectangle southSprite)
	{
		if(northSprite.mYMotion <= 0)
		{
			return false;
		}
		return isNorthCollisionAndRemoveOverlap(northSprite.mParent,southSprite);
	}

	/**
	 * checks if it was an south collision and removes the overlap if there was a
	 * collision
	 * must make sure there is a collision first with isCollision()
	 * @param southSprite typically a moving sprite
	 * @param northSprite typically a stationary sprite
	 * @return collision?
	 */
	public static boolean isSouthCollisionAndRemoveOverlap(Rectangle southSprite,
			Rectangle northSprite)
	{
		if(isSouthCollision(southSprite,northSprite))
		{
			southSprite.decY(CollisionHelper.getNorthCollisionOverlap(southSprite,northSprite));
			return true;
		}
		return false;
	}
	/**
	 * checks if it was an south collision and removes the overlap if there was a
	 * collision
	 * must make sure there is a collision first with isCollision()
	 * @param southSprite typically a moving sprite
	 * @param northSprite typically a stationary sprite
	 * @return collision?
	 */
	public static boolean isSouthCollisionAndRemoveOverlap(MovementUpdatable southSprite,
			Rectangle northSprite)
	{
		if(southSprite.mYMotion >= 0)
		{
			return false;
		}
		return isSouthCollisionAndRemoveOverlap(southSprite.mParent,northSprite);
	}

	/**
	 * checks if it was an west collision and removes the overlap if there was a
	 * collision
	 * must make sure there is a collision first with isCollision()
	 * @param westSprite typically a moving sprite
	 * @param eastSprite typically a stationary sprite
	 * @return collision?
	 */
	public static boolean isWestCollisionAndRemoveOverlap(Rectangle westSprite,
			Rectangle eastSprite)
	{
		if(isWestCollision(westSprite, eastSprite))
		{
			westSprite.decX(CollisionHelper.getWestCollisionOverlap(westSprite, eastSprite));
			return true;
		}
		return false;
	}

	/**
	 * checks if it was an west collision and removes the overlap if there was a
	 * collision
	 * must make sure there is a collision first with isCollision()
	 * @param westSprite typically a moving sprite
	 * @param eastSprite typically a stationary sprite
	 * @return collision?
	 */
	public static boolean isWestCollisionAndRemoveOverlap(MovementUpdatable westSprite,
			Rectangle eastSprite)
	{
		if(westSprite.mXMotion <= 0)
		{
			return false;
		}
		return isWestCollisionAndRemoveOverlap(westSprite.mParent,eastSprite);
	}

	/**
	 * check if it was an east collision and removes the overlap if there was a
	 * collision
	 * must make sure there is a collision first with isCollision()
	 * @param eastSprite typically a moving sprite
	 * @param westSprite typically a stationary sprite
	 * @return collision?
	 */
	public static boolean isEastCollisionAndRemoveOverlap(Rectangle eastSprite,
			Rectangle westSprite)
	{
		if(isEastCollision(eastSprite,westSprite))
		{
			eastSprite.incX(CollisionHelper.getEastCollisionOverlap(eastSprite,westSprite));
			return true;
		}
		return false;
	}
	/**
	 * check if it was an east collision and removes the overlap if there was a
	 * collision
	 * must make sure there is a collision first with isCollision()
	 * @param eastSprite typically a moving sprite
	 * @param westSprite typically a stationary sprite
	 * @return collision?
	 */
	public static boolean isEastCollisionAndRemoveOverlap(MovementUpdatable eastSprite,
			Rectangle westSprite)
	{
		if(eastSprite.mXMotion >= 0)
		{
			return false;
		}
		return isEastCollisionAndRemoveOverlap(eastSprite.mParent,westSprite);
	}

	public static boolean isTopScreenEdgeCollisionAndRemoveOverlap(Rectangle rect)
	{
		if(isTopScreenEdgeCollision(rect))
		{
			rect.decY(CollisionHelper.getTopScreenEdgeOverlap(rect));
			return true;
		}
		return false;
	}
	public static boolean isBottomScreenEdgeCollisionAndRemoveOverlap(Rectangle rect)
	{
		if(isBottomScreenEdgeCollision(rect))
		{
			rect.incY(CollisionHelper.getBottomScreenEdgeOverlap(rect));
			return true;
		}
		return false;
	}

	public static boolean isLeftScreenEdgeCollisionAndRemoveOverlap(Rectangle rect)
	{
		if(isLeftScreenEdgeCollision(rect))
		{
			rect.incX(CollisionHelper.getLeftScreenEdgeOverlap(rect));
			return true;
		}
		return false;	
	}
	public static boolean isRightScreenEdgeCollisionAndRemoveOverlap(Rectangle rect)
	{
		if(isRightScreenEdgeCollision(rect))
		{
			rect.decX(CollisionHelper.getRightScreenEdgeOverlap(rect));
			return true;
		}
		return false;	
	}



	public static void removeSmallestOverlap(MovementUpdatable movingObj, Rectangle solidObj,boolean[] collisionAt ) {

		Rectangle movingSprite = movingObj.mParent;

		if(movingObj.mXMotion >= 0 && movingObj.mYMotion <= 0) // can be west & south
		{ 
			float wo = CollisionHelper.getWestCollisionOverlap(movingSprite, solidObj);
			float so = CollisionHelper.getSouthCollisionOverlap(movingSprite, solidObj);
			if(wo == so)
			{
				movingSprite.incY(so); 
				movingSprite.incX(-wo);
				collisionAt[WEST] = true;
				collisionAt[SOUTH] = true;
				return;
			}
			if(wo > so) //south smallest overlap so south collision
			{
				movingSprite.incY(so);
				collisionAt[SOUTH] = true;
				return;
			}
			else //west smallest overlap so west collision
			{
				movingSprite.incX(-wo);
				collisionAt[WEST] = true;
				return;
			}	
		} //end of west or south

		if(movingObj.mXMotion <= 0 && movingObj.mYMotion >= 0) // can be north or east
		{
			float no = CollisionHelper.getNorthCollisionOverlap(movingSprite, solidObj);
			float eo = CollisionHelper.getEastCollisionOverlap(movingSprite, solidObj);
			if(no == eo)
			{
				movingSprite.incY(-no); 
				movingSprite.incX(eo);
				collisionAt[NORTH] = true;
				collisionAt[EAST] = true;
				return;
			}
			if(eo >= no) //north smallest overlap so north collision
			{
				movingSprite.incY(-no);
				collisionAt[NORTH] = true;
				return;
			}
			else //east smallest overlap so east collision
			{
				movingSprite.incX(eo);
				collisionAt[EAST] = true;
				return;
			}	
		} //end of north or east

		if(movingObj.mXMotion >= 0 && movingObj.mYMotion >= 0) // can be north or west
		{
			float no = CollisionHelper.getNorthCollisionOverlap(movingSprite, solidObj);
			float wo = CollisionHelper.getWestCollisionOverlap(movingSprite, solidObj);
			if(no == wo)
			{
				movingSprite.incY(-no); 
				movingSprite.incX(-wo);
				collisionAt[NORTH] = true;
				collisionAt[WEST] = true;
				return;
			}
			if(wo > no) //north smallest overlap so north collision
			{
				movingSprite.incY(-no);
				collisionAt[NORTH] = true;
				return;
			}
			else //west smallest overlap so west collision
			{
				movingSprite.incX(-wo);
				collisionAt[WEST] = true;
				return;
			}	
		} //end of north or west.

		if(movingObj.mXMotion <= 0 && movingObj.mYMotion <= 0) // can be east & south
		{
			float eo = CollisionHelper.getEastCollisionOverlap(movingSprite, solidObj);
			float so = CollisionHelper.getSouthCollisionOverlap(movingSprite, solidObj);
			if(eo == so)
			{

				movingSprite.incY(so); 
				movingSprite.incX(eo);
				collisionAt[EAST] = true;
				collisionAt[SOUTH] = true;
				return;
			}
			if(eo > so) //south smallest overlap so south collision
			{
				movingSprite.incY(so);
				collisionAt[SOUTH] = true;
				return;
			}
			else //east smallest overlap so east collision
			{
				movingSprite.incX(eo);
				collisionAt[EAST] = true;
				return;
			}	
		} //end of east or south
		Debug.print("should never get here collision");
		return;
	}

	//	public static boolean[] removeSmallestOverlap(Object2DModel movingObj, Object2DModel solidObj,boolean[] collisionAt ) {
	//
	//		float so = ObjectCollision.getSouthCollisionOverlap(movingObj, solidObj);
	//		float wo = ObjectCollision.getWestCollisionOverlap(movingObj, solidObj);
	//		float no = ObjectCollision.getNorthCollisionOverlap(movingObj, solidObj);
	//		float eo = ObjectCollision.getEastCollisionOverlap(movingObj, solidObj);
	//
	//		if (smallest(so,no,eo,wo)) //if so smallest
	//		{
	//			movingObj.setY(movingObj.top + so); //TODO check that it should be +
	//			collisionAt[SOUTH] = true;
	//			if(so==wo) //if corner overlap
	//			{
	//				movingObj.setX(movingObj.left - wo);
	//				collisionAt[WEST] = true;
	//			}
	//			if(so==eo)
	//			{
	//				movingObj.setX(movingObj.left + eo);
	//				collisionAt[EAST] = true;
	//			}
	//			return collisionAt;
	//		}
	//		if (smallest(no,so,eo,wo)) //if no smallest
	//		{
	//			movingObj.setY(movingObj.top - no); //TODO check that it should be -
	//			collisionAt[NORTH] = true;
	//			if(no==wo) //if corner overlap
	//			{
	//				movingObj.setX(movingObj.left - wo);
	//				collisionAt[WEST] = true;
	//			}
	//			if(no==eo)
	//			{
	//				movingObj.setX(movingObj.left + eo);
	//				collisionAt[EAST] = true;
	//			}
	//			return collisionAt;
	//		}
	//		if (smallest(eo,so,no,wo)) //if no smallest
	//		{
	//			movingObj.setX(movingObj.left + eo); //TODO check that it should be -
	//			collisionAt[EAST] = true;
	//			if(eo==no) //if corner overlap //TODO should never get here.
	//			{
	//				Debug.print("Warning! you should never get here");
	//				movingObj.setY(movingObj.top - no);
	//			}
	//			if(eo==so) //TODO should never get here.
	//			{
	//				Debug.print("Warning! you should never get here");
	//				movingObj.setY(movingObj.top + so);				
	//			}
	//			return collisionAt;
	//		}
	//		if (smallest(wo,so,no,eo)) //if no smallest
	//		{
	//			movingObj.setX(movingObj.left - wo); //TODO check that it should be -
	//			collisionAt[WEST] = true;
	//			if(wo==no) //if corner overlap //TODO should never get here.
	//			{
	//				Debug.print("Warning! you should never get here");
	//				movingObj.setY(movingObj.top - no);
	//			}
	//			if(wo==so) //TODO should never get here.
	//			{
	//				Debug.print("Warning! you should never get here");
	//				movingObj.setY(movingObj.top + so);				
	//			}
	//			return collisionAt;
	//		}
	//		Debug.print("There is no overlap but there is collision. You should never get here");
	//		return collisionAt;
	//	}

	//	private static boolean[] removeInvalidCornerCollisions(ObjectMovement movingObj,boolean[] collisionAt )
	//	{
	//		if(collisionAt[EAST] && (movingObj.mMotionX >= 0 ))
	//		{
	//			collisionAt[EAST] = false;
	//		}
	//
	//		if(collisionAt[NORTH] && (movingObj.mMotionY <= 0 ))
	//		{
	//			collisionAt[NORTH] = false;
	//		}
	//
	//		if(collisionAt[WEST] && (movingObj.mMotionX <= 0 ))
	//		{
	//			collisionAt[WEST] = false;
	//		}
	//
	//		if(collisionAt[SOUTH] && (movingObj.mMotionY >= 0 ))
	//		{
	//			collisionAt[SOUTH] = false;
	//		}
	//		return collisionAt;
	//	}





	//	public static boolean[] removeSmallestOverlapAndFilter(ObjectMovement movingObj,Object2DModel solidObj,boolean[] collisionAt )
	//	{
	//		collisionAt = removeSmallestOverlap(movingObj.mSprite, solidObj,collisionAt);
	//		return removeInvalidCornerCollisions(movingObj,collisionAt);
	//	}

}//end of class