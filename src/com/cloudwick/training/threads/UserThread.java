package com.cloudwick.training.threads;

public class UserThread extends Thread {

	private int number;
	

	public UserThread(int num) {
		this.number = num;

	}

	public void run() {
		int sum = 0;
		for (int i = 0; i <number; i++) {
			sum += i;
		}
		System.out.println("Sum:"+sum +":Thread:"+Thread.currentThread());
	}

}
