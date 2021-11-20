package br.com.lab.impacta.investment.service.facade.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class DebitAccountRequest {
	
    private BigDecimal valueOfDebit;

    public DebitAccountRequest() {
    	
    }

    public  DebitAccountRequest(BigDecimal valueOfDebit) {
        this.valueOfDebit = valueOfDebit;
    }
}