package net.franckbenault.testconcurrence.impl;

import net.franckbenault.testconcurrence.CountingManager;

public class CountingManagerImpl implements CountingManager {

	private long counter;
	
	public void increment() {
		counter++;
	}
	
	public long getCounter() {
		return counter;
	}
	
}
