package com.ncs.empconsole.exception;

public class OutofRangeSalaryException extends Exception{
	private String errorMsg;
	private String designation;
	private int userInput;
	
	public OutofRangeSalaryException(String errorMsg, int userInput,String designation) {
		super();
		this.errorMsg = errorMsg;
		this.userInput = userInput;
		this.designation = designation;
	}
	public OutofRangeSalaryException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public int getUserInput() {
		return userInput;
	}
	public void setUserInput(int userInput) {
		this.userInput = userInput;
	}
	
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "Salary of "+designation+" cannot be more than "+userInput;
	}
	
	

}
