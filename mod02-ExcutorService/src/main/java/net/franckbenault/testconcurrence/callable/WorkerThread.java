package net.franckbenault.testconcurrence.callable;

import java.util.concurrent.Callable;

public class WorkerThread  implements Callable<Object> {

	private int threadNumber;
	private int loopSize;
	
	public WorkerThread(int threadNumber, int loopSize) {
		
		this.threadNumber = threadNumber;
		this.loopSize = loopSize;
	}
	
	public Object call() {
		
		for(int i=0; i<loopSize; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public String toString() {
		return "Thread "+threadNumber;
	}

}
