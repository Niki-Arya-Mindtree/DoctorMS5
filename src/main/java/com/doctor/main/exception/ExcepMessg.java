package com.doctor.main.exception;

import java.util.Date;

public class ExcepMessg {
	
	private Date TimeStamp;
	private String Message;
	
	
	public ExcepMessg(String message) {
		TimeStamp = new Date();
		Message = message;
		
	}
	public ExcepMessg() {
		super();
	}
	public ExcepMessg(Date timeStamp, String message) {
		super();
		TimeStamp = timeStamp;
		Message = message;
	}
	public Date getTimeStamp() {
		return TimeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		TimeStamp = timeStamp;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	
	
	
}
 