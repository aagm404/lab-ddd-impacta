package br.com.lab.impacta.investment.service.facade.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lab.impacta.investment.infrastructure.http.AccountClient;
import br.com.lab.impacta.investment.service.facade.AccountFacade;
import br.com.lab.impacta.investment.service.facade.dto.DebitAccountRequest;
import br.com.lab.impacta.investment.service.facade.valueObject.AccountBalanceVO;
import br.com.lab.impacta.investment.service.facade.valueObject.DebitAccountVO;

@Component
public class AccountFacadeImpl implements AccountFacade {

	@Autowired
    private AccountClient accountClient;

    @Override
    public AccountBalanceVO getAccountBalanceById(Long accountId) {
    	
        AccountBalanceVO accountBalanceVO = accountClient.accountBalance(accountId);

        return accountBalanceVO;
    }
    
    @Override
    public boolean debitAccount(Long accountId, BigDecimal valueOfInvestment) {
    	
        DebitAccountVO debitAccountVO = accountClient.debit(accountId, new DebitAccountRequest(valueOfInvestment));

        return  debitAccountVO.isDebited();
    }
}