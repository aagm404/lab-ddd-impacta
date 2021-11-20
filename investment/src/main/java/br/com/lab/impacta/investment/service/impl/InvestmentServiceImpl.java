package br.com.lab.impacta.investment.service.impl;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.lab.impacta.investment.handler.exception.InvestmentAccountIsNotDebitException;
import br.com.lab.impacta.investment.handler.exception.InvestmentAccountWithoutBalanceException;
import br.com.lab.impacta.investment.handler.exception.InvestmentAccountWithoutBalanceForPrivateProductException;
import br.com.lab.impacta.investment.handler.exception.InvestmentProductDoesntExistException;
import br.com.lab.impacta.investment.model.Investment;
import br.com.lab.impacta.investment.model.Product;
import br.com.lab.impacta.investment.repository.InvestmentRepository;
import br.com.lab.impacta.investment.repository.ProductRepository;
import br.com.lab.impacta.investment.service.InvestmentService;
import br.com.lab.impacta.investment.service.facade.AccountFacade;
import br.com.lab.impacta.investment.service.facade.valueObject.AccountBalanceVO;

@Service
public class InvestmentServiceImpl implements InvestmentService {

    @Autowired
    private InvestmentRepository investmentRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AccountFacade accountFacade;
    
    @Value("${lab.investment.exceptions.product-doesnt-exist-message}")
    private String productDoesntExistExceptionMessage;
    
    @Value("${lab.investment.exceptions.product-doesnt-exist-description}")
    private String productDoesntExistExceptionDescription;
    
    @Value("${lab.investment.exceptions.account-without-balance-message}")
    private String accountWithoutBalanceExceptionMessage;
    
    @Value("${lab.investment.exceptions.account-without-balance-description}")
    private String accountWithoutBalanceExceptionDescription;
    
    @Value("${lab.investment.exceptions.account-without-balance-for-private-product-message}")
    private String accountWithoutBalanceForPrivateProductExceptionMessage;
    
    @Value("${lab.investment.exceptions.account-without-balance-for-private-product-description}")
    private String accountWithoutBalanceForPrivateProductExceptionDescription;
    
    @Value("${lab.investment.exceptions.account-is-not-debited-message}")
    private String accountIsNotDebitedExceptionMessage;
    
    @Value("${lab.investment.exceptions.account-is-not-debited-description}")
    private String accountIsNotDebitedExceptionDescription;

    @Override
    public Investment invest(Long productId, Long accountId, BigDecimal valueInvestment) {
        Optional<Product> product = productRepository.findById(productId);

        if (product.isEmpty()) {
            throw new InvestmentProductDoesntExistException(productDoesntExistExceptionMessage, productDoesntExistExceptionDescription);
        }

        Investment investment = new Investment(productId, accountId, valueInvestment);

        AccountBalanceVO accountBalanceVO = accountFacade.getAccountBalanceById(accountId);

        if (!investment.sufficientBalanceForInvestment(accountBalanceVO.getBalance())) {
            throw new InvestmentAccountWithoutBalanceException(accountWithoutBalanceExceptionMessage, accountWithoutBalanceExceptionDescription);
        }

        if (!investment.verifyProductPrivateOrDefaultForInvestment(accountBalanceVO.getBalance(), product.get())) {
            throw new InvestmentAccountWithoutBalanceForPrivateProductException(accountWithoutBalanceForPrivateProductExceptionMessage, accountWithoutBalanceForPrivateProductExceptionDescription);
        }

        boolean isDebited = accountFacade.debitAccount(accountId, valueInvestment);

        if (!isDebited) {
            throw new InvestmentAccountIsNotDebitException(accountIsNotDebitedExceptionMessage, accountIsNotDebitedExceptionDescription);
        }

        investmentRepository.save(investment);

        return investment;
    }
}