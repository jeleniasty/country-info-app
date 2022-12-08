package com.jeleniasty.countryinfoapp.controller;



import com.jeleniasty.countryinfoapp.dto.CountryResponseDTO;
import com.jeleniasty.countryinfoapp.service.AddressService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
@RestController
@RequiredArgsConstructor
public class CountryController {

    private final AddressService addressService;

    @GetMapping("/countries")
    public List<CountryResponseDTO> getCountriesInfo(@RequestParam(value = "number") @Min(5) @Max(20)  Integer number) {
        return addressService.getCountriesInfo(number);
    }


}
