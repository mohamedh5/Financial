package com.iter.financial.booking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iter.financial.booking.client.BookingCurrencyExchangeHTTPClient;
import com.iter.financial.booking.dto.ExchangeRatesWrapper;
import com.iter.financial.booking.mapper.BookingExchangeMapper;
import com.iter.financial.dto.ExchangeRate;
import com.iter.financial.service.FinancialService;

@Service
public class BookingService implements FinancialService {

	private BookingCurrencyExchangeHTTPClient client;
	private BookingExchangeMapper mapper;

	public BookingService(BookingCurrencyExchangeHTTPClient client, BookingExchangeMapper mapper) {
		super();
		this.client = client;
		this.mapper = mapper;
	}

	@Override
	public List<ExchangeRate> getExchangeRages(String currency) {
		ExchangeRatesWrapper exchangeRates = client.getExchangeRates(currency);
		return mapper.map(exchangeRates.getExchangeRates());
	}
}
