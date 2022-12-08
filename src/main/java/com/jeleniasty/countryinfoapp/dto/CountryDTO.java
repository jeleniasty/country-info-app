package com.jeleniasty.countryinfoapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CountryDTO(@With String countryName, List<String> capital, Map<String, String> languages, Long population) {

}
