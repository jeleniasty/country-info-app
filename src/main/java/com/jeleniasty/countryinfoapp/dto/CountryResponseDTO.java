package com.jeleniasty.countryinfoapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class CountryResponseDTO {
    private String countryName;
    private List<String> capital;
    private List<String> language;
    private Long population;

}
