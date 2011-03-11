package com.agameframework.text;

import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;
import javax.microedition.khronos.opengles.GL11Ext;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.agameframework.texture.TextureHandler;

public class Text{

	private int mTextureCharHeight = 36; //bad. 32 to halve the texture size.
	private int mTextureCharWidth = 32;
	private int mCharPerLine = 16;

	private int mPadding = 3; //extra width in texture crop so effects like shadow will show.
	private int mTextWidth; // width of the whole text.
	private int[] mTextWidthArray; // store every char width form text. without padding.

	private int[][] mTextCropArray; // the crop array for the given text.
	private int mStrLength; // length the text.

	//TODO load form String.xml
	private static String mCharPattern = " !\"#$%&`()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX¡¢£¤¥¦§¨©ª«¬­®¯ °±²³´µ¶·¸¹º»¼½¾¿ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏĞÑÒÓÔÕÖ×ØÙÚÛÜİŞßàáâãäåæçèéêëìíîïğñòóôõö÷øùúûüışÿ";


	//arial 32x36 s31 bold pos: 1,3 
	private static int[] mCharWidthArray = 
	{7,8,12,14,14,24,19,6,9,9,10,15,7,9,7,7,
		14,14,14,14,14,14,14,14,14,14,10,10,15,15,15,16,
		25,19,19,19,19,17,16,20,19,8,14,19,16,23,19,20,
		18,20,19,17,16,19,17,25,17,18,16,9,7,9,15,14,
		9,14,16,14,16,14,9,16,16,8,8,14,8,24,16,16,
		16,16,10,14,9,16,15,21,14,15,13,10,7,10,15,20,
		14,20,7,14,13,26,14,14,9,28,17,9,26,20,16,20,
		20,7,7,13,13,9,14,26,9,26,14,9,25,20,13,17,
		7,10,14,14,14,14,7,14,9,19,10,14,15,9,19,14,
		10,14,9,9,9,15,14,9,9,9,9,14,22,22,22,16,
		19,19,19,19,19,19,26,19,17,17,17,17,7,7,7,7,
		19,19,20,20,20,20,20,15,20,19,19,19,19,17,17,16,
		14,14,14,14,14,14,23,14,14,14,14,14,7,7,7,7,
		16,16,16,16,16,16,16,14,16,16,16,16,16,14,16,14};
	private static int mCurrentFontId = -1;
	private static Bitmap mFontBitmap;

	/*
" !\"#$%&`()*+,-./
0123456789:;<=>?
@ABCDEFGHIJKLMNO
PQRSTUVWXYZ[\]^_
`abcdefghijklmno
pqrstuvwxyz{|}~
XXXXXXXXXXXXXXXX
XXXXXXXXXXXXXXXX
¡¢£¤¥¦§¨©ª«¬­®¯
°±²³´µ¶·¸¹º»¼½¾¿
ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏ
ĞÑÒÓÔÕÖ×ØÙÚÛÜİŞß
àáâãäåæçèéêëìíîï
ğñòóôõö÷øùúûüışÿ"
	 */

	public void setText(String str)
	{        
		int size = str.length();
		//              mText = str;
		mStrLength = size;
		mTextWidth = 0;
		mTextCropArray = new int[size][4];
		mTextWidthArray = new int[size];
		for(int i=0 ; i<size ; i++)
		{ 
			int index = mCharPattern.indexOf(str.charAt(i));
			int charWidth = mCharWidthArray[index];

			mTextCropArray[i][0] = (index%mCharPerLine)*mTextureCharWidth;
			mTextCropArray[i][1] = (index/mCharPerLine)*mTextureCharHeight+mTextureCharHeight;
			mTextCropArray[i][2] = charWidth + mPadding;
			mTextCropArray[i][3] = -mTextureCharHeight;

			mTextWidthArray[i] = charWidth; // save just the text char width.
			mTextWidth += charWidth; //whole text width.
		} 
	} // end of func

	public int getTextWidth()
	{
		return mTextWidth;
	}

	public void render(GL10 gl, float left, float bottom, float scaleX,
			float scaleY) 
	{       
		float nextX = left;
		int size = mStrLength;
		for(int i = 0 ; i<size ; i++) // for every char in text.
		{
			((GL11) gl).glTexParameteriv(GL10.GL_TEXTURE_2D, 
					GL11Ext.GL_TEXTURE_CROP_RECT_OES, mTextCropArray[i], 0); //select crop
			((GL11Ext) gl).glDrawTexfOES(nextX ,bottom, 0, mTextCropArray[i][2]*scaleX, mTextureCharHeight*scaleY); // render char.
			nextX += mTextWidthArray[i]*scaleX;
		}
	}

	public Bitmap TextToBitmap(int resourceId)
	{
		if(mCurrentFontId != resourceId)
		{
			mCurrentFontId = resourceId;
			mFontBitmap = TextureHandler.loadBitmap(resourceId);
		}

		Bitmap.Config config = Bitmap.Config.ARGB_8888;
		Bitmap textBitmap = Bitmap.createBitmap(getTextWidth()+mPadding,getTextHeight(),config);
		Canvas canvas = new Canvas(textBitmap); 

		int nextX = 0;
		int size = mStrLength;
		for(int i = 0 ; i<size ; i++) // for every char in text.
		{
			Rect src = new Rect(mTextCropArray[i][0], mTextCropArray[i][1]-mTextureCharHeight, mTextCropArray[i][0]+mTextCropArray[i][2], mTextCropArray[i][1]);
			Rect dst = new Rect(nextX,0,nextX + +mTextCropArray[i][2],getTextHeight());

			canvas.drawBitmap(mFontBitmap, src, dst ,null);
			nextX += mTextWidthArray[i]; 
		}
		return textBitmap;
	}       

	public int getTextHeight() {
		return mTextureCharHeight;
	}

}// end of class.