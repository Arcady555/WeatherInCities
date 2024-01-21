package ru.parfenov.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.parfenov.utility.Temperature;

@AllArgsConstructor
@Getter
public class ResponseDTO3 {
    private String address;
    private Temperature[] days;
}
