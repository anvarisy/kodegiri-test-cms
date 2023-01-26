package me.anvarisy.kodegiri.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import me.anvarisy.kodegiri.dto.ErrorResponse;

@ControllerAdvice
public class GeneralException extends ResponseEntityExceptionHandler{

	@ExceptionHandler(UsernameNotFoundException.class)
	public final ResponseEntity<ErrorResponse> handleRuntime(Exception ex, WebRequest request) throws Exception {
		ErrorResponse errorDetails = new ErrorResponse(false, 
					ex.getMessage(),  404);
			return new ResponseEntity<ErrorResponse>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		ErrorResponse errorDetails = new ErrorResponse(false, 
		ex.getMessage(),  500);
		return new ResponseEntity<ErrorResponse>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(BadCredentialsException.class)
	public final ResponseEntity<ErrorResponse> handleBadCredentialExceptions(Exception ex, WebRequest request) throws Exception {
		ErrorResponse errorDetails = new ErrorResponse(false, 
		ex.getMessage(),  403);
		return new ResponseEntity<ErrorResponse>(errorDetails, HttpStatus.FORBIDDEN);
		
	}

	/*
	 * @ExceptionHandler(NotFoundException.class) public final
	 * ResponseEntity<ErrorResponse> handleUserNotFoundException(Exception ex,
	 * WebRequest request) throws Exception { ErrorResponse errorDetails = new
	 * ErrorResponse(false, LocalDateTime.now(), ex.getMessage(), 404);
	 * 
	 * return new ResponseEntity<ErrorResponse>(errorDetails, HttpStatus.NOT_FOUND);
	 * 
	 * }
	 */
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		ErrorResponse errorDetails = new ErrorResponse(false, 
				ex.getFieldError().getDefaultMessage(), status.value());
		
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
}
