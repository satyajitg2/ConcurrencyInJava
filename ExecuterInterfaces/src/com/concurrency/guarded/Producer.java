package com.concurrency.guarded;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

import com.file.input.ReadInputFile;

public class Producer implements Runnable {
	private Drop drop;
	
	public Producer(Drop drop) {
		this.drop = drop;
	}

	@Override
	public void run() {
		System.out.println("Producer " + Thread.currentThread().getName());
		long startTime = System.currentTimeMillis();
		String path = "textfile.txt";
		
		ReadInputFile streams = new ReadInputFile(path);
		streams.setup();
		String strLine = null;
		
		try {
			while( (strLine = streams.readLines()) != null) {
				drop.put(strLine);
			}
			streams.closeFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Producer" + strLine);
        String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
            };

		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		
		NumberFormat formatter = new DecimalFormat("#0.000000");
		System.out.println(totalTime);
		System.out.print("Execution time is " + formatter.format((totalTime) / 1000d) + " seconds");
		

        Random random = new Random();
        for(int i=0;i<importantInfo.length;i++) {
        	
        	drop.put(importantInfo[i]);
        	//System.out.println(Thread.currentThread().getName() + " Message put");
        	
/*        	try {
        		System.out.println(Thread.currentThread().getName() + " Sleeping");
        		Thread.sleep(random.nextInt(5000));
        	} catch (InterruptedException ie) {}
*/        	
        	//drop.put("DONE");
        }

	}

}
