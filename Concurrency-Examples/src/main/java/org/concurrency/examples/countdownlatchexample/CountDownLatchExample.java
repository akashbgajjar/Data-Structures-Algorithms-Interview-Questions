package org.concurrency.examples.countdownlatchexample;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchExample {

	public static void main(String[] args){
		
		final CountDownLatch countDownLatch = new CountDownLatch(3);
		
		Thread_1 cdl_1 = new Thread_1(countDownLatch);
		Thread_2 cdl_2 = new Thread_2(countDownLatch);
		Thread_3 cdl_3 = new Thread_3(countDownLatch);
		
		long start = System.currentTimeMillis();
		
		Thread thread_1 = new Thread(cdl_1);
		Thread thread_2 = new Thread(cdl_2);
		Thread thread_3 = new Thread(cdl_3);
		
		thread_1.start();
		thread_2.start();
		thread_3.start();
		
		System.out.println("Before termination to check for wait");
		
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Total time taken : " + (System.currentTimeMillis() - start));
		
	}
	
}
