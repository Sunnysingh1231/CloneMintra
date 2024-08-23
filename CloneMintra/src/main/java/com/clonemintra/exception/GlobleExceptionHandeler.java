package com.clonemintra.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobleExceptionHandeler {

	// ---------------------------------------------------------------------------------------------------

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorDetail> exceptionHandle(UserNotFoundException exu, WebRequest wru) {

		ErrorDetail eDetail = new ErrorDetail(LocalDateTime.now(), exu.getMessage(), wru.getDescription(false));

		return new ResponseEntity<ErrorDetail>(eDetail, HttpStatus.BAD_REQUEST);

	}
	// ---------------------------------------------------------------------------------------------------

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorDetail> productNotFoundExceptionHandle(ProductNotFoundException pxp, WebRequest wrp){
		
		ErrorDetail pDetail = new ErrorDetail(LocalDateTime.now(), pxp.getMessage(), wrp.getDescription(false));
		
		return new ResponseEntity<ErrorDetail>(pDetail,HttpStatus.NO_CONTENT);
		
	}

	// ---------------------------------------------------------------------------------------------------

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetail> exceptionHandle(NoHandlerFoundException ex, WebRequest wr) {

		ErrorDetail eDetail = new ErrorDetail(LocalDateTime.now(), ex.getMessage(), wr.getDescription(false));

		return new ResponseEntity<ErrorDetail>(eDetail, HttpStatus.BAD_REQUEST);

	}
}
