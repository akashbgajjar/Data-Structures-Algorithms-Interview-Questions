package com.concurrency.examples.phaserexample;

import java.util.concurrent.Phaser;

/**
 * 
 * @author Akash Gajjar
 *
 */
public class Thread_1 extends AbstractRunnable{

	private final long timeout = 10000L;
	
	public Thread_1(Phaser phaser){
		super(phaser);
	}

	@Override
	public void execute() {
		try{
			System.out.println("Thread_1 waiting for " + timeout + " ms");
			Thread.sleep(timeout);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("Thread_1 party arrived");
		}
		
	}

}
