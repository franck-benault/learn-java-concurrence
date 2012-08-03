package net.franckbenault.testconcurrence;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CountingManagerTest {
	
	private static final int NB_THREAD = 10;
	private static final int LOOP_IN_THREAD = 250;
	

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
	public void testIncrementNonAtomic() {
	    CountingManager countingManager = new CountingManagerImpl();
		  
		// création d'une instance du Thread
	    UnThread[] threads = new UnThread[NB_THREAD];
	    // Activation du Thread
	    
	    for(int i=0; i<NB_THREAD; i++) {
	    	threads[i]= new UnThread(countingManager, LOOP_IN_THREAD, i);
	    	threads[i].start();
	    }	
	    
	    // tant que le thread est en vie...
	    while( isAlive(threads) ) {
	      // faire un traitement...
	      System.out.println("Line writes by main "+countingManager.getCounter());
	      try {
	        // et faire une pause
	        Thread.sleep(60);
	      }
	      catch (InterruptedException ex) {}
	    }
	    
	    System.out.println("Line writes by main "+countingManager.getCounter());

	    //assertEquals(countingManager.getCounter(),NB_THREAD*LOOP_IN_THREAD );
	}
	
	@Test
	public void testIncrementAtomic() {
	    CountingManager countingManager = new CountingManagerAtomic();
		  
		// création d'une instance du Thread
	    UnThread[] threads = new UnThread[NB_THREAD];
	    // Activation du Thread
	    
	    for(int i=0; i<NB_THREAD; i++) {
	    	threads[i]= new UnThread(countingManager, LOOP_IN_THREAD, i);
	    	threads[i].start();
	    }	
	    
	    // tant que le thread est en vie...
	    while( isAlive(threads) ) {
	      // faire un traitement...
	      System.out.println("Line writes by main "+countingManager.getCounter());
	      try {
	        // et faire une pause
	        Thread.sleep(60);
	      }
	      catch (InterruptedException ex) {}
	    }
	    
	      System.out.println("Line writes by main "+countingManager.getCounter());

	    //assertEquals(countingManager.getCounter(),NB_THREAD*LOOP_IN_THREAD );
	}


}
