package net.franckbenault.testconcurrence.testfile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import net.franckbenault.testconcurrence.testfile.WorkerThread;

public class ThreadsLauncher {

	public static int threadPoolSize = 50;
	public static int loopSize = 50;

	public void launch(File file, boolean isParallel, boolean isSynchronized)
			throws InterruptedException, IOException {

		FileOutputStream fos = new FileOutputStream(file);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

		ExecutorService executor;
		if (isParallel) {
			executor = Executors.newFixedThreadPool(threadPoolSize);
		} else {
			executor = Executors.newSingleThreadExecutor();
		}

		for (int i = 1; i <= threadPoolSize; i++) {
			WorkerThread workerThread = new WorkerThread(i, loopSize, bw,
					isSynchronized);
			executor.submit(workerThread);
		}

		executor.shutdown();
		while (!executor.isTerminated()) {
			Thread.sleep(10);
		}

		bw.close();
		fos.close();
	}
}
