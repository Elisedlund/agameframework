package com.agameframework.object;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

import com.agameframework.debug.Debug;
import com.agameframework.interfaces.IRemovable;
import com.agameframework.interfaces.IRenderable;
import com.agameframework.interfaces.ITexture;
import com.agameframework.interfaces.IUpdatable;
import com.agameframework.interfaces.IUpdatableAndRenderableAndRemovable;
import com.agameframework.settings.GameSettings;
import com.agameframework.texture.TextureHandler;

public class GameNode extends Sprite implements IUpdatableAndRenderableAndRemovable{

	protected GameNode mParent;

	private ArrayList<IRenderable> mRenderableList;
	private ArrayList<IUpdatable> mUpdateList;

	private ArrayList<IUpdatable> mRemoveUpdatableList;
	private ArrayList<IRenderable> mRemoveRenderableList;

	private ArrayList<IRemovable> mRemovableList;

	public GameNode(){}

	public GameNode(int resourceID)
	{
		this(TextureHandler.getTexture(resourceID));
	}

	public GameNode(ITexture tex) {
		super(tex);
	}

	public GameNode(String text,ITexture texture)
	{
		super(text,texture);
	}

	public GameNode(String text, int resourceID)
	{
		super(text,TextureHandler.getTexture(resourceID));
	}

	public GameNode(String text) {
		super(text);
	}

//	public void addUpdateable(IUpdatable obj)
//	{
//		createUpdateListIfItDontExist();
//		mUpdateList.add(obj);
//	}
	public void addUpdateable(Updatable upd)
	{
		upd.mParent = this;
		upd.init();
		createUpdateListIfItDontExist();
		mUpdateList.add(upd);
	}

	public void removeUpdateable(IUpdatable obj) // -I
	{
		createRemoveListIfItDontExist();
		mRemoveUpdatableList.add(obj);
	}	

	@Override
	public void update() {
		if(mUpdateList == null) {return;}

		if(mRemoveUpdatableList != null && mRemoveUpdatableList.size() != 0)
		{
			int size = mRemoveUpdatableList.size();
			for (int i = 0; i != size; i++) 
			{
				mUpdateList.remove(mRemoveUpdatableList.get(i));
			}
			mRemoveUpdatableList.clear();
		}


		int size = mUpdateList.size();
		for (int i = 0; i != size; i++) {
			mUpdateList.get(i).update();
		}
	}//end of update()

	public void add(GameNode obj)
	{
		obj.mParent = this; 
		obj.init();
		createRenderableListIfItDontExist();
		mRenderableList.add(obj);
		createUpdateListIfItDontExist();
		mUpdateList.add(obj);
	}

	@Override
	public void render(GL10 gl) {
		//if(mRenderableList == null) {return;}

		if(mRemoveRenderableList != null && mRemoveRenderableList.size() != 0)
		{
			int size = mRemoveRenderableList.size();
			for (int i = 0; i != size; i++) 
			{
				mRenderableList.remove(mRemoveRenderableList.get(i));
			}
			mRemoveRenderableList.clear();
		}
		if(mRenderableList != null)
		{
			int size = mRenderableList.size();
			for (int i = 0; i != size; i++) {
				mRenderableList.get(i).render(gl);
			}
		}

		if(getTexture() != null) //TODO 
		{
			super.render(gl);//render itself first.
		}
	}

	private void createUpdateListIfItDontExist()
	{
		if(mUpdateList == null)
		{
			mUpdateList = new ArrayList<IUpdatable>(GameSettings.INITIAL_LIST_CAPACITY);
		}
	}
	private void createRenderableListIfItDontExist()
	{
		if(mRenderableList == null)
		{
			mRenderableList = new ArrayList<IRenderable>(GameSettings.INITIAL_LIST_CAPACITY);
		}
	}

	private void createRemoveRenderableListIfItDontExist()
	{
		if(mRemoveRenderableList == null)
		{
			mRemoveRenderableList = new ArrayList<IRenderable>(2);
		}
	}

	private void createRemoveListIfItDontExist()
	{
		if(mRemoveUpdatableList == null)
		{
			mRemoveUpdatableList = new ArrayList<IUpdatable>(2);
		}
	}
	private void createRemovableListIfItDontExist() 
	{
		if(mRemovableList == null)
		{
			mRemovableList = new ArrayList<IRemovable>(2);
		}
	}

	public void addRemovable(IRemovable r)
	{
		createRemovableListIfItDontExist();
		mRemovableList.add(r);
	}

	public void remove(GameNode obj)
	{
		createRemoveListIfItDontExist();
		mRemoveUpdatableList.add(obj);//remove later.
		createRemoveRenderableListIfItDontExist();
		mRemoveRenderableList.add(obj);//remove later.
	}

	public void remove()
	{
		
		//removes removables. like input.
		if(mRemovableList != null) {
			int size = mRemovableList.size();
			for (int i = 0; i != size; i++) 
			{
				mRemovableList.get(i).remove();
			}
		}

		//removes all children
		if(mUpdateList != null) {
			int size = mUpdateList.size();
			for (int i = 0; i != size; i++) 
			{
				IUpdatable upd = mUpdateList.get(i);
				if(upd instanceof IRemovable)
				{
					((IRemovable) upd).remove();
				}
			}
		}

		if(mParent != null) //if not root.
		{
			mParent.remove(this); // remove itself.
		}
	}

	public GameNode move()
	{
		GameNode obj = this;
		remove();
		return obj;
	}

	public IUpdatable find(Class<?> c)
	{
		//TODO use instanceof
		if(mUpdateList == null) {return null;}

		int size = mUpdateList.size();
		for (int i = 0; i != size; i++) {
			if(mUpdateList.get(i).getClass() == c)
			{
				Debug.print("found: " + mUpdateList.get(i));
				return mUpdateList.get(i);
			}
		}
		return null;
	}


	public ArrayList<IUpdatable> findAll(Class<?> c)
	{
		//TODO use instanceof
		if(mUpdateList == null) {return null;}

		ArrayList<IUpdatable> list = new ArrayList<IUpdatable>();
		int size = mUpdateList.size();
		for (int i = 0; i != size; i++) {
			if(mUpdateList.get(i).getClass() == c)
			{
				list.add(mUpdateList.get(i));
			}
		}
		return list;
	}

	public ArrayList<IUpdatable> getUpdatableList()
	{
		return mUpdateList;
	}

	//TODO 
//	public void message(String massage)
//	{
//	}
//
//	public void message(String massage, ICondition condition)
//	{
//	}

	public void init()
	{}
}
