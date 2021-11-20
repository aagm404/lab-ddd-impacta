package br.com.lab.impacta.account.handler.exception;

import lombok.Getter;

@Getter
public class AccountWithoutBalanceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String description;
	
	public AccountWithoutBalanceException() {
		super();
	}
	
	public AccountWithoutBalanceException(String message, String description) {
		super(message);
		this.description = description;
	}
}