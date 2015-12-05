package net.franckbenault.testconcurrence.testfile;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.runners.model.TestTimedOutException;

public class SleepTestCase {

	@Rule public final TestRule timeout = Timeout.builder()
            .withTimeout(200, TimeUnit.MILLISECONDS)
            .withLookingForStuckThread(true).build();
	
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
