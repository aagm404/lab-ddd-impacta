package br.com.lab.impacta.account.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long number;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id")
	private Person customer;
	
	private BigDecimal balance;
	
	public Boolean debit(BigDecimal valueOfDebit) {
		
		if (this.getBalance().compareTo(valueOfDebit) < 0) {
			return false;
		}
		
		BigDecimal debitedAmount = this.getBalance().subtract(valueOfDebit);
		this.setBalance(debitedAmount);
		
		return true;
	}
}