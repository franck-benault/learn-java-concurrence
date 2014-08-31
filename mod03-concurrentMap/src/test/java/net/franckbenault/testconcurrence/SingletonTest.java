package net.franckbenault.testconcurrence;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SingletonTest {
	
	private static Singleton singleton;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		singleton = Singleton.getInstance();
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

	@Test
	public void testLockResource() {

		int i1 = singleton.lockResource();
		assertTrue(i1==0);
	}

	@Test
	public void testUnlockResource() {
		singleton.unlockResource(0);
		
	}


}
