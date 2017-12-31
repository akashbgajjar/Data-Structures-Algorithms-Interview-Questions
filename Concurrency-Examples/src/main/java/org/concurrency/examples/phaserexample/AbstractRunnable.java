package org.concurrency.examples.phaserexample;

import java.util.concurrent.Phaser;

public abstract class AbstractRunnable implements Runnable{

	final Phaser phaser;
	
	public AbstractRunnable(Phaser phaser){
		this.phaser = phaser;
		this.phaser.register();
	}
	
	public void run(){
		try{
			execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.phaser.arriveAndDeregister();
		}
	}
	
	public abstract void execute();
	
}