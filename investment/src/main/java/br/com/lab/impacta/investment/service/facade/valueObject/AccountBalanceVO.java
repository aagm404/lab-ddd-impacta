package br.com.lab.impacta.investment.service.facade.valueObject;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class AccountBalanceVO {

	private Long accountId;
	private BigDecimal balance;
}