package com.oneable.first.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice

public class ControllerExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  
  public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
    ErrorMessage message = new ErrorMessage(404, new Date(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
  }
  @ExceptionHandler(Exception.class)
  public ResponseEntity<?>programError(Exception ex,WebRequest req)
  {
	  ErrorMessage  message=new ErrorMessage(500, new Date(), ex.getMessage(), req.getDescription(false));
	return new ResponseEntity<>(message,HttpStatus.INTERNAL_SERVER_ERROR);
  }
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<?>globalHandlingException(MethodArgumentNotValidException ex)
  {
	  ErrorMessage errorMessage=new ErrorMessage(400, new Date(), ex.getBindingResult().getFieldError().getDefaultMessage(), "Validation Error");
	return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
	  
  }
}