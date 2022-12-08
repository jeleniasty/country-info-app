package com.jeleniasty.countryinfoapp.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "restcountries.client")
@Getter
@Setter
public class RestCountriesClientProperties {
    private String baseUrl;
    private String getCountryByNameEndpoint;
}
