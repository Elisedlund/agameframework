package com.agameframework.utils;
import android.content.Intent;
import android.net.Uri;

import com.agameframework.Game;
import com.agameframework.settings.SettingsActivity;

public class GameIntents {

	public static void checkForUpdate()
	{
		Game.instance.startActivity(
				new Intent(Intent.ACTION_VIEW,Uri.parse("market://search?q=pname:"+Game.instance.getPackageName())));
	}

	public static void searchForPackage(String pack)
	{
		Game.instance.startActivity(
				new Intent(Intent.ACTION_VIEW,Uri.parse("market://search?q=pname:"+pack)));
	}
	
	public static void sendMail(String subject, String body, String to)
	{
		Intent sendIntent = new Intent(Intent.ACTION_SEND);
		sendIntent.putExtra(Intent.EXTRA_EMAIL,
				new String[] {to});

		sendIntent.putExtra(Intent.EXTRA_TEXT, body);
		sendIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
		sendIntent.setType("message/rfc822");
		Game.instance.startActivity( Intent.createChooser(sendIntent, "Title:") );
	}
	
	public static void runSettingsActivityNOTWORKINGYET()
	{
		//TODO create settingsactivity
		 final Intent intent = new Intent(Game.instance, SettingsActivity.class);
		 Game.instance.startActivity(intent);
	}
	
}
