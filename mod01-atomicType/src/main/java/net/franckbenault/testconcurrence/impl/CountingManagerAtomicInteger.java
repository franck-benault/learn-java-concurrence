package net.franckbenault.testconcurrence.impl;

import java.util.concurrent.atomic.AtomicInteger;

import net.franckbenault.testconcurrence.CountingManager;

public class CountingManagerAtomicInteger implements CountingManager {

	private AtomicInteger counter;
	
	public CountingManagerAtomicInteger() {
		counter = new AtomicInteger(0);
	}
	
	public void increment() {
		counter.getAndIncrement();
	}
	
	public long getCounter() {
		return counter.get();
	}
	
}
