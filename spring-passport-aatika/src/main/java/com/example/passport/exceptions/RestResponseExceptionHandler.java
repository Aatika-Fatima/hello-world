package com.example.passport.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.passport.util.FailureMessage;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ PassportApplicationSaveException.class })
	public ResponseEntity<?> handlePassportApplicationSaveException(final RuntimeException exception,
			final WebRequest request) {
		FailureMessage failureMessage = new FailureMessage();
		failureMessage.setStatus(0);
		failureMessage.setMessage("Error Creating Passport Application");
		return handleExceptionInternal(exception, failureMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);

	}

	@ExceptionHandler({ DocumentUploadingException.class })
	public ResponseEntity<?> handleDocumentUploadException(final RuntimeException exception, final WebRequest request) {
		FailureMessage failureMessage = new FailureMessage();
		failureMessage.setStatus(0);
		failureMessage.setMessage("Error Uploading Documents");
		return handleExceptionInternal(exception, failureMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);

	}

	@ExceptionHandler({ ApplicationNotFoundException.class })
	public ResponseEntity<?> handleApplicationNotFoundException(final ApplicationNotFoundException exception,
			final WebRequest request) {
		FailureMessage failureMessage = new FailureMessage();
		failureMessage.setStatus(0);
		failureMessage.setMessage("An Error occurred while fetching Application " + exception.getApplicationId());

		return handleExceptionInternal(exception, failureMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);

	}

}
