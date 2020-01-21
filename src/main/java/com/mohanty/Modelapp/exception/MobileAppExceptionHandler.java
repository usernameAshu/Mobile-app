package com.mohanty.Modelapp.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MobileAppExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleAnyException(Exception exc, WebRequest req) {

		String errorMessageDescription = exc.getLocalizedMessage();

		if (errorMessageDescription == null)
			errorMessageDescription = exc.toString();

		ErrorResponse errRes = new ErrorResponse(new Date(), errorMessageDescription);

		return new ResponseEntity<>(errRes, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(value = { NullPointerException.class })
	public ResponseEntity<Object> handleNullPointerException(NullPointerException exc, WebRequest req) {

		String errorMessageDescription = exc.getLocalizedMessage();

		if (errorMessageDescription == null)
			errorMessageDescription = exc.toString();

		ErrorResponse errRes = new ErrorResponse(new Date(), errorMessageDescription);

		return new ResponseEntity<>(errRes, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@ExceptionHandler(value = { UserServiceException.class })
	public ResponseEntity<Object> handleUserServiceException(UserServiceException exc, WebRequest req) {

		String errorMessageDescription = exc.getLocalizedMessage();

		if (errorMessageDescription == null)
			errorMessageDescription = exc.toString();

		ErrorResponse errRes = new ErrorResponse(new Date(), errorMessageDescription);

		return new ResponseEntity<>(errRes, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
