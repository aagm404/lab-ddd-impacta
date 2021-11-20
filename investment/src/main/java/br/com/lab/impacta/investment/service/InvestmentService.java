package br.com.lab.impacta.investment.service;

import java.math.BigDecimal;

import br.com.lab.impacta.investment.model.Investment;

public interface InvestmentService {

	 Investment invest(Long productId, Long accountId, BigDecimal valueInvestment);
}