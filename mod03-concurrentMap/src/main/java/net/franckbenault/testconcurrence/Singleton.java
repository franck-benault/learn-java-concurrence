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
	
	public synchronized int lockResource() {
		for(int i=0; i<SIZE ; i++) {
			if(freeResources.remove(i)!=null) {
				return i;
			}
		}
		return -1;
	}
	
	public synchronized void unlockResource(int index) {
		if(index>=0 && index<SIZE)
			freeResources.putIfAbsent(index, true);
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
