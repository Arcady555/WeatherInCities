package ru.parfenov.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@AllArgsConstructor
@Getter
@Entity
@NoArgsConstructor
@Table(name = "responses")
public class ResponseFromWeatherPr {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Id must be non null")
    private int id;
    private String city;
    private float temperature;
    private Timestamp dateAndTime;
}