package br.com.lab.impacta.account.application.dto.response;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class AccountBalanceResponse {
	
	private Long accountId;
	private BigDecimal balance;
	
	public AccountBalanceResponse() {
		
	}

	public AccountBalanceResponse(Long accountId, BigDecimal balance) {
		this.accountId = accountId;
		this.balance = balance;
	}
}