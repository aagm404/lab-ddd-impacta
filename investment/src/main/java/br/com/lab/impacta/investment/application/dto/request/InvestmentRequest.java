package br.com.lab.impacta.investment.application.dto.request;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class InvestmentRequest {
	
    private Long productId;
    private BigDecimal value;
}