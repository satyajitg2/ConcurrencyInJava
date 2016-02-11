package com.concurrency.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MainBlockingQ {

	private static final int LENGTH_MAX_QUEUE = 2;

	public static void main(String[] args) {
		System.out.println("Producer & Consumer Problem");
		
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(LENGTH_MAX_QUEUE);
		
		Thread tProducer = new Thread(new ProducerQ(queue));
		Thread tConsumer = new Thread(new ConsumerQ(queue));
		
		tProducer.setName("Producer ");
		tConsumer.setName("Consumer ");
		tProducer.start();
		tConsumer.start();
	}
	
}

