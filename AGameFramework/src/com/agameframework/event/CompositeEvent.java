package com.agameframework.event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.agameframework.interfaces.IEvent;

public class CompositeEvent implements IEvent{

	protected ArrayList<IEvent> mEventList;

	public CompositeEvent(List<IEvent> list)
	{
		mEventList = new ArrayList<IEvent>(list);
	}

	public CompositeEvent(Collection<IEvent> list)
	{
		mEventList = new ArrayList<IEvent>(list);
		
	}
	public CompositeEvent(IEvent e1, IEvent e2) {
		mEventList = new ArrayList<IEvent>();
		mEventList.add(e1);
		mEventList.add(e2);
	}
	
	public CompositeEvent(IEvent e1, IEvent e2, IEvent e3) {
		mEventList = new ArrayList<IEvent>();
		mEventList.add(e1);
		mEventList.add(e2);
		mEventList.add(e3);
	}
	
	public CompositeEvent(IEvent e1, IEvent e2, IEvent e3, IEvent e4) {
		mEventList = new ArrayList<IEvent>();
		mEventList.add(e1);
		mEventList.add(e2);
		mEventList.add(e3);
		mEventList.add(e4);
	}
	
	public CompositeEvent(IEvent e1, IEvent e2, IEvent e3, IEvent e4, IEvent e5) {
		mEventList = new ArrayList<IEvent>();
		mEventList.add(e1);
		mEventList.add(e2);
		mEventList.add(e3);
		mEventList.add(e4);
		mEventList.add(e5);
	}

	public CompositeEvent(IEvent e1, IEvent e2, IEvent e3, IEvent e4, IEvent e5,IEvent e6) {
		mEventList = new ArrayList<IEvent>();
		mEventList.add(e1);
		mEventList.add(e2);
		mEventList.add(e3);
		mEventList.add(e4);
		mEventList.add(e5);
		mEventList.add(e6);
	}
	
	public CompositeEvent() {
		mEventList = new ArrayList<IEvent>();
	}

	public void add(IEvent event)
	{
		mEventList.add(event);
	}

	public void remove(IEvent event)
	{
		mEventList.remove(event);
	}

	@Override
	public void invokeEvent() {
		
		int size = mEventList.size();
		for(int i = 0; i != size; i++)
		{
			mEventList.get(i).invokeEvent();
		}
	}

}
