package com.iter.financial.booking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Rate {

	@JsonProperty("exchange_rate_buy")
	private String exchangeRateBuy;
	private String currency;
}
