package com.revature.main;

@SuppressWarnings("serial")
public class CustomException extends Exception {
	public CustomException(String password) {
		super("Invalid Entry");
	}
}
