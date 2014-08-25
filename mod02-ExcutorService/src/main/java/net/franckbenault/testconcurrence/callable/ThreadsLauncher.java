package net.franckbenault.testconcurrence.callable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsLauncher {

	private int threadPoolSize = 10;
	
	public void launch() throws InterruptedException {
		
		ExecutorService executor = Executors.newFixedThreadPool(threadPoolSize);
		
		for(int i=1; i<=threadPoolSize; i++) {
			WorkerThread workerThread = new WorkerThread(i, 20);
			executor.submit(workerThread);
		}
		
		executor.shutdown();
		while(!executor.isTerminated()) {
			Thread.sleep(100);
		}
	}
}
