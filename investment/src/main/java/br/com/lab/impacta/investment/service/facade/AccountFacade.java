package br.com.lab.impacta.investment.service.facade;

import java.math.BigDecimal;

import br.com.lab.impacta.investment.service.facade.valueObject.AccountBalanceVO;

public interface AccountFacade {

	AccountBalanceVO getAccountBalanceById(Long accountId);
	
	boolean debitAccount(Long accountId, BigDecimal valueOfInvestment);
	
}