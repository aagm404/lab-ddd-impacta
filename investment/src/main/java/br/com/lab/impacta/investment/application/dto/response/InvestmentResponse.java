package br.com.lab.impacta.investment.application.dto.response;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class InvestmentResponse {
	
    private Long id;
    private BigDecimal value;
    private Date date;

    public InvestmentResponse() {
    	
    }

    public InvestmentResponse(Long id, BigDecimal value, Date date) {
        this.id = id;
        this.value = value;
        this.date = date;
    }
}