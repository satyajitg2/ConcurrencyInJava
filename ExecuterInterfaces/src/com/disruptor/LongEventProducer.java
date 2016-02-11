package com.disruptor;

import java.nio.ByteBuffer;

import com.lmax.disruptor.RingBuffer;

public class LongEventProducer {

	private final RingBuffer<LongEvent> ringBuffer;
	
	public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}
	
	public void onData(ByteBuffer bb) {
		long sequence = ringBuffer.next();  //Grab the next sequence
		try {
			//Get the entry in the Disruptor for the sequence. 
			LongEvent event = ringBuffer.get(sequence); 
			event.set(bb.getLong(0)); // Fill with data
		} finally {
			ringBuffer.publish(sequence);
		}
	}
}
