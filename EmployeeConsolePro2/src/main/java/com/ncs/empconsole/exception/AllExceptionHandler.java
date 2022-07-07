package com.ncs.empconsole.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AllExceptionHandler 
{
	
	
	public AllExceptionHandler() {
		System.out.println("--->> Inside Controller Advice ");
	}

	@ExceptionHandler
	public ResponseEntity<ExceptionTemplate> handleIllegalArgumentExceptionTemplateData(IllegalArgumentException e)
	{
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getMessage());
		template.setUserInput("");
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionTemplate> handleNoSuchElementExceptionTemplateData(java.util.NoSuchElementException e)
	{
		System.out.println("--->> Inside Exeption Handler : NoSuchElement ");
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getMessage());
		template.setUserInput("");
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionTemplate> handleOutOfSalaryRangeTemplateData(OutofRangeSalaryException e)
	{
		System.out.println("--->> Inside Exeption Handler : Out of Salary Range ");
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getMessage());
		template.setUserInput(e.toString());
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionTemplate> handleNullPointerExceptionTemplateData(NullPointerException e)
	{
		System.out.println("--->> Inside Exeption Handler : Out of Salary Range ");
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getMessage());
		template.setUserInput(e.toString());
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	

}
