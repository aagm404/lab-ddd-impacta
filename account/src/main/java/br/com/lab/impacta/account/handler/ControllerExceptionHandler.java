package br.com.lab.impacta.account.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.lab.impacta.account.handler.exception.AccountDoesntExistException;
import br.com.lab.impacta.account.handler.exception.AccountWithoutBalanceException;
import br.com.lab.impacta.account.handler.exception.ErrorMessageResponse;
/*
 * O ControllerExceptionHandler é característica da Arquitetura Hexagonal
 * O envento de "throw" é característica do DDD 2998,80
 */
@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(AccountDoesntExistException.class)
	public ResponseEntity<ErrorMessageResponse> accountNotFoundException(AccountDoesntExistException accountDoesntExistException) {
		
		ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse(
				HttpStatus.NOT_FOUND.value(),
				new Date(),
				accountDoesntExistException.getMessage(),
				accountDoesntExistException.getDescription());
		
		return new ResponseEntity<>(errorMessageResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AccountWithoutBalanceException.class)
	public ResponseEntity<ErrorMessageResponse> accountWithoutBalanceException(AccountWithoutBalanceException accountWithoutBalanceException) {
		
		ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse(
				HttpStatus.BAD_REQUEST.value(),
				new Date(),
				accountWithoutBalanceException.getMessage(),
				accountWithoutBalanceException.getDescription());
		
		return new ResponseEntity<>(errorMessageResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorMessageResponse> generalError(RuntimeException ex) {
		
		ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse(
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				new Date(),
				ex.getMessage(),
				"Não foi possível processar a sua requisição");
		
		return new ResponseEntity<>(errorMessageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}