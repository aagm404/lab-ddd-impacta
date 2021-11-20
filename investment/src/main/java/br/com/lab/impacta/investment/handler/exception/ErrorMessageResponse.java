package br.com.lab.impacta.investment.handler.exception;

import java.util.Date;

import lombok.Getter;

@Getter
public class ErrorMessageResponse {

	private int statusCode;
	private Date timeStamp;
	private String message;
	private String description;
	
	public ErrorMessageResponse(int statusCode, Date timeStamp, String message, String description) {
		this.statusCode = statusCode;
		this.timeStamp = timeStamp;
		this.message = message;
		this.description = description;
	}
}