package net.franckbenault.testconcurrence.testfile;


import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class SleepTestCase {
	
	@Test
	public void test01OldWay() throws InterruptedException {
		
		//sleep 1000 (what ?) millisecondes of course
		Thread.sleep(100);
	}

	@Test
	public void test02NewWayJava5() throws InterruptedException {
		
		
		TimeUnit.MILLISECONDS.sleep(100);
		//TimeUnit is a enumeration and the code is more readable
		//TimeUnit.SECONDS
		//TimeUnit.DAYS
	}
	
	
}
