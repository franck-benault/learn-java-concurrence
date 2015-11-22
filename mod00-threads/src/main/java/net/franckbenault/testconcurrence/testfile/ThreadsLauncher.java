package net.franckbenault.testconcurrence.testfile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


import net.franckbenault.testconcurrence.testfile.WorkerThread;

public class ThreadsLauncher {

	public static int threadPoolSize = 50;
	public static int loopSize = 50;

	public void launch(File file, boolean isParallel, boolean isSynchronized)
			throws InterruptedException, IOException {

		FileOutputStream fos = new FileOutputStream(file);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

		List<Thread> threads = new ArrayList<Thread>(threadPoolSize);
		for (int i = 1; i <= threadPoolSize; i++) {
			threads.add(new Thread(new WorkerThread(i, loopSize, bw,
					isSynchronized)));
		}

		if (isParallel) {
			for (Thread thread : threads) {
				thread.start();
			}

			for (Thread thread : threads) {
				thread.join();
			}

		} else {
			for (Thread thread : threads) {
				thread.start();
				thread.join();
			}
		}

		bw.close();
		fos.close();
	}
}
