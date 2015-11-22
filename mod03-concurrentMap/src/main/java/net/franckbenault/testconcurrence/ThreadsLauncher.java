package net.franckbenault.testconcurrence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsLauncher {

	private int threadPoolSize = 100;
	
	public void launch() throws InterruptedException {
		
		ExecutorService executor = Executors.newFixedThreadPool(threadPoolSize);
		
		Singleton singleton = Singleton.getInstance();
		for(int i=1; i<=threadPoolSize; i++) {
			WorkerThread workerThread = new WorkerThread(i, singleton );
			executor.submit(workerThread);
		}
		
		executor.shutdown();
		while(!executor.isTerminated()) {
			Thread.sleep(100);
		}
	}
}
