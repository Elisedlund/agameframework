package com.agameframework.tofixorgarbage;
//package com.agameframework.sound;
//
//import java.util.ArrayList;
//
//import com.agameframework.debug.Debug;
//import com.agameframework.interfaces.IPlayableSound;
//
//public class SequenceSoundEffect implements IPlayableSound{
//	
//	private ArrayList<String> mSoundList = new ArrayList<String>(4);
//	private int mCurrentPointer = 0; 
//	
//	public SequenceSoundEffect()
//	{}
//	
//	public SequenceSoundEffect(ArrayList<String> soundList)
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
//	public void play()
//	{
//		SoundEffectPlayer.play(mSoundList.get(mCurrentPointer));
//		//TODO remove debug when its tested.
//		Debug.print("pointer: " + mCurrentPointer +"sound: " + mSoundList.get(mCurrentPointer));
//		mCurrentPointer++;
//		if(mCurrentPointer >= mSoundList.size())
//		{
//			mCurrentPointer=0;
//		}
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