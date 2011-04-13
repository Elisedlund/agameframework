
public class TODO {
	//DONE fixa SoundFile SoundEffect AudioStream så att dom är mina 
	//DONE Collisions if equal?. {if (westSprite.mX <(=) eastSprite.mX &&}
	//DONE Accelorometer 
	//DONE touch input
	//DONE (HALVT)	
	//floating point math to use FloatMath and then a few methods like my fast 
	//float atan2, toDegrees and toRadians. I now use no doubles anywhere in the code
	//DONE make EngineSettings. 
	//DONE may have spritemodifier variables. composition?.
	//DONE error reporter
	//DONE Titta på rörelse riktning för att besluta om  riktningscollison.
	//DONE East West collisons and overlap bör kollas igenom
	//DONE overlapp tar hänsyn till rörelsehållet.
	//DONE framedrawing timeing fix.  rendering in the correct fps now.
	//DONE draw max possible FPS to log.;
	//DONE stöd för 3d.
	//DONE ms timer and not a nanoTimer.
	//DONE Text concatination.
	//DONE shardPreference store data.
	//DONE 3d renderer
	//DONE basic Texture handling
	//DONE correct? i objectCollision last pixel = (GameEngine.getCanvasWidth()-1)
	//DONE ArrayList instead of linkedlist.
	//DONE Rectangle strukture optimized for games.
	//DONE settings for vibrate.
	//DONE Top Bottom problem. inversed.
	//DONE allt tidsbaserat. tänka om det funkar med min model. Nej inte intressant?
	//DONE better Texture handling
	//DONE utnyttja GameSettings. mer.
	//DONE abstahera renderaren mer.
	//DONE SpriteModifiers Modifierare? //gavitation mm 
	//DONE PIXELS is 0 479 ans 0 319
	//DONE drawtexture 2d.
	//DONE Update och render i samma tråd VIKTIGT. ??? fixat fast inte i samma
	//DONE draw to the canvas with a matrix. or opengl? opengl
	//DONE komponenter ska innehålla component i namnet. updatable
	//DONE prevent phone from sleep (DONE) nej fixa.
	//DONE backbuttom bugg.
	//DONE soundbutton bugg.
	//DONE A LOADER for sound texture etc.
	//DONE move audio files to res.raw(.audio)
	//DONE (NO NEED) textureatlas to reduce bindtexture calls.
	//DONE Font from rokon?
	//DONE static and dynamic Texts.
	//DONE FEATURE non-power-of-two dimensional bitmap
	//DONE fade in / fade out.
	//DONE grow / shrink
	//DONE invert y in touch input. (only in touch components)
	//DONE special component for Score.
	//DONE make sure all input is removed at exit.
	//DONE removeing inputcomponents behind the scen.
	//DONE component interface(like Updatable) to add input components to GameNode. (IREMOVEABLE)
	//DONE restart game bugg.
	//DONE reset the statics in TextureHandler and input every start 
	//DONE gamenode remove childeren in remove.
	//DONE AccelerometerMovement.add(gamenode). static add func? private constructor? in all input.
	//DONE Set game size in Settings.
	//DONE Shadow point to another nodes texture an make all black and render with offset.
	//DONE rainbowColorizer.
	//DONE motionblur parent istead of choosen one. less arguments.
	//DONE fix pulse to be relativ
	//DONE Screen orientation. accelerometer bug still.
	//DONE move trackball handling to GameInput press up down ect.
	//DONE rendering optimatizion.
	
	
	//TODO abstract input so components can share code.
	//TODO grow effect? float precision?
	//TODO alpha problem. premultiplyid?
	//TODO special updatables like fadeoutandremove shrinkandremove.
	//TODO static font problem. (wrong image on restart after !backbutton!).
	//TODO remove dynamic text? and replace them with single char static text list?(only numbers?)
	//TODO shadow and motionblur dont work on dynamic text like score/health ect. croptextures? 
	//TODO croping texture.? do crop in .getTextureName().
	//TODO gameNode.add(prototypefactory) gets a instance form a prototype and adds it.
	//TODO separate numbers from LabeledNumbers.
	//TODO remove all public variables and create getters. ProGuard will optimize this anyway??.
	//TODO optimize text. static no static. text object creation. static dynamic separation? 
	//TODO menu effects.
	//TODO remove constants in grow shring fade,
	//TODO grow shrink can chose x/y. one object each.
	//TODO diffrennt calc for draw if texture is scaled or not. also fix scaled var in texture
	//TODO accelerometer on diffrent orientation.
	//TODO static function in every event. for direct usage.
	//TODO restart game when in game. bug. (hold home and reopen when in game) 
	//TODO reset the statics sound? remove them?  	
	//TODO gamenode render() bugg that makes game crash. (Rare) (just catch exeption?)
	
