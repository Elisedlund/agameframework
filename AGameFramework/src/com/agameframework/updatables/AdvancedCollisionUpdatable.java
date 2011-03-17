package com.agameframework.updatables;

import com.agameframework.interfaces.IEvent;
import com.agameframework.object.CollisionHelper;
import com.agameframework.object.Rectangle;
import com.agameframework.object.Updatable;



public class AdvancedCollisionUpdatable extends Updatable {

	private Rectangle mRect1;
	private Rectangle mRect2;
	private IEvent mEvent;
	private boolean[] mCollisionAt = new boolean[4];
	private MovementUpdatable mMovement;
	private IEvent mEventEast;
	private IEvent mEventWest;
	private IEvent mEventSouth;
	private IEvent mEventNorth;


	public AdvancedCollisionUpdatable(Rectangle rect1, MovementUpdatable movementOfRect1, Rectangle rect2, IEvent event) {
		mRect1 = rect1;
		mMovement = movementOfRect1;
		mRect2 = rect2;
		mEvent = event;
	}
	
	public void setEvents(IEvent north,IEvent south,IEvent west,IEvent east)
	{
		mEventNorth = north;
		mEventSouth = south;
		mEventWest = west;
		mEventEast = east;
	}

	@Override
	public void update()
	{
		if(mRect1.isCollision(mRect2))
		{
			mEvent.invokeEvent();

			mCollisionAt[0]=false;
			mCollisionAt[1]=false;
			mCollisionAt[2]=false;
			mCollisionAt[3]=false;
			CollisionHelper.removeSmallestOverlap(mMovement, mRect2,mCollisionAt);
			
			if(mCollisionAt[CollisionHelper.NORTH])
			{
				if(mEventNorth != null)
				mEventNorth.invokeEvent();
			}
			if(mCollisionAt[CollisionHelper.SOUTH])
			{
				if(mEventSouth != null)
				mEventSouth.invokeEvent();
			}
			if(mCollisionAt[CollisionHelper.WEST])
			{
				if(mEventWest != null)
				mEventWest.invokeEvent();			
			}
			if(mCollisionAt[CollisionHelper.EAST])
			{
				if(mEventEast!= null)
				mEventEast.invokeEvent();
			}
		}
	}

	@Override
	public void init() {

	}

}
