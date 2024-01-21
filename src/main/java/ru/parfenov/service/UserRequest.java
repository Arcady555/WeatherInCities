package ru.parfenov.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.parfenov.model.ResponseFromWeatherPr;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@AllArgsConstructor
public class UserRequest {
    private final RFWPService service;

    public List<ResponseFromWeatherPr> findByCityAndDate(String city, String country, String date) throws ParseException {
        Date sdf = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        Calendar cal = new GregorianCalendar();
        cal.setTime(sdf);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        Date nextDate = cal.getTime();
        return service.findByCityAndDate(city, country, sdf, nextDate);
    }
}