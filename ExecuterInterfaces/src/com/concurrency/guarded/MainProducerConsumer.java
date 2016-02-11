package com.concurrency.guarded;

public class MainProducerConsumer {

	public static void main(String[] args) {
		System.out.println("Producer & Consumer Problem");
		Drop drop = new Drop();
		
		Thread tProducer = new Thread(new Producer(drop));
		Thread tConsumer = new Thread(new Consumer(drop));
		
		tProducer.setName("Producer ");
		tConsumer.setName("Consumer ");
		tConsumer.start();
		tProducer.start();
	}
	
}
