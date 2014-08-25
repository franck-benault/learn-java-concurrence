package net.franckbenault.testconcurrence.runnable;

public class WorkerThread  implements Runnable {

	private int threadNumber;
	private int loopSize;
	
	public WorkerThread(int threadNumber, int loopSize) {
		
		this.threadNumber = threadNumber;
		this.loopSize = loopSize;
	}
	
	public void run() {
		
		for(int i=0; i<loopSize; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String toString() {
		return "Thread "+threadNumber;
	}

}
