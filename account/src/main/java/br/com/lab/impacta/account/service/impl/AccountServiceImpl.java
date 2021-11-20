package br.com.lab.impacta.account.service.impl;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.lab.impacta.account.handler.exception.AccountDoesntExistException;
import br.com.lab.impacta.account.handler.exception.AccountWithoutBalanceException;
import br.com.lab.impacta.account.model.Account;
import br.com.lab.impacta.account.repository.AccountRepository;
import br.com.lab.impacta.account.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Value("${lab.account.exceptions.account-doesnt-exist-message}")
	private String messageExceptionAccountDoesntExist;
	
	@Value("${lab.account.exceptions.account-doesnt-exist-description}")
	private String descriptionExceptionAccountDoesntExist;
	
	@Value("${lab.account.exceptions.account-without-balance-message}")
	private String messageExceptionAccountWithoutBalance;
	
	@Value("${lab.account.exceptions.account-without-balance-description}")
	private String descriptionExceptionAccountWithoutBalance;

	@Override
	public Account findAccount(Long accountId) {
		Optional<Account> account = accountRepository.findById(accountId);
		
		if (account.isEmpty()) {
			throw new AccountDoesntExistException(messageExceptionAccountDoesntExist, descriptionExceptionAccountDoesntExist);
		}
		
		return account.get();
	}

	@Override
	public void debitAccount(Long accountId, BigDecimal valueOfDebit) {
		Account account = this.findAccount(accountId);
		
		boolean debited = account.debit(valueOfDebit);
		
		if (!debited) {
			throw new AccountWithoutBalanceException(messageExceptionAccountWithoutBalance, descriptionExceptionAccountWithoutBalance);
		}
		
		accountRepository.save(account);
	}
}