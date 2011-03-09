package com.agameframework.event;

import com.agameframework.interfaces.IEvent;
import com.agameframework.settings.GameSettings;
import com.agameframework.utils.GameIntents;

public class SendMailEvent implements IEvent{

	private String mSubject;
	private String mBody;
	private String mTo;

	public SendMailEvent(String subject, String body, String to) {
		mSubject = subject;
		mBody = body;
		mTo = to;
	}
	public SendMailEvent() {
		mSubject = "AGameFramework: ";
		mBody = "";
		mTo = GameSettings.DEVELOPER_MAIL;
	}

	@Override
	public void invokeEvent() {
		GameIntents.sendMail(mSubject, mBody, mTo);
	}

}
