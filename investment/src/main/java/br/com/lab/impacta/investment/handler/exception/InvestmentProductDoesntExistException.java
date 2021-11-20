package br.com.lab.impacta.investment.handler.exception;

import lombok.Getter;

@Getter
public class InvestmentProductDoesntExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String description;
	
	public InvestmentProductDoesntExistException() {
		
	}
	
	public InvestmentProductDoesntExistException(String message, String description) {
		super(message);
		this.description = description;
	}
}