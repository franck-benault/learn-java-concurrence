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
		
		for(int i=1; i<=loopSize; i++) {
			try {
				System.out.println(command(i));
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public String command(int i) {
		return "Callable thread "+threadNumber+"-loopNumber "+i;
	}
	
	public String toString() {
		return "Thread "+threadNumber;
	}

}
