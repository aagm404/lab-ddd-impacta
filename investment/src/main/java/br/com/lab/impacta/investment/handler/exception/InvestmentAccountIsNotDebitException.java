package br.com.lab.impacta.investment.handler.exception;

import lombok.Getter;

@Getter
public class InvestmentAccountIsNotDebitException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String description;
	
	public InvestmentAccountIsNotDebitException() {
		
	}
	
	public InvestmentAccountIsNotDebitException(String message, String description) {
		super(message);
		this.description = description;
	}
}