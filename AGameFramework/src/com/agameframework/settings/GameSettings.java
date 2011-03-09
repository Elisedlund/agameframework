package com.agameframework.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.agameframework.Game;
import com.agameframework.GameEngine;
import com.agameframework.GameThread;

/**
 * 
 * @author Elis
 */
public class GameSettings {

	private static SharedPreferences sSharedPreferences;
	private static SharedPreferences.Editor sPreferenceEditor;

	/* Default Engine values*/

	/** enable print debug */
	public static boolean DEBUG_LEVEL1 = false;

	/** enable timeing debug */
	public static boolean DEBUG_LEVEL2 = false;

	/** enable tracing debug */
	public static boolean DEBUG_LEVEL3 = false;

	/** show fps in log. */
	public static boolean SHOW_FPS = false; //TODO get set.

	public static int INITIAL_LIST_CAPACITY = 4; 

	/* ERROR REPORT */
	public static int MAX_CRASH_MAIL = 4;
	public static String DEVELOPER_MAIL = null;
	public static String ERROR_DIALOG_TITLE = "Send Error log?";
	public static String ERROR_DIALOG_MESSAGE = "The game crashed last time! Would you like" +
	" to send an error log to the developer so he will be able to fix" +
	" the problem in the future?";
	public static String BUG_EMAIL_TITLE = "AGameFramework bug report: ";
	public static String BUG_EMAIL_BODY = "Your own comments. You can write " +
	"anything you want about the game (optional):";

	
	private static int TIMES_STARTED = 0;
	private static boolean SOUNDEFFECT = true;
	private static boolean SOUNDMUSIC = true;
	private static boolean VIBRATE = true;
	private static int FPS = 30; //some phones have a fillrate of 30.

	//TODO make use of. 
	private static float ACCELEROMETER_SENSITIVITY=1.0f; 
	private static float TRACKBALL_SENSITIVITY=1.0f; 
	private static float ARROWKEYS_SENSITIVITY=1.0f; 
	
	//Some general game variables.
	private static int SCORE1;
	private static int SCORE2;
	private static int HEALTH;
	private static int LIVES;
	private static int HIGHSCORE;
	private static String HIGHSCORENAME; 
	
	public static void reset(Context context)
	{
		sSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
		sPreferenceEditor = sSharedPreferences.edit();

		SOUNDEFFECT = getBoolean("soundeffect",SOUNDEFFECT);
		SOUNDMUSIC = getBoolean("soundmusic",SOUNDMUSIC);
		VIBRATE = getBoolean("vibrate",VIBRATE);
		TIMES_STARTED = getInt("startedCount",0);
		HIGHSCORE = getInt("highscore",0);
		HIGHSCORENAME = getString("highscorename","noname");
		SCORE1=0;
		SCORE2=0;
		HEALTH=0;
		LIVES=0;
	}

	/* Setting specific for the engine */

	public static int getFPS() {
		return getInt("fps",FPS);
	}

	public static void setFPS(int fps) {
		setInt("fps",fps);
		GameEngine.sGameThread.setFps(fps); 
	}

	public static boolean getSoundEffect() {
		return SOUNDEFFECT;
	}

	public static void setSoundEffect(boolean s) {
		setBoolean("soundeffect",s);
		SOUNDEFFECT = s;
	}

	public static boolean getVibrate() {
		return VIBRATE;
	}

	public static void setVibrate(boolean s) {
		setBoolean("vibrate",s);
		VIBRATE = s;
	}

	public static boolean getSoundMusic() {
		return SOUNDMUSIC;
	}

	public static void setSoundMusic(boolean s) {
		setBoolean("soundmusic",s);
		SOUNDMUSIC = s;
	}

	public static int getStartedCount()
	{
		return TIMES_STARTED;
	}

	public static void incStartedCount()
	{
		setInt("startedCount",TIMES_STARTED + 1);
		TIMES_STARTED += 1;
	}

	/**
	 * @param pref
	 * @param i
	 */
	public static void setInt(String pref, int i)
	{
		sPreferenceEditor.putInt(pref, i);
		sPreferenceEditor.commit();
	}

	/**
	 * @param pref
	 * @param def
	 * @return
	 */
	public static int getInt(String pref, int def)
	{
		return sSharedPreferences.getInt(pref, def);
	}

	/**
	 * @param pref
	 * @param f
	 */
	public static void setFloat(String pref, float f)
	{
		sPreferenceEditor.putFloat(pref, f);
		sPreferenceEditor.commit();
	}

	/**
	 * @param pref
	 * @param def
	 * @return
	 */
	public static float getFloat(String pref, float def)
	{
		return sSharedPreferences.getFloat(pref, def);
	}


	/**
	 * @param pref
	 * @param b
	 */
	public static void setBoolean(String pref, boolean b)
	{
		sPreferenceEditor.putBoolean(pref, b);
		sPreferenceEditor.commit();
	}

	/**
	 * @param pref
	 * @param def
	 * @return
	 */
	public static boolean getBoolean(String pref, boolean def)
	{
		return sSharedPreferences.getBoolean(pref, def);
	}

	/**
	 * @param pref
	 * @param str
	 */
	public static void setString(String pref, String str)
	{
		sPreferenceEditor.putString(pref, str);
		sPreferenceEditor.commit();
	}

	/**
	 * @param pref
	 * @param def
	 * @return
	 */
	public static String getString(String pref, String def)
	{
		return sSharedPreferences.getString(pref, def);
	}

	
	public static int getScore() {
		return SCORE1;
	}

	public static String getScoreString() {
		return Integer.toString(SCORE1);
	}

	public static void resetScore()
	{
		SCORE1 = 0; 
		//TODO reset highscore event.
	}
	
	public static void setScore(int newScore)
	{
		SCORE1 = newScore;
	}

	public static void incScore(int inc)
	{
		SCORE1 += inc;	
	}
	
	public static int getScore2() {
		return SCORE2;
	}

	public static String getScoreString2() {
		return Integer.toString(SCORE2);
	}
	
	public static void resetScore2()
	{
		SCORE2 = 0; 
	}

	public static void setScore2(int newScore)
	{
		SCORE2 = newScore;
	}

	public static void incScore2(int inc)
	{
		SCORE2 += inc;	
	}
	
	public static int getHighscore()
	{
		return HIGHSCORE;
	}
	
	public static String getHighscoreString()
	{
		return Integer.toString(HIGHSCORE);
	}
	
	public static boolean isNewHighscore(int highscore)
	{
		return HIGHSCORE < highscore;
	}
	
	public static void setHighscore(int highscore)
	{
		HIGHSCORE = highscore;
		setInt("highscore", highscore);
	}
	
	public static boolean setIfHighscore()
	{
		if(HIGHSCORE < SCORE1)
		{
			setHighscore(SCORE1);
			return true;
		}
		return false;
	}
	
	public static int getHighscore(String id)
	{
		return getInt("highscore" + id , 0);
	}
	
	public static String getHighscoreString(String id)
	{
		return Integer.toString(getHighscore(id));
	}
	
	public static boolean isNewHighscore(int highscore, String id)
	{
		return getHighscore(id) < highscore;
	}
	
	public static void setHighscore(int highscore, String id)
	{
		setInt("highscore"+id, highscore);
	}
	
	/**Only set it in settings before the game start. don't change it while running the game.
	 * @param width
	 * @param height
	 */
	public static void setGameSize(int width, int height)
	{
		Game.instance.setGameSize(width, height);
	}
	
}// End of settings