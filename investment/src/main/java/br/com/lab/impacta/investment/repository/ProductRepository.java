package br.com.lab.impacta.investment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lab.impacta.investment.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}