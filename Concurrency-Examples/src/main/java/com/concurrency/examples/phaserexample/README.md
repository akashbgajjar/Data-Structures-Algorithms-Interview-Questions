Phaser:

Java Doc: https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Phaser.html

Description:
	In below example Main Thread will wait for all five threads and Thread_1 will wait for Thread_4 and Thread_5. Phaser is an exact latch that helps to achieve below scenario.
	
						Main Thread
						 |
						 |
		____________________________________________________________________
		|				 |				   |
		|				 |				   |
	  Thread_1		  		Thread_2		   	Thread_3
	    |
	    |
  	____________________________
  	|			   |
  	|			   |
	Thread_4		Thread_5

O/P of above scenario:

	Thread_2 waiting for 5000 ms
	Thread_1 waiting for 1000 ms
	Thread_3 waiting for 2000 ms
	Thread_4 waiting for 1000 ms
	Thread_5 waiting for 1000 ms
	Thread_3 party arrived
	Thread_4 party arrived
	Thread_5 party arrived
	Thread_2 party arrived
	Phase: 0 Registered Parties: 2
	Thread_1 party arrived
	Before Termination to check for wait
	Total time taken : 5006
