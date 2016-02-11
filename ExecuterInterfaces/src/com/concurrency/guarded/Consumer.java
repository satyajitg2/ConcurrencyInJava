package com.concurrency.guarded;

import java.util.Random;

public class Consumer implements Runnable {

	private Drop drop;
	
	public Consumer(Drop drop) {
		this.drop = drop;
	}

	@Override
	public void run() {
		System.out.println("Consumer " + Thread.currentThread().getName());
		String message = null;
		for (message = drop.take(); !message.equals(""); message = drop.take()) {
			//System.out.println("ConsumerQ Removes : " + message);
		}
		System.out.println("Consumer "+ message);
	}

}
