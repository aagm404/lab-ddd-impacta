package br.com.lab.impacta.investment.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.lab.impacta.investment.handler.exception.ErrorMessageResponse;
import br.com.lab.impacta.investment.handler.exception.InvestmentAccountIsNotDebitException;
import br.com.lab.impacta.investment.handler.exception.InvestmentAccountWithoutBalanceException;
import br.com.lab.impacta.investment.handler.exception.InvestmentAccountWithoutBalanceForPrivateProductException;
import br.com.lab.impacta.investment.handler.exception.InvestmentProductDoesntExistException;


@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(InvestmentProductDoesntExistException.class)
	public ResponseEntity<ErrorMessageResponse> productDoesntExistError(InvestmentProductDoesntExistException ex) {
		
		ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse(
				HttpStatus.BAD_REQUEST.value(),
				new Date(),
				ex.getMessage(),
				ex.getDescription());
		
		return new ResponseEntity<>(errorMessageResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvestmentAccountWithoutBalanceException.class)
	public ResponseEntity<ErrorMessageResponse> accountWithoutBalanceError(InvestmentAccountWithoutBalanceException ex) {
		
		ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse(
				HttpStatus.BAD_REQUEST.value(),
				new Date(),
				ex.getMessage(),
				ex.getDescription());
		
		return new ResponseEntity<>(errorMessageResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvestmentAccountWithoutBalanceForPrivateProductException.class)
	public ResponseEntity<ErrorMessageResponse> accountWithoutBalanceForPrivateProductError(InvestmentAccountWithoutBalanceForPrivateProductException ex) {
		
		ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse(
				HttpStatus.BAD_REQUEST.value(),
				new Date(),
				ex.getMessage(),
				ex.getDescription());
		
		return new ResponseEntity<>(errorMessageResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvestmentAccountIsNotDebitException.class)
	public ResponseEntity<ErrorMessageResponse> accountIsNotDebitError(InvestmentAccountIsNotDebitException ex) {
		
		ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse(
				HttpStatus.BAD_REQUEST.value(),
				new Date(),
				ex.getMessage(),
				ex.getDescription());
		
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