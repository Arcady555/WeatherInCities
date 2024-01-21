package ru.parfenov.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.parfenov.model.ResponseFromWeatherPr;
import ru.parfenov.service.UserRequest;

import java.text.ParseException;
import java.util.*;

@RestController
@AllArgsConstructor
public class UserRequestController {
    private final UserRequest service;

    @GetMapping("/{city}/{country}/{date}")
    public List<ResponseFromWeatherPr> find(@PathVariable("city") String city,
                                                      @PathVariable("country") String country,
                                                      @PathVariable("date") String date
                                                      ) throws ParseException {
        return service.findByCityAndDate(city, country, date);
    }
}