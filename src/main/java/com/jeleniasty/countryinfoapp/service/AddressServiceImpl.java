package com.jeleniasty.countryinfoapp.service;

import com.jeleniasty.countryinfoapp.client.RandomAddressClient;
import com.jeleniasty.countryinfoapp.client.RestCountriesClient;
import com.jeleniasty.countryinfoapp.dto.AddressDTO;
import com.jeleniasty.countryinfoapp.dto.CountryDTO;
import com.jeleniasty.countryinfoapp.dto.CountryResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final RestCountriesClient restCountriesClient;
    private final RandomAddressClient randomAddressClient;

    @Override
    public List<CountryResponseDTO> getCountriesInfo(Integer number) {

        Set<CountryResponseDTO> countriesInfo = new HashSet<>();

        for (AddressDTO randomAddress : getRandomAddresses(number)) {
            String countryName = randomAddress.country();
            CountryDTO countryDTO = restCountriesClient.getCountryInfo(countryName).withCountryName(countryName);
            countriesInfo.add(mapCountryDTO(countryDTO));
        }

        return countriesInfo.stream()
                .sorted(Comparator
                        .comparingLong(CountryResponseDTO::population)
                        .reversed())
                .collect(Collectors.toList());
    }

    private Set<AddressDTO> getRandomAddresses(Integer number) {
        Set<AddressDTO> addresses = new HashSet<>();

        while (addresses.size() < number) {
            AddressDTO address = randomAddressClient.getRandomAddress();
            addresses.add(address);
        }
        return addresses;
    }

    private CountryResponseDTO mapCountryDTO(CountryDTO countryDTO) {
        return new CountryResponseDTO(
                countryDTO.countryName(),
                countryDTO.capital(),
                new ArrayList<>(countryDTO.languages().values()),
                countryDTO.population()
        );
    }
}
