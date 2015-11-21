package net.franckbenault.testconcurrence.testcalendar;

import java.util.Calendar;
import java.util.concurrent.Callable;

public class WorkerThread  implements Callable<Object> {

	private int threadNumber;
	private int loopSize;
	private Calendar calendar;
	private boolean isSynchronized;
	
	public WorkerThread(int threadNumber, int loopSize, Calendar calendar, boolean isSynchronized) {
		
		this.threadNumber = threadNumber;
		this.loopSize = loopSize;
		this.calendar = calendar;
		this.isSynchronized = isSynchronized;
	}
	
	public Object call() {
		
		for(int i=1; i<=loopSize; i++) {
			try {
				if(isSynchronized) {
					synchronized(calendar) {
						 calendar.add(Calendar.DATE, 1);
					}
				} else {
					 calendar.add(Calendar.DATE, 1);
				}
				
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
		
	public String toString() {
		return "Thread "+threadNumber;
	}

}
