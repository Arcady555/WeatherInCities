package ru.parfenov.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.parfenov.model.ResponseFromWeatherPr;
import ru.parfenov.repository.RFWPRepository;

@Service
@AllArgsConstructor
public class RFWPService {
    private final RFWPRepository repository;

    public void save(ResponseFromWeatherPr response) {
        repository.save(response);
    }

    public ResponseFromWeatherPr findByCity(String city) {
        return repository.findByCity(city);
    }
}