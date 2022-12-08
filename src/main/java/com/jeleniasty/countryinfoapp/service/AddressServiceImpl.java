package com.jeleniasty.countryinfoapp.service;

import com.jeleniasty.countryinfoapp.client.RandomAddressClient;
import com.jeleniasty.countryinfoapp.client.RestCountriesClient;
import com.jeleniasty.countryinfoapp.dto.AddressDTO;
import com.jeleniasty.countryinfoapp.dto.CountryDTO;
import com.jeleniasty.countryinfoapp.dto.CountryResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService{

    private final RestCountriesClient restCountriesClient;
    private final RandomAddressClient randomAddressClient;

    @Override
    public List<CountryResponseDTO> getCountriesInfo(Integer number) {

        List<CountryResponseDTO> countriesInfo = new ArrayList<>();

        for (AddressDTO randomAddress : getRandomAddresses(number)) {
            String countryName = randomAddress.getCountry();
            CountryDTO countryDTO = restCountriesClient.getCountryInfo(countryName);
            countryDTO.setCountryName(countryName);
            countriesInfo.add(mapCountryDTO(countryDTO));
        }
        return countriesInfo;
    }

    private Set<AddressDTO> getRandomAddresses(Integer number) {
        Set<AddressDTO> addresses = new HashSet<>();

       while (addresses.size() < number){
            AddressDTO address = randomAddressClient.getRandomAddress();
            addresses.add(address);
        }
        return addresses;
    }

    private CountryResponseDTO mapCountryDTO(CountryDTO countryDTO) {
        return new CountryResponseDTO(
                countryDTO.getCountryName(),
                countryDTO.getCapital(),
                new ArrayList<String>(countryDTO.getLanguages().values()),
                countryDTO.getPopulation()
        );
    }
}
