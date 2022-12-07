package com.jeleniasty.countryinfoapp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Controller {

    @GetMapping("countries")
    public String getCountries() {
        return "Countries endpoint in development phase";
    }
}
