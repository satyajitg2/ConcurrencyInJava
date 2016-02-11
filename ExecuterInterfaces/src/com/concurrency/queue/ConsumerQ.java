package com.concurrency.queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ConsumerQ implements Runnable {

	private BlockingQueue<String> queue;

	public ConsumerQ(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		Random random = new Random();
		System.out.println("Consumer " + Thread.currentThread().getName());

		while(true) {
			if (!queue.isEmpty()) {
				String s = queue.remove();
				//System.out.println("ConsumerQ Removes : " + s);
			}
		}
	}

}
