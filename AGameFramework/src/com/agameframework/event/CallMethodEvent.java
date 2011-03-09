package com.agameframework.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.agameframework.debug.Debug;
import com.agameframework.interfaces.IEvent;

public class CallMethodEvent implements IEvent
{
	private final Object mOwner;
	private Method mMethod;

	public CallMethodEvent(Object owner,String methodName) {
		this.mOwner = owner;
		try {
			mMethod = owner.getClass().getMethod(methodName);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			Debug.print("no such method");
			e.printStackTrace();
		}
	}

	@Override
	public void invokeEvent() {
		try {
			mMethod.invoke(mOwner);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
