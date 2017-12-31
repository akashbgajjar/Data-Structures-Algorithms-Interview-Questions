package org.concurrency.examples.phaserexample;

import java.util.concurrent.Phaser;

public class Thread_5 extends AbstractRunnable{

	private final long timeout = 1000L;
	
	public Thread_5(Phaser phaser) {
		super(phaser);
	}

	@Override
	public void execute() {
		try{
			System.out.println("Thread_5 waiting for " + timeout + " ms");
			Thread.sleep(timeout);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("Thread_5 party arrived");
		}
	}

}
