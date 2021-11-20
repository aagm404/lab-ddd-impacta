package br.com.lab.impacta.investment.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
public class Investment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long productId;

	private Long accountId;

	private BigDecimal value;

	@CreationTimestamp
	private Date date;

	private boolean privateInvestment;

	public Investment() {
		
	}

	public Investment(Long productId, Long accountId, BigDecimal value) {
		this.productId = productId;
		this.accountId = accountId;
		this.value = value;
	}

	public boolean sufficientBalanceForInvestment(BigDecimal accountBalance) {
		return this.getValue().compareTo(accountBalance) < 0;
	}

	public boolean verifyProductPrivateOrDefaultForInvestment(BigDecimal accountBalance, Product product) {
		if (!product.isPrivateInvestment()) {
			this.privateInvestment = false;

			return true;
		}

		if (product.isPrivateInvestment() && (accountBalance.compareTo(product.getMinimumValueForInvestment()) >= 0 )) {
			this.privateInvestment = true;

			return true;
		}

		return false;
	}
}