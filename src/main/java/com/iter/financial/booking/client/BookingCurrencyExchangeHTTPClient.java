package com.iter.financial.booking.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.iter.financial.booking.dto.ExchangeRatesWrapper;
import com.iter.financial.config.ClientConfig;
import com.iter.financial.dto.Provider;

@Component
public class BookingCurrencyExchangeHTTPClient {

	private RestTemplate template;
	private Provider booking;
	private static final String LOCALE = "en-gb";

	public BookingCurrencyExchangeHTTPClient(RestTemplate template, ClientConfig config) {
		super();
		this.template = template;
		this.booking = config.getProviders().get("booking");
		;
	}

	public ExchangeRatesWrapper getExchangeRates(String currency) {
		String url = booking.getUrl();
		String uri = UriComponentsBuilder.fromHttpUrl(url).queryParam("currency", currency).queryParam("locale", LOCALE)
				.toUriString();

		HttpHeaders headers = getMandatoryHeaders();
		HttpEntity<?> entity = new HttpEntity<>(headers);

		ResponseEntity<ExchangeRatesWrapper> responseEntity = template.exchange(uri, HttpMethod.GET, entity,
				ExchangeRatesWrapper.class);
		return responseEntity.getBody();
	}

	private HttpHeaders getMandatoryHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Rapidapi-Host", booking.getXRapidapiHost());
		headers.set("X-Rapidapi-Key", booking.getXRapidapiKey());
		return headers;
	}
}
