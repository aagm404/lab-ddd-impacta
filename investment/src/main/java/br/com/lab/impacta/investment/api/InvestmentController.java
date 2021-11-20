package br.com.lab.impacta.investment.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lab.impacta.investment.application.InvestmentApplication;
import br.com.lab.impacta.investment.application.dto.request.InvestmentRequest;
import br.com.lab.impacta.investment.application.dto.response.InvestmentResponse;

@RestController
@RequestMapping("api/v1/accounts")
public class InvestmentController {

    @Autowired
    private InvestmentApplication investmentApplication;

    @PostMapping("/{accountId}/investment")
    public ResponseEntity<InvestmentResponse> invest(
            @PathVariable long accountId,
            @RequestBody InvestmentRequest investmentRequest) {
        InvestmentResponse investmentResponse = investmentApplication.invest(accountId, investmentRequest);

        return ResponseEntity.ok(investmentResponse);
    }
}