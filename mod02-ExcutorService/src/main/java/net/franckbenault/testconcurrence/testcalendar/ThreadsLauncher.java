package net.franckbenault.testconcurrence.testcalendar;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsLauncher {

	public static int threadPoolSize = 30;
	public static int loopSize = 50;

	public void launch(Calendar calendar, boolean isParallel,
			boolean isSynchronized) throws InterruptedException {
		
		//prepare a set of threads
		Set<WorkerThread> threads = new HashSet<WorkerThread>();
		for (int i = 1; i <= threadPoolSize; i++) {
			WorkerThread workerThread = new WorkerThread(i, loopSize, calendar,
					isSynchronized);
			threads.add(workerThread);
		}

		ExecutorService executor;
		if (isParallel) {
			executor = Executors.newFixedThreadPool(threadPoolSize);
		} else {
			executor = Executors.newSingleThreadExecutor();
		}
		
		executor.invokeAll(threads);
		
		executor.shutdown();
		while (!executor.isTerminated()) {
			Thread.sleep(10);
		}
	}
}
