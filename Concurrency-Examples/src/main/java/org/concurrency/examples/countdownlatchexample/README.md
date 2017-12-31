CountDownLatch

Java Doc: https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/CountDownLatch.html

Description:
	In below example Main Thread will wait for all three threads.
	
						Main Thread
						 |
						 |
		____________________________________________________________________
		|				 |				   |
		|				 |				   |
	  Thread_1		  		Thread_2		   	Thread_3
	  
O/P of above scenario:

	Before termination to check for wait
	Thread_2 waiting for 2000 ms
	Thread_1 waiting for 3000 ms
	Thread_3 waiting for 4000 ms
	Thread_2 Done
	Thread_1 Done
	Thread_3 Done
	Total time taken : 4004