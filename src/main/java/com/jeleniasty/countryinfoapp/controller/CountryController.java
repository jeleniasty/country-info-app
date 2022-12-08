package com.jeleniasty.countryinfoapp.controller;



import com.jeleniasty.countryinfoapp.dto.CountryResponseDTO;
import com.jeleniasty.countryinfoapp.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CountryController {

    private final AddressService addressService;

    @GetMapping("/countries")
    public List<CountryResponseDTO> getCountriesInfo(@RequestParam(value = "number") Integer number) {
        return addressService.getCountriesInfo(number);
    }


}
