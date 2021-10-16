package com.iter.financial.factory;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.iter.financial.service.FinancialService;

@Component
public class FinancialFactory {

	private static final String SERVICE = "Service";
	private static final String DEFAULT_BOOKING = "booking";
	private Map<String, FinancialService> services;

	public FinancialFactory(Map<String, FinancialService> services) {
		super();
		this.services = services;
	}

	public FinancialService getService(String name) {
		if (!StringUtils.hasText(name))
			name = DEFAULT_BOOKING;
		name += SERVICE;
		return services.get(name);
	}
}
