package br.com.lab.impacta.account.handler.exception;

import lombok.Getter;

@Getter
public class AccountDoesntExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String description;

	public AccountDoesntExistException() {
		super();
	}
	
	public AccountDoesntExistException(String message, String description) {
		super(message);
		this.description = description;
	}
}