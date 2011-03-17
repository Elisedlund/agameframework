package com.agameframework.elis.fireballlabyrinth;

import com.agameframework.Game;
import com.agameframework.debug.Debug;
import com.agameframework.event.CallMethodEvent;
import com.agameframework.event.CompositeEvent;
import com.agameframework.event.RemoveEvent;
import com.agameframework.interfaces.ICreateable;
import com.agameframework.interfaces.IEvent;
import com.agameframework.object.GameNode;
import com.agameframework.object.Updatable;
import com.agameframework.updatables.CollisionUpdatable;
import com.agameframework.utils.GenericFactory;
import com.agameframework.utils.GenericPair;

/**
 * the root of the game.
 * @author 
 */
public class GameRoot extends GameNode{

	private MapLoader<GameNode> filereader = new MapLoader<GameNode>();


	private GenericFactory<GameNode> mWallFactory = new GenericFactory<GameNode>(Wall.class);
	private GenericFactory<GameNode> mGoalFactory = new GenericFactory<GameNode>(Goal.class);
	private GenericFactory<GameNode> mBallFactory = new GenericFactory<GameNode>(Ball.class);
	private int mLevel = 0;
	private final int LASTLEVEL = 5;
	
	private GameNode mWallList = new GameNode();
	private GameNode mGoal = new GameNode();
	private Ball mBall = new Ball();

	@Override
	public void init()
	{
		GameNode background = new GameNode(R.drawable.floor2);
		background.setXY(Game.getCenterX(),Game.getCenterY());
		background.setColor(0.7f, 0.7f, 1.0f);
		add(background);
		nextLevel();
	}

	public void nextLevel()
	{	
		mLevel += 1;
		if(mLevel > LASTLEVEL)
		{
			mLevel = 1;
		}
		mBall.remove();
		mGoal.remove();
		mWallList.remove();
		loadLevel("map/map"+ mLevel +".txt");
	}

	private  void loadLevel(String lvl)
	{
		Debug.print("start");
		createBall(lvl);
		
		for (GameNode wall : filereader.loadFile(lvl, new GenericPair<ICreateable<GameNode>,Character>(mWallFactory,'w'))) {

//			Debug.print("wall");
			mWallList.add(wall);

			wall.addUpdateable(new BallWallCollision(mBall, wall));
		}
		createGoal(lvl);

		Debug.print("Done");
		add(mWallList);
		add(mBall);
		add(mGoal);
		//		createScreenEdgeWalls();
		System.gc(); //garbage collect when it does not bother you.
	}



	private void createGoal(String lvl)
	{
		mGoal = filereader.loadFile(lvl, new GenericPair<ICreateable<GameNode>,Character>(mGoalFactory,'g')).get(0);
		CompositeEvent comp = new CompositeEvent();
		Updatable upd = new CollisionUpdatable(mBall,mGoal,comp);
		IEvent next = new CallMethodEvent(this,"nextLevel");
		IEvent remove = new RemoveEvent(upd);
		comp.add(next);
		comp.add(remove);
		addUpdateable(upd);
	}

	private void createBall(String lvl)
	{
		mBall = (Ball) filereader.loadFile(lvl, new GenericPair<ICreateable<GameNode>,Character>(mBallFactory,'b')).get(0);
	}

}// end of class