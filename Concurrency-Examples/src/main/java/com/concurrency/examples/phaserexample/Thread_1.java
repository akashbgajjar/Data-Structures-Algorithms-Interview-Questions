package com.concurrency.examples.phaserexample;

import java.util.concurrent.Phaser;

/**
 * 
 * @author Akash Gajjar
 *
 */
public class Thread_1 extends AbstractRunnable{

	private final long timeout = 1000L;
	
	public Thread_1(Phaser phaser){
		super(phaser);
	}

	@Override
	public void execute() {
		try{
			System.out.println("Thread_1 waiting for " + timeout + " ms");
			Thread.sleep(timeout);
			
			Thread_4 thread_4 = new Thread_4(phaser);
			Thread thread = new Thread(thread_4);
			thread.start();
			
			Thread_5 thread_5 = new Thread_5(phaser);
			Thread _thread = new Thread(thread_5);
			_thread.start();
			
			this.phaser.arriveAndAwaitAdvance();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("Thread_1 party arrived");
		}
		
	}

}
