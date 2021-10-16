package com.iter.financial.booking.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ExchangeRatesWrapper {

	@JsonProperty("exchange_rates")
	private List<Rate> exchangeRates;
	private String baseCurrency;
}
