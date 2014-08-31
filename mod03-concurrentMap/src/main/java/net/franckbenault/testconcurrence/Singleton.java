package net.franckbenault.testconcurrence;

public class Singleton {
	
	
	/** private constructor */
	private Singleton() {
	
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
