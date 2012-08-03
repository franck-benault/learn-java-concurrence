package net.franckbenault.testconcurrence;

import java.util.concurrent.atomic.AtomicLong;

public class CountingManagerAtomic implements CountingManager {

	private AtomicLong counter;
	
	public CountingManagerAtomic() {
		counter = new AtomicLong(0);
	}
	
	public void increment() {
		counter.getAndIncrement();
	}
	
	public long getCounter() {
		return counter.get();
	}
	
}
