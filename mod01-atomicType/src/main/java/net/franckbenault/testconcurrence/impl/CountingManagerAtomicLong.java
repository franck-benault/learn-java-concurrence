package net.franckbenault.testconcurrence.impl;

import java.util.concurrent.atomic.AtomicLong;

import net.franckbenault.testconcurrence.CountingManager;

public class CountingManagerAtomicLong implements CountingManager {

	private AtomicLong counter;
	
	public CountingManagerAtomicLong() {
		counter = new AtomicLong(0);
	}
	
	public void increment() {
		counter.getAndIncrement();
	}
	
	public long getCounter() {
		return counter.get();
	}
	
}
