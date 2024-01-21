package ru.parfenov.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.parfenov.model.ResponseFromWeatherPr;

@Repository
public interface RFWPRepository extends CrudRepository<ResponseFromWeatherPr, Integer> {
    ResponseFromWeatherPr findByCity(String city);
}