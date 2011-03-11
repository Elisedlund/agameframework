package com.agameframework.tofixorgarbage;
//package com.agameframework.sound;
//
//import java.util.ArrayList;
//
//import com.agameframework.interfaces.IPlayableSound;
//
//public class RandomSoundEffect implements IPlayableSound{
//	
//	private ArrayList<String> mSoundList = new ArrayList<String>(4);
//	
//	public RandomSoundEffect()
//	{}
//	
//	public RandomSoundEffect(ArrayList<String> soundList)
//	{
//		mSoundList = soundList;
//		if(mSoundList == null) {return;}
//
//		int size = mSoundList.size();
//
//		for (int i = size-1; i != -1; i--) {
//			SoundEffectPlayer.load(mSoundList.get(i));
//		}
//	}
//	
//	@Override
//	public void play()
//	{
//		int random = (int) (Math.random()*mSoundList.size());
//		SoundEffectPlayer.play(mSoundList.get(random));
//	}
//	
//	public void addSound(String filename)
//	{
//		SoundEffectPlayer.load(filename);
//		mSoundList.add(filename);	
//	}
//	
//	public void removeSound(String filename)
//	{
//		if(mSoundList == null) {return;}
//
//		int removeIndex = 1000000; // we will never have that many sounds.
//		int size = mSoundList.size();
//
//		for (int i = size-1; i != -1; i--) {
//			if(mSoundList.get(i) == filename)
//			{
//				removeIndex=i;
//				break;
//			}
//		}
//		if(removeIndex != 1000000)
//		{
//			mSoundList.remove(removeIndex);
//		}
//		//TODO remove it from SoundPool
//	}
//
//}//End of class
