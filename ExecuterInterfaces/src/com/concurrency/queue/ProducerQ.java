package com.concurrency.queue;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.concurrent.BlockingQueue;

import com.file.input.ReadInputFile;

public class ProducerQ implements Runnable {
	private BlockingQueue<String> queue;

	public ProducerQ(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		System.out.println("Producer " + Thread.currentThread().getName());
		long startTime = System.currentTimeMillis();
		String path = "textfile.txt";
		
		ReadInputFile streams = new ReadInputFile(path);
		streams.setup();
		
		try {
			String strLine;
			while( (strLine = streams.readLines()) != null) {
				queue.put(strLine);
			}
			System.out.println("ProducerQ puts element: " + strLine);

			streams.closeFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		
		NumberFormat formatter = new DecimalFormat("#0.000000");
		System.out.println(totalTime);
		System.out.print("Execution time is " + formatter.format((totalTime) / 1000d) + " seconds");


	}

}
