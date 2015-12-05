package net.franckbenault.testconcurrence.testfile;

import org.junit.Test;

public class SimpleThreadLaunchTestCase {



	@Test(expected=IllegalThreadStateException.class)
	public void test() {
		Thread t1 = new Thread(new SimpleWorkerThread());
		t1.start();
		//error t1 is already started
		t1.start();
		
				
	}

}
