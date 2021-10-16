package com.iter.financial.booking.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.iter.financial.booking.dto.Rate;
import com.iter.financial.dto.ExchangeRate;

@Mapper(componentModel = "spring")
public interface BookingExchangeMapper {

	List<ExchangeRate> map(List<Rate> rates);

	@Mapping(source = "exchangeRateBuy", target = "rate", qualifiedByName = "StringToDouble")
	ExchangeRate map(Rate rate);

	@Named("StringToDouble")
	default double extractDoubleFromString(String string) {
		return Double.parseDouble(string);
	}
}
