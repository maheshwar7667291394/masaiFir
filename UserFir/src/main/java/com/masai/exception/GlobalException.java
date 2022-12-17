package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Myerror> getInputmismatchException(MethodArgumentNotValidException ce,WebRequest req){
		Myerror err=new Myerror();
		err.setMessage(ce.getMessage());
		err.setDescription(req.getDescription(false));
		err.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<Myerror> GetUserException(UserException ce,WebRequest req){
		Myerror err=new Myerror();
		err.setMessage(ce.getMessage());
		err.setDescription(req.getDescription(false));
		err.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Myerror> GetAllException(Exception ce,WebRequest req){
		Myerror err=new Myerror();
		err.setMessage(ce.getMessage());
		err.setDescription(req.getDescription(false));
		err.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
}
