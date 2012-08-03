package net.franckbenault.testconcurrence;

public class CountingManager {

	private long counter;
	
	public void increment() {
		counter++;
	}
	
	public long getCounter() {
		return counter;
	}
	
}
