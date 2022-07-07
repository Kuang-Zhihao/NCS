package com.ncs.empconsole.exception;

import java.time.LocalDateTime;

public class ExceptionTemplate {

	private String msg;
	private String userInput;
	private LocalDateTime dateTime;
	public ExceptionTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExceptionTemplate(String msg, String userInput, LocalDateTime dateTime) {
		super();
		this.msg = msg;
		this.userInput = userInput;
		this.dateTime = dateTime;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getUserInput() {
		return userInput;
	}
	public void setUserInput(String userInput) {
		this.userInput = userInput;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	@Override
	public String toString() {
		return "ExceptionTemplate [msg=" + msg + ", userInput=" + userInput + ", dateTime=" + dateTime + "]";
	}
	
	
}
