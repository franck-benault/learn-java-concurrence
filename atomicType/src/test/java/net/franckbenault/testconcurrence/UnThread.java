

package net.franckbenault.testconcurrence;

public class UnThread extends Thread{
	
	private CountingManager countingManager;
	private int size;
	private int number;
	
	public UnThread(CountingManager countingManager, int size, int number) {
		this.countingManager = countingManager;
		this.size=size;
		this.number=number;
	}
	
	
	  public void run() {
	    for(int i=0; i<size; i++) {
	      // traitement
	      //System.out.println("Ligne affichée par le thread "+number+" "+countingManager.getCounter());
	      countingManager.increment();
	      try {
	        // pause
	        Thread.sleep(1);
	      }
	      catch (InterruptedException ex) {}
	    }
	  }	
	}
