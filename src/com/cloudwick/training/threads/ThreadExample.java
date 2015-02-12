package com.cloudwick.training.threads;

import java.util.ArrayList;
import java.util.List;

public class ThreadExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		List<Thread> threadList = new ArrayList<>();

		for (int i = 0; i < 500; i++) {
			UserThread obj = new UserThread(1000000 + i);

			obj.setName("Customer: " + i);
			if (i > 50 && i < 100) {
				obj.setPriority(Thread.MIN_PRIORITY);
				obj.start();
			}
			threadList.add(obj);
		}

		int running = 0;
		do {
			running = 0;
			for (Thread t : threadList) {
				if (t.isAlive()) {
					running++;
				}

			}
		} while (running != 0);
		Thread.currentThread().sleep(5000);
		System.out.println("All threads done  * * * * * *");
	}

}
