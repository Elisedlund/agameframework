package com.agameframework.updatables;

import com.agameframework.interfaces.IEvent;
import com.agameframework.object.CollisionHelper;
import com.agameframework.object.Updatable;

public class StayOnScreenUpdatable extends Updatable{

	private boolean mUseEvent=false;
	private IEvent mEventBottom;
	private IEvent mEventTop;
	private IEvent mEventLeft;
	private IEvent mEventRight;

	private boolean mBottom = true;
	private boolean mTop = true;
	private boolean mLeft = true;
	private boolean mRight = true;


	public StayOnScreenUpdatable()
	{ }

	public void setActive(boolean left,boolean top,boolean right,boolean bottom)
	{
		mLeft=left;
		mTop=top;
		mRight=right;
		mBottom=bottom;
	}
	public StayOnScreenUpdatable(IEvent leftright, IEvent bottomtop)
	{
		mUseEvent=true;	
		mEventRight=leftright;
		mEventLeft=leftright;
		mEventTop=bottomtop;
		mEventBottom=bottomtop;
	}

	public StayOnScreenUpdatable(IEvent left, IEvent top, IEvent right,IEvent bottom)
	{
		mUseEvent=true;
		mEventRight=right;
		mEventLeft=left;
		mEventTop=top;
		mEventBottom=bottom;
	}

	@Override
	public void update() {
		if (mUseEvent)
		{
			if(mBottom && CollisionHelper.isBottomScreenEdgeCollisionAndRemoveOverlap(mParent))
			{
				mEventBottom.invokeEvent();
			}
			else if (mTop && CollisionHelper.isTopScreenEdgeCollisionAndRemoveOverlap(mParent))
			{
				mEventTop.invokeEvent();
			}

			if(mLeft && CollisionHelper.isLeftScreenEdgeCollisionAndRemoveOverlap(mParent))
			{
				mEventLeft.invokeEvent();
			}
			else if(mRight && CollisionHelper.isRightScreenEdgeCollisionAndRemoveOverlap(mParent))
			{
				mEventRight.invokeEvent();
			}
		}
		else
		{
			if(!CollisionHelper.isBottomScreenEdgeCollisionAndRemoveOverlap(mParent))
			{
				CollisionHelper.isTopScreenEdgeCollisionAndRemoveOverlap(mParent);
			}

			if(!CollisionHelper.isLeftScreenEdgeCollisionAndRemoveOverlap(mParent))
			{
				CollisionHelper.isRightScreenEdgeCollisionAndRemoveOverlap(mParent);
			}	
		}
	}//end of func

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
}//end of class