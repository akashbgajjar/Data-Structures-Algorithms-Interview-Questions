package org.concurrency.examples.countdownlatchexample;

import java.util.concurrent.CountDownLatch;

public class Thread_1 extends AbstractRunnable{

	private final long time_out = 3000L;
	
	public Thread_1(CountDownLatch countDown){
		super(countDown);
	}
	
	public void execute() {
		try{
			System.out.println("Thread_1 waiting for " + time_out + " ms");
			Thread.sleep(time_out);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Thread_1 Done");
	}
}
