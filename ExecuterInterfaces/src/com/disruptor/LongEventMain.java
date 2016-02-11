package com.disruptor;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

public class LongEventMain {

	public static void main(String[] args) {
		// Executor that will be used to construct new threads for consumers
		Executor threadFactory = Executors.newCachedThreadPool();
		
		//The factory for the event.
		LongEventFactory eventFactory = new LongEventFactory();
		
		//Specify the size of the Ring Buffer, must be power of 2.
		int ringBufferSize = 1024;
		
		//Construt the Disruptor
		Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(eventFactory, ringBufferSize, threadFactory);
		
		//Connect the handler
		disruptor.handleEventsWith(new LongEventHandler());
		
		//Start the disruptor
		disruptor.start();
		
		//Get the Ring buffer from the disruptor to be used for Publishing.
		RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
		
		LongEventProducer producer = new LongEventProducer(ringBuffer);
		
		ByteBuffer bb = ByteBuffer.allocate(8);
		
		for (long l = 0; true; l++)
        {
            bb.putLong(0, l);
            producer.onData(bb);
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		
	}
}
