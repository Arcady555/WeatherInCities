package ru.parfenov.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.parfenov.utility.Country;
import ru.parfenov.utility.Temperature;

@AllArgsConstructor
@Getter
public class ResponseDTO1 {
    private String name;
    private Country sys;
    private Temperature main;
}