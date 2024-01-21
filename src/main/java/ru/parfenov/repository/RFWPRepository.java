package ru.parfenov.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.parfenov.model.ResponseFromWeatherPr;

import java.util.Date;
import java.util.List;

@Repository
public interface RFWPRepository extends CrudRepository<ResponseFromWeatherPr, Integer> {

    List<ResponseFromWeatherPr> findByCityAndCountryAndDateTimeBetween(
            String city, String country, Date date, Date nextDate
    );
}