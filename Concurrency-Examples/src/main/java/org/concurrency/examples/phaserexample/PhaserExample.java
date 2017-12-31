package com.concurrency.examples.phaserexample;

import java.util.concurrent.Phaser;

/**
 * 
 * @author Akash Gajjar
 *
 */
public class PhaserExample {

	public static void main(String[] args){
		final Phaser phaser = new Phaser(){  
			protected boolean onAdvance(int phase, int registeredParties) {
				System.out.println("Phase: " + phase + " Registered Parties: " + registeredParties);
				return phase >= 1 || registeredParties == 0;  
			}
		};
		
		phaser.register();
		
		Thread_1 phaser_1 = new Thread_1(phaser);
		Thread_2 phaser_2 = new Thread_2(phaser);
		Thread_3 phaser_3 = new Thread_3(phaser);
		
		Thread thread_1 = new Thread(phaser_1);
		Thread thread_2 = new Thread(phaser_2);
		Thread thread_3 = new Thread(phaser_3);
		
		long start = System.currentTimeMillis();
		
		thread_1.start();
		thread_2.start();
		thread_3.start();
		
		phaser.arriveAndAwaitAdvance();
		
		System.out.println("Before Termination to check for wait");
		
		System.out.println("Total time taken : " + (System.currentTimeMillis() - start));
	}
	
}
