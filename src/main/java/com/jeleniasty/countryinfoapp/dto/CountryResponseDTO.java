package com.jeleniasty.countryinfoapp.dto;

import java.util.List;

public record CountryResponseDTO(
        String countryName,
        List<String> capital,
        List<String> language,
        Long population
)  {

}
