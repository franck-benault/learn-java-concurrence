package net.franckbenault.testconcurrence.testcalendar;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsLauncher {

	public static int threadPoolSize = 30;
	public static int loopSize = 50;

	public void launch(Calendar calendar, boolean isParallel,
			boolean isSynchronized) throws InterruptedException {

		ExecutorService executor = Executors.newFixedThreadPool(threadPoolSize);

		if (isParallel) {
			for (int i = 1; i <= threadPoolSize; i++) {
				WorkerThread workerThread = new WorkerThread(i, loopSize, calendar, isSynchronized);
				executor.submit(workerThread);
			}

			executor.shutdown();
			while (!executor.isTerminated()) {
				Thread.sleep(10);
			}
		} else {
			for( int i=1; i<=threadPoolSize; i++) {
				WorkerThread workerThread = new WorkerThread(i, loopSize, calendar, isSynchronized);
				workerThread.call();
			}
		}
	}
}
