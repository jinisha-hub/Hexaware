package com.hexaware.exceptions;

public class GlobalHandlerException implements Thread.UncaughtExceptionHandler {
	public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Unhandled Exception caught: " + t.getName());
        System.out.println("The Message is: " + e.getMessage());
        // Optionally, print the stack trace for more details
        e.printStackTrace(); 
    }

}
