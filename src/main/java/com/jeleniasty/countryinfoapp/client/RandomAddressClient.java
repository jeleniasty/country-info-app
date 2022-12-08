package com.jeleniasty.countryinfoapp.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeleniasty.countryinfoapp.dto.AddressDTO;
import com.jeleniasty.countryinfoapp.properties.RandomAddressClientProperties;
import com.squareup.okhttp.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class RandomAddressClient {
    private final RandomAddressClientProperties randomAddressClientProperties;
    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper;
    public AddressDTO getRandomAddress() {

        Request request = new Request.Builder()
                .url(randomAddressClientProperties.getBaseUrl() + randomAddressClientProperties.getGetRandomAddressEndpoint())
                .build();

        Call call = client.newCall(request);

        try (ResponseBody responseBody = call.execute().body()){
            return objectMapper.readValue(responseBody.string(), AddressDTO.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
