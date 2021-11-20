package br.com.lab.impacta.account.application.dto.request;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class DebitAccountRequest {
	
	private BigDecimal valueOfDebit;
}