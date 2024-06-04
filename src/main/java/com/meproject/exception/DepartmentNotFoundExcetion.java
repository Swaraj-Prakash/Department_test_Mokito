package com.meproject.exception;

public class DepartmentNotFoundExcetion extends Exception{

	public DepartmentNotFoundExcetion(String message) {
		super(message);
	}
	public DepartmentNotFoundExcetion() {
		super();
	}
	public DepartmentNotFoundExcetion(String message,Throwable cause) {
		super(message,cause);
	}
}
