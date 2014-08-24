package net.franckbenault.testconcurrence;

import static org.junit.Assert.*;
import net.franckbenault.testconcurrence.CountingManager;
import net.franckbenault.testconcurrence.impl.CountingManagerAtomicInteger;
import net.franckbenault.testconcurrence.impl.CountingManagerAtomicLong;
import net.franckbenault.testconcurrence.impl.CountingManagerImpl;
import net.franckbenault.testconcurrence.UnThread;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CountingManagerTest {
	
	private static final int NB_THREAD = 10;
	private static final int LOOP_IN_THREAD = 500;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	private boolean isAlive(UnThread[] threads) {
	    for(int i=0; i<NB_THREAD; i++) {
	    	if(threads[i].isAlive())
	    		return true;
	    }			
		return false;
	}
	
	@Test
	public void testIncrementNonAtomic() throws InterruptedException {
	    CountingManager countingManager = new CountingManagerImpl();
		  
		//pool threads creation
	    UnThread[] threads = new UnThread[NB_THREAD];
	    
	    //activation the threads
	    for(int i=0; i<NB_THREAD; i++) {
	    	threads[i]= new UnThread(countingManager, LOOP_IN_THREAD);
	    	threads[i].start();
	    }	
	    
	    //While one thread is alive
	    while( isAlive(threads) ) {
	      //print global status...
	      System.out.println("Line writes by main "+countingManager.getCounter());
	      Thread.sleep(100);
	    }
	    
	    System.out.println("Line writes by main "+countingManager.getCounter());
	    assertTrue(countingManager.getCounter()<=NB_THREAD*LOOP_IN_THREAD );
	}
	
	@Test
	public void testIncrementAtomicLong() throws InterruptedException {
	    CountingManager countingManager = new CountingManagerAtomicLong();
		  
		//pool threads creation
	    UnThread[] threads = new UnThread[NB_THREAD];
	    
	    //activation the threads
	    for(int i=0; i<NB_THREAD; i++) {
	    	threads[i]= new UnThread(countingManager, LOOP_IN_THREAD);
	    	threads[i].start();
	    }	
	    
	    //While one thread is alive
	    while( isAlive(threads) ) {
	      //print global status...
	      System.out.println("Line writes by main "+countingManager.getCounter());
	      Thread.sleep(100);
	    }
	    
	    System.out.println("Line writes by main "+countingManager.getCounter());
	    assertEquals(countingManager.getCounter(),NB_THREAD*LOOP_IN_THREAD );
	}


	@Test
	public void testIncrementAtomicInteger() throws InterruptedException {
	    CountingManager countingManager = new CountingManagerAtomicInteger();
		  
		//pool threads creation
	    UnThread[] threads = new UnThread[NB_THREAD];
	    
	    //activation the threads
	    for(int i=0; i<NB_THREAD; i++) {
	    	threads[i]= new UnThread(countingManager, LOOP_IN_THREAD);
	    	threads[i].start();
	    }	
	    
	    //While one thread is alive
	    while( isAlive(threads) ) {
	      //print global status...
	      System.out.println("Line writes by main "+countingManager.getCounter());
	      Thread.sleep(100);
	    }
	    
	    System.out.println("Line writes by main "+countingManager.getCounter());
	    assertEquals(countingManager.getCounter(),NB_THREAD*LOOP_IN_THREAD );
	}

}
