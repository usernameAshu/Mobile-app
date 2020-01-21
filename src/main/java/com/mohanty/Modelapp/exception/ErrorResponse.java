package com.mohanty.Modelapp.exception;

import java.util.Date;

public class ErrorResponse {

	private Date date;
	private String message;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ErrorResponse(Date date, String message) {
		super();
		this.date = date;
		this.message = message;
	}

	
}
