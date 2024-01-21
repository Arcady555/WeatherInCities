package ru.parfenov.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.parfenov.dto.ResponseDTO1;
import ru.parfenov.dto.ResponseDTO2;
import ru.parfenov.dto.ResponseDTO3;
import ru.parfenov.model.ResponseFromWeatherPr;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class RequestToSites {
    private final RFWPService service;
    @Value("${citiesList}")
    private String citiesList;
    Gson gson = new Gson();

    public RequestToSites(RFWPService service) {
        this.service = service;
    }

    @Scheduled(fixedRateString = "${interval}")
    @Async
    private void saveResponse() {
        List<String> cities = getCities(citiesList);
        for (String str : cities) {
            String[] array = str.split("/");
            String city = array[0];
            String country = array[1];
            ResponseDTO1 responseDTO1 = request1(city);
            ResponseDTO2 responseDTO2 = request2(city);
            ResponseDTO3 responseDTO3 = request3(city);
            float t1 = Float.parseFloat(responseDTO1.getMain().getTemp());
            float t2 = Float.parseFloat(responseDTO2.getCurrent().getTemp_c());
            float t3 = Float.parseFloat(responseDTO3.getDays()[0].getTemp());
            float t = (t1 + t2 + t3) / 3;
            String strT = String.format("%.2f",t);
            if (country.equals(responseDTO1.getSys().getCountry())) {
                ResponseFromWeatherPr response = new ResponseFromWeatherPr(
                        0, city,  strT, new Date(), country
                );
                save(response);
            } else {
                throw new IllegalArgumentException(city + " -- Error country name!");
            }
        }
    }

    private ResponseDTO1 request1(String city) {
        String json = new RestAuthCall(
                "https://api.openweathermap.org/data/2.5/weather?q="
                        + city
                        + "&appid=15390fe804a1c1f9c33c08d7b3d1b7ff&units=metric"
        ).get();
        return gson.fromJson(json, ResponseDTO1.class);
    }

    private ResponseDTO2 request2(String city) {
        String json = new RestAuthCall(
                "https://api.weatherapi.com/v1/current.json?key=64a0e89b4a8e4c64a60142706242101&q="
                        + city
                        + "&aqi=noc"
        ).get();
        return gson.fromJson(json, ResponseDTO2.class);
    }

    private ResponseDTO3 request3(String city) {
        String json = new RestAuthCall(
                "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/"
                        + city
                        + "?unitGroup=metric&include=current&key=EDQXSPVGR5LQB3H3MS79W74TA&contentType=json"
        ).get();
        return gson.fromJson(json, ResponseDTO3.class);
    }

    private void save(ResponseFromWeatherPr response) {
        service.save(response);
    }

    private List<String> getCities(String str) {
        List<String> list = new ArrayList<>();
        String[] array = str.split(",");
        for (String element : array) {
            list.add(element.trim());
        }
        return list;
    }
}