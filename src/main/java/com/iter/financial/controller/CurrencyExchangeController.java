package com.iter.financial.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iter.financial.dto.ExchangeRate;
import com.iter.financial.factory.FinancialFactory;
import com.iter.financial.service.FinancialService;

@RestController
@RequestMapping("/currencyExchange")
public class CurrencyExchangeController {

	private FinancialFactory factory;

	public CurrencyExchangeController(FinancialFactory factory) {
		super();
		this.factory = factory;
	}

	@GetMapping
	public List<ExchangeRate> getCurrencyExchangeRates(@RequestParam String currency,
			@RequestHeader(required = false) String provider) {
		FinancialService service = factory.getService(provider);
		return service.getExchangeRages(currency);
	}
}
