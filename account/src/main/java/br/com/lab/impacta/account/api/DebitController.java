package br.com.lab.impacta.account.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lab.impacta.account.application.AccountApplication;
import br.com.lab.impacta.account.application.dto.request.DebitAccountRequest;
import br.com.lab.impacta.account.application.dto.response.DebitAccountResponse;

@RestController
@RequestMapping("/api/v1/accounts")
public class DebitController {

	@Autowired
	private AccountApplication accountApplication;
	
	@PostMapping("/{accountId}/debit")
	public ResponseEntity<DebitAccountResponse> debit(@PathVariable long accountId, @RequestBody DebitAccountRequest debitAccountRequest) {
		
		DebitAccountResponse debitAccountResponse = accountApplication.debit(accountId, debitAccountRequest);
		
		return ResponseEntity.ok(debitAccountResponse);
	}
}