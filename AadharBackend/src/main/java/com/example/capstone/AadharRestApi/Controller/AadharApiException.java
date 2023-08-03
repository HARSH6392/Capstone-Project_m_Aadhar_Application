package com.example.capstone.AadharRestApi.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.examples.capstone.AadharRestApi.Exception.AdminNotFoundException;
import com.examples.capstone.AadharRestApi.Exception.CitizenNotFoundException;
import com.examples.capstone.AadharRestApi.Exception.UserNotFoundException;
//This class serves as a global exception handler for the AadharRestApi controllers.
@ControllerAdvice
public class AadharApiException {
    // Exception handler method for AdminNotFoundException.	
	@ExceptionHandler(value=AdminNotFoundException.class)
	public ResponseEntity<Object> handleException(AdminNotFoundException ex) {
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
    // Exception handler method for UserNotFoundException.	
	@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseEntity<Object> handleException(UserNotFoundException ex) {
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
    // Exception handler method for UserNotFoundException.	
	@ExceptionHandler(value=CitizenNotFoundException.class)
	public ResponseEntity<Object> handleException(CitizenNotFoundException ex) {
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

}
