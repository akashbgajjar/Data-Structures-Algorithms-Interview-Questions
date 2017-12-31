package org.concurrency.examples.phaserexample;

import java.util.concurrent.Phaser;

/**
 * 
 * @author Akash Gajjar
 *
 */
public class Thread_2 extends AbstractRunnable{

	private final long timeout = 5000L;
	
	public Thread_2(Phaser phaser){
		super(phaser);
	}

	@Override
	public void execute() {
		try{
			System.out.println("Thread_2 waiting for " + timeout + " ms");
			Thread.sleep(timeout);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("Thread_2 party arrived");
		}
	}
}
