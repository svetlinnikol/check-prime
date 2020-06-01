package com.infinitelambda.checkprime.controller.errorhandle;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import springfox.documentation.annotations.ApiIgnore;

/**
 * Error handler class for all Rest controllers in the application.
 */
@ApiIgnore
@ControllerAdvice
public class ControllerValidationErrorsHandler {

	/**
	 * Exception Handler in case of ConstrainViolationException thrown by the validation annotations like Max, Min and so on.
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseBody
	public ResponseEntity<List<SimpleFieldError>> processConstraintViolations(ConstraintViolationException e) {
		List<SimpleFieldError> messages = e.getConstraintViolations().stream()
				.map(cv -> new SimpleFieldError(cv.getPropertyPath().toString(), cv.getMessage()))
				.collect(Collectors.toList());
		return new ResponseEntity<>(messages, HttpStatus.NOT_ACCEPTABLE);
	}

}