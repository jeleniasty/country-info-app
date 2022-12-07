package com.jeleniasty.countryinfoapp.Controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeleniasty.countryinfoapp.DAO.Address;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {

    @GetMapping("countries")
    public String getCountries() {
        return "Initial endpoint check. " +
                "Countries endpoint in development phase";
    }

    @RequestMapping ("addresses")
    public List<Address> getRandomAddress(@RequestParam(value = "number", defaultValue = "5") Integer number) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Address> addresses = new ArrayList<>();

        for (int i = 0; i < number; i++) {

            try {
                Address address = objectMapper.readValue(new URL("https://random-data-api.com/api/v2/addresses"), Address.class);
                addresses.add(address);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        return addresses;
    }
}
