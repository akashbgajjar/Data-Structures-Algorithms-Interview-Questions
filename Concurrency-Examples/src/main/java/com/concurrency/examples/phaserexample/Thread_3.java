package com.concurrency.examples.phaserexample;

import java.util.concurrent.Phaser;

/**
 * 
 * @author Akash Gajjar
 *
 */
public class Thread_3 extends AbstractRunnable{

	private final long timeout = 2000L;
	
	public Thread_3(Phaser phaser){
		super(phaser);
	}
	
	@Override
	public void execute() {
		try{
			System.out.println("Thread_3 waiting for " + timeout + " ms");
			Thread.sleep(timeout);
			Thread_4 thread_4 = new Thread_4(phaser);
			Thread thread = new Thread(thread_4);
			thread.start();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("Thread_3 party arrived");
		}
	}

}
