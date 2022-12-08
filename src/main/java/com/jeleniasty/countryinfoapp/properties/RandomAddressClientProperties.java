package com.jeleniasty.countryinfoapp.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "randomaddress.client")
@Getter
@Setter
public class RandomAddressClientProperties {

    private String baseUrl;
    private String getRandomAddressEndpoint;
}
