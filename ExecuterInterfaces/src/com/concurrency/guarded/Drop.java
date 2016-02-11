package com.concurrency.guarded;

public class Drop {
	 // Message sent from producer to consumer.
    private String message;
    // True if consumer should wait for producer to send message,
    // false if producer should wait for consumer to retrieve message.
    private boolean empty = true;

    public synchronized void put(String message) {
    	//Wait until the message has been received
    	while(!empty) {
    		try{
    			wait();
    		} catch(InterruptedException e) {}
    	}
    	
    	empty = false;
    	this.message = message;
    	notify();
    }
    
    public synchronized String take() {
    	while(empty) {
    		try {
    			wait();
    		} catch(InterruptedException e) {}
    	}
    	
    	empty = true;
    	
    	notifyAll();
    	return message;
    }
    
}