	//TODO make static texures of numbers in font. (saves texture croping but more texture swap) which is best?
	//TODO Effects 
	//Blink.
	//Slide.
	//rotate spin. (vertexbuffer.) or is it posible to rotate a drawtexture?
	
	//DONE relativ size opacity on Updatables. +-diff till totaldiff.
	//TODO left/right align Text.
	//TODO window setting. fullscreen or not ect.
	//TODO gamenode.find (movement component) in the inputcomponents.
	//TODO system.gc event.

	//TODO util for string concat without creating garbage objects.
	//TODO global highscore.
	//TODO highscore list with names.
	//TODO time highscore.
	//TODO timer GameNode.
	//TODO sensitivity settings. for showing time.
	//TODO char do not exist exeption. 
	//TODO debugging help. like char do not exist.
	//TODO Load Font files.
	//TODO FIX music player.
	//TODO prevent phone from sleep setting.
	
	//TODO sprite depth. needed or not? .
	//TODO only change Media volume. never ringer.
	//TODO batch rendering? with buffers? 
	/*
	 * streamType The stream type to adjust. One of STREAM_VOICE_CALL, STREAM_SYSTEM, STREAM_RING, STREAM_MUSIC or STREAM_ALARM
direction The direction to adjust the volume. One of ADJUST_LOWER, ADJUST_RAISE, or ADJUST_SAME.
flags One or more flags.
See also:
adjustVolume(int,int)
setStreamVolume(int,int,int)
375 
376     public void adjustStreamVolume(int streamType, int direction, int flags) {
377         IAudioService service = getService();
378         try {
379             service.adjustStreamVolume(streamType, direction, flags);
380         } catch (RemoteException e) {
381             Log.e(TAG, "Dead object in adjustStreamVolume", e);
382         }
383     }	
	 */


	//TODO alla listor ska ha en clear



	/*  int value[] = new int[1];
      gl.glGetIntegerv(GL10.GL_MAX_LIGHTS, value, 0);
      maxLights = value[0];
      gl.glGetIntegerv(GL10.GL_MAX_TEXTURE_UNITS, value, 0);
      maxTextureUnits = value[0];
	 */
	//TODO optimize filereading http://code.google.com/p/android/issues/detail?id=1359
	//TODO ladda modeler från .obj format.

	//TODO collisions som tittar på vilken av hastigheterna som är marginellt större innan den tar bort overlap.
	//TODO admob.

	//TODO Animation. with above and different images
	//TODO Particle engine, emitter .
	//TODO Screen transitions

	//TODO tilemap? tiled?
	//TODO Backgrounds?
	//TODO unload in soundEffectsPlayer

	//Fixes
	//TODO	engine not listen on events when not used. this.setOnTouchListener(null); this.setOnKeyListener(l) trackball.

	//TODO Make sure to release all media players and null out all of your resources when the activity is destroyed.

	//TODO http://replicaisland.blogspot.com/2009/10/rendering-with-two-threads.html

	//Debug.
	//TODO ddms debuga och se om det alloceras minne i loopen.
	//http://android-developers.blogspot.com/2009/02/track-memory-allocations....
	//TODO traceview se om det är något som är långsamt
	
	//Changing the background bitmap to RGB_565 helped tremendously. That alone got
	//me to 30-35fps. I was still drawing a full surface layer in ARGB_8888 that the trails 
	//were drawn on to the main canvas. I realized that if I 
	//TODO
	/*Update 8/28/2009 - Timothy F has sent me an easier way to do a counter update with no allocations:

		static final char c[] = new c[100];
		static final StringBuilder sb = new StringBuilder(100);
		private void drawFPS(Canvas canvas) {
		sb.setLength(0);
		sb.append(fps);
		sb.append(FPS_TEXT);
		sb.getChars(0, sb.length(), c, 0);
		canvas.drawText(c, 0, sb.length(), worldWidth - 60, worldHeight +
		INFO_HEADER_HEIGHT - 20, gameResources.fpsPaint);
		}*/	
	//TODO ljud effect for hål i labyrinth D:\Skolan\Android\Sound\Crashes/plastic roll2
	//TODO ljud för fall i maze D:\Skolan\Android\Sound\Comical Effects/comical decen
	//TODO ljud för nyckelupplock maze D:\Skolan\Android\Sound\Deuren/unlock
}
