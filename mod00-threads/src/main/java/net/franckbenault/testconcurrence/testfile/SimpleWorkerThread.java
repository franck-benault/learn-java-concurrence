package net.franckbenault.testconcurrence.testfile;

import java.util.concurrent.TimeUnit;


public class SimpleWorkerThread  implements Runnable {


	public SimpleWorkerThread() {
	}
	
	public void run() {	
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
}
