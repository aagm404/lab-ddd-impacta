package br.com.lab.impacta.investment.service.facade.valueObject;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class AccountBalanceVO {

	private Long accountId;
	private BigDecimal balance;
}