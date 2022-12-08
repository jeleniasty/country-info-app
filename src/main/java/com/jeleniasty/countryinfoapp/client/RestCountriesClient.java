package com.jeleniasty.countryinfoapp.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeleniasty.countryinfoapp.dto.CountryDTO;
import com.jeleniasty.countryinfoapp.properties.RestCountriesClientProperties;
import com.squareup.okhttp.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@RequiredArgsConstructor
public class RestCountriesClient {
    private final RestCountriesClientProperties restCountriesClientProperties;
    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper;

    public CountryDTO getCountryInfo(String countryName) {

        Request request = new Request.Builder()
                .url(
                        restCountriesClientProperties.getBaseUrl()
                                + restCountriesClientProperties.getGetCountryByNameEndpoint()
                                + "/" + countryName.replaceAll(" ", "%20")
                )
                .build();

        Call call = client.newCall(request);

        try (ResponseBody responseBody = call.execute().body()) {

            return (objectMapper.readValue(responseBody.string(), CountryDTO[].class))[0];

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
