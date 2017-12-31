package org.concurrency.examples.countdownlatchexample;

import java.util.concurrent.CountDownLatch;

public class Thread_3 extends AbstractRunnable{

	private final long time_out = 4000L;
	
	public Thread_3(CountDownLatch countDown){
		super(countDown);
	}
	
	public void execute() {
		try{
			System.out.println("Thread_3 waiting for " + time_out + " ms");
			Thread.sleep(time_out);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Thread_3 Done");
	}
}
