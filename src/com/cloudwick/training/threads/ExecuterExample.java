package com.cloudwick.training.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExecutorService ser = Executors.newFixedThreadPool(5);

		for (int i = 0; i < 500; i++) {
			UserThread obj = new UserThread(1000000 + i);
			ser.execute(obj);
		}
		ser.shutdown();
		do{
			
		}while(!(ser.isTerminated()));
		
		System.out.println("All threads Finished  * * * * * ");

	}
}