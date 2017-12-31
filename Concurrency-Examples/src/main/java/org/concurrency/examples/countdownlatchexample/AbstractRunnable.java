package org.concurrency.examples.countdownlatchexample;

import java.util.concurrent.CountDownLatch;

/**
 * 
 * @author Akash Gajjar
 *
 */
public abstract class AbstractRunnable implements Runnable{

	final CountDownLatch countDownLatch;
	
	public AbstractRunnable(CountDownLatch countDownLatch){
		this.countDownLatch = countDownLatch;
	}
	
	public void run(){
		try{
			execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.countDownLatch.countDown();
		}
	}
	
	public abstract void execute();
	
}