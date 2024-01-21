package ru.parfenov.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.parfenov.model.ResponseFromWeatherPr;
import ru.parfenov.repository.RFWPRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class RFWPService {
    private final RFWPRepository repository;

    public void save(ResponseFromWeatherPr response) {
        repository.save(response);
    }

    public List<ResponseFromWeatherPr> findByCityAndDate(String city, String country, Date date, Date nextDate) {
        return repository.findByCityAndCountryAndDateTimeBetween(city, country, date, nextDate);
    }
}