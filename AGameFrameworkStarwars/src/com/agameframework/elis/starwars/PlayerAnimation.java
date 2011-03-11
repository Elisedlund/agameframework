package com.agameframework.elis.starwars;

import com.agameframework.texture.Texture;
import com.agameframework.texture.TextureHandler;
import com.agameframework.updatables.MovementUpdatable;

public class PlayerAnimation extends Texture
{

	private MovementUpdatable mMovement;
	private static Texture mOne = TextureHandler.getTexture(R.drawable.spr_player_a1);
	private static Texture mTwo = TextureHandler.getTexture(R.drawable.spr_player_a2);

	public PlayerAnimation(MovementUpdatable movement)
	{
		fromTextureID(R.drawable.spr_player_a1);
		mMovement = movement;
	}

	@Override
	public int getTextureName()
	{
		if (mMovement.mYMotion <= 0)
		{
			return mOne.mName;
		}
		else
		{
			return mTwo.mName; 
		}
	}

}
