package br.com.lab.impacta.investment.handler.exception;

import lombok.Getter;

@Getter
public class InvestmentAccountWithoutBalanceException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String description;
	
	public InvestmentAccountWithoutBalanceException() {
		
	}
	
	public InvestmentAccountWithoutBalanceException(String message, String description) {
		super(message);
		this.description = description;
	}
}