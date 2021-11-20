package br.com.lab.impacta.account.service;

import java.math.BigDecimal;

import br.com.lab.impacta.account.model.Account;

public interface AccountService {

	Account findAccount(Long accountId);
	
	void debitAccount(Long accountId, BigDecimal valueOfDebit);
}