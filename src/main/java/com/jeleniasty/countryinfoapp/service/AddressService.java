package com.jeleniasty.countryinfoapp.service;

import com.jeleniasty.countryinfoapp.dto.CountryResponseDTO;

import java.util.List;
import java.util.Set;

public interface AddressService {

    List<CountryResponseDTO> getCountriesInfo(Integer number);
}
