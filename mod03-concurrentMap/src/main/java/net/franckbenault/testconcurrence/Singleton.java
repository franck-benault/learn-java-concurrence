package net.franckbenault.testconcurrence;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Singleton {
	
	public static int SIZE = 3;
	
	private ConcurrentMap<Integer,Boolean> freeResources = new ConcurrentHashMap<Integer,Boolean>(SIZE);
	
	
	/** private constructor */
	private Singleton() {
		
		for(int i=0; i<SIZE ; i++) {
			freeResources.put(i,true);
		}
	
	}
	
	public int lockResource() {
		for(int i=0; i<SIZE ; i++) {
			if(freeResources.remove(i)!=null) {
				return i;
			}
		}
		return -1;
	}
	
	public void unlockResource(int index) {
		if(index>=0 && index<SIZE)
			freeResources.put(index, true);
	}

	/** unique instance */
	private static Singleton INSTANCE = null;

	/** access point */
	public synchronized static Singleton getInstance() {
		if (INSTANCE == null) {
				INSTANCE = new Singleton();
		}
		return INSTANCE;
	}

	
}
