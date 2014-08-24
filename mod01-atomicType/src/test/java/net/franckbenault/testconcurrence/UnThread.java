

package net.franckbenault.testconcurrence;

public class UnThread extends Thread{
	
	private CountingManager countingManager;
	private int loopSize;
	
	public UnThread(CountingManager countingManager, int loopSize) {
		this.countingManager = countingManager;
		this.loopSize=loopSize;
	}
	
	
	  public void run() {
	    for(int i=0; i<loopSize; i++) {
	      countingManager.increment();
	      try {
	        // pause
	        Thread.sleep(1);
	      }
	      catch (InterruptedException ex) {}
	    }
	  }	


}