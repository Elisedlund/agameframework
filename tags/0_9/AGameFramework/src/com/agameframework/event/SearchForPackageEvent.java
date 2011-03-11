package com.agameframework.event;

import com.agameframework.interfaces.IEvent;
import com.agameframework.utils.GameIntents;

public class SearchForPackageEvent implements IEvent {

	private String mPackage = "com.agameframework";
	
	public SearchForPackageEvent(){}

	public SearchForPackageEvent(String mPackage) {
		this.mPackage = mPackage;
	}

	@Override
	public void invokeEvent() {
		GameIntents.searchForPackage(mPackage);
	}
	
	public static void invoke()
	{
		GameIntents.searchForPackage("com.agameframework");
	}
	
	public static void invoke(String packageName)
	{
		GameIntents.searchForPackage(packageName);
	}
}