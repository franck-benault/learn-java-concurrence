package net.franckbenault.testconcurrence.callable;

import static org.junit.Assert.*;

import org.junit.Test;

public class WorkerThreadTest {

	@Test
	public void testToString() {
		WorkerThread thread = new WorkerThread(1,1);
		assertEquals(thread.toString(), "Thread 1");
	}

}
