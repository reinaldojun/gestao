package com.project.gestao.domain.exceptions;

import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorMessage resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		return ErrorMessage.builder().statusCode(HttpStatus.NOT_FOUND.value()).message(ex.getMessage())
				.description(request.getDescription(false)).build();
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMessage globalExceptionHandler(Exception ex, WebRequest request) {
		return ErrorMessage.builder().statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).message(ex.getMessage())
				.description(request.getDescription(false)).build();
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(value = HttpStatus.PRECONDITION_FAILED)
	public ErrorMessage dataIntegrityViolationExceptionHandler(Exception ex, WebRequest request) {
		return ErrorMessage.builder().statusCode(HttpStatus.PRECONDITION_FAILED.value()).message(ex.getMessage())
				.description(request.getDescription(false)).build();
	}

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMessage constraintViolationExceptionHandler(Exception ex, WebRequest request) {
		return ErrorMessage.builder().statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).message(ex.getMessage())
				.description(request.getDescription(false)).build();
	}

}
