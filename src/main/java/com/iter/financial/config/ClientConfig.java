package com.iter.financial.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.iter.financial.dto.Provider;

import lombok.Data;

@Configuration
@ConfigurationProperties("financial")
@Data
public class ClientConfig {

	private Map<String,Provider> providers;
}
