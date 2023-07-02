package com.insta.util;

import java.time.LocalDateTime;

public class ErrorInfo {

	private String message;
	
	private String details;
	
	private LocalDateTime timeStamp;

	public ErrorInfo(String message, String details, LocalDateTime timeStamp) {
		super();
		this.message = message;
		this.details = details;
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
	
	
	
}
