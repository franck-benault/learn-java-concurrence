package net.franckbenault.testconcurrence.testcalendar;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class ConcurrentCalendarTestCase {


	private long getDiffDays(Calendar calendar2, Calendar calendar1) {
		
		long diff = calendar2.getTime().getTime() - calendar1.getTime().getTime();
		long diffDays = diff / (24* 60 * 60 * 1000);
		return diffDays;
	}


	@Test
	public void testNoParallel() throws InterruptedException {
		Calendar calendar1 = Calendar.getInstance();		
		Calendar calendar2 = Calendar.getInstance();

		ThreadsLauncher t = new ThreadsLauncher();
		t.launch(calendar2, false, false);
		
		long diff = getDiffDays(calendar2, calendar1);
		System.out.println(diff);
		assertEquals(diff, ThreadsLauncher.loopSize*ThreadsLauncher.threadPoolSize);
	}
	
	@Test
	public void testParallelNoSynchronized() throws InterruptedException {
		Calendar calendar1 = Calendar.getInstance();		
		Calendar calendar2 = Calendar.getInstance();

		ThreadsLauncher t = new ThreadsLauncher();
		t.launch(calendar2, true, false);
		
		long diff = getDiffDays(calendar2, calendar1);
		System.out.println(diff);
		assertTrue(diff <= ThreadsLauncher.loopSize*ThreadsLauncher.threadPoolSize);
	}
	
	@Test
	public void testParallelSynchronized() throws InterruptedException {
		Calendar calendar1 = Calendar.getInstance();		
		Calendar calendar2 = Calendar.getInstance();

		ThreadsLauncher t = new ThreadsLauncher();
		t.launch(calendar2, true, true);
		
		long diff = getDiffDays(calendar2, calendar1);
		System.out.println(diff);
		assertEquals(diff, ThreadsLauncher.loopSize*ThreadsLauncher.threadPoolSize);
	}

}
