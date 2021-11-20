package br.com.lab.impacta.investment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lab.impacta.investment.model.Investment;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, Long> {

}