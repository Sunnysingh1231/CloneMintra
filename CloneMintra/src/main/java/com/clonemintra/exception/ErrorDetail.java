package com.clonemintra.exception;

import java.time.LocalDateTime;

public class ErrorDetail {

	private LocalDateTime timeStamp;

	private String message;

	private String URI;

	//Constructor using field---------------------------------------------------------------
	
	public ErrorDetail(LocalDateTime timeStamp, String message, String uRI) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		URI = uRI;
	}
	
	//getter and setter---------------------------------------------------------------
	
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getURI() {
		return URI;
	}

	public void setURI(String uRI) {
		URI = uRI;
	}

}
