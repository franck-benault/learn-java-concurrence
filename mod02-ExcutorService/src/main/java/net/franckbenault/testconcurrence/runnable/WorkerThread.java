package net.franckbenault.testconcurrence.runnable;

public class WorkerThread  implements Runnable {

	private int threadNumber;
	private int loopSize;
	
	public WorkerThread(int threadNumber, int loopSize) {
		
		this.threadNumber = threadNumber;
		this.loopSize = loopSize;
	}
	
	public void run() {
		
		for(int i=1; i<=loopSize; i++) {
			try {
				System.out.println(command(i));
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String command(int i) {
		return "Runable thread "+threadNumber+"-loopNumber "+i;
	}	
	
	public String toString() {
		return "Thread "+threadNumber;
	}

}
