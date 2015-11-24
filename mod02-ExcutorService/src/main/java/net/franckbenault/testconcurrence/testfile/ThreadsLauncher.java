package net.franckbenault.testconcurrence.testfile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import net.franckbenault.testconcurrence.testfile.WorkerThread;

public class ThreadsLauncher {

	public static int threadPoolSize = 50;
	public static int loopSize = 40;

	public void launch(File file, boolean isParallel, boolean isSynchronized)
			throws InterruptedException, IOException {

		FileOutputStream fos = new FileOutputStream(file);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

		
		//prepare a set of threads
		Set<WorkerThread> threads = new HashSet<WorkerThread>();
		for (int i = 1; i <= threadPoolSize; i++) {
			WorkerThread workerThread = new WorkerThread(i, loopSize, bw,
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
			System.out.println("nbThreads "+ Thread.getAllStackTraces().keySet().size());
			Thread.sleep(1);
		}

		bw.close();
		fos.close();
	}
}
