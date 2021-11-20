package br.com.lab.impacta.investment.infrastructure.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.lab.impacta.investment.service.facade.valueObject.AccountBalanceVO;

@FeignClient(name = "${lab.investment.paths.client-account-name}",
			 url = "lab.investment.paths.client-account-base-url")
public interface AccountClient {

	@GetMapping("${lab.investment.paths.client-account-balance-path-url}")
	AccountBalanceVO accountBalance(@PathVariable("accountId") Long accountId);
}