package net.franckbenault.testconcurrence;

public class WorkerThread  implements Runnable {

	private int threadNumber;
	private Singleton singleton;
	
	public WorkerThread(int threadNumber, Singleton singleton) {
		
		this.threadNumber = threadNumber;
		this.singleton = singleton;
	}
	
	private void waiting() {
		try {
			System.out.println("thread "+threadNumber+" is waiting");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		
		int resource= singleton.lockResource();
		waiting();
		
		while(resource!=-1) {
			waiting();
			resource= singleton.lockResource();
			
		}
		
		waiting();
		System.out.println("thread "+threadNumber+" is ending");
		singleton.unlockResource(resource);
	}
	
	
	public String toString() {
		return "Thread "+threadNumber;
	}

}
