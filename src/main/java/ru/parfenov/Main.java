package ru.parfenov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Main.class);
        application.run();
        RequestToSitesLogic requestToSitesLogic = new RequestToSitesLogic();
        requestToSitesLogic.run();
    }
}