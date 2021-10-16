package com.iter.financial.service;

import java.util.List;

import com.iter.financial.dto.ExchangeRate;

public interface FinancialService {

	List<ExchangeRate> getExchangeRages(String currency);
}
