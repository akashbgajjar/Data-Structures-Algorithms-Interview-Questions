package org.concurrency.examples.countdownlatchexample;

import java.util.concurrent.CountDownLatch;

public class Thread_2 extends AbstractRunnable{

	private final long time_out = 2000L;
	
	public Thread_2(CountDownLatch countDown){
		super(countDown);
	}
	
	public void execute() {
		try{
			System.out.println("Thread_2 waiting for " + time_out + " ms");
			Thread.sleep(time_out);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Thread_2 Done");
	}
}
