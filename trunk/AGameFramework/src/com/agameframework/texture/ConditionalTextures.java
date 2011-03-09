package com.agameframework.texture;

import java.util.ArrayList;
import java.util.List;

import com.agameframework.interfaces.ICondition;
import com.agameframework.interfaces.ITexture;

public class ConditionalTextures extends Texture{

	private ArrayList<ITexture> mTextureList;
	private ArrayList<ICondition> mConditionList; 

	public ConditionalTextures(List<ICondition> conditionlist, List<ITexture> texlist)
	{
		mConditionList = new ArrayList<ICondition>(conditionlist);
		mTextureList = new ArrayList<ITexture>(texlist);
	}

	@Override
	public int getTextureName()
	{
		checkConditions();
		return super.getTextureName();
	}
	
	private void checkConditions()
	{
		int size = mConditionList.size();
		for (int i = 0; i != size; i++) 
		{
			if(mConditionList.get(i).getBoolean())
			{
				copyFromTexture(mTextureList.get(i));
				break;
			}
		}
	}
}