package ru.parfenov.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.parfenov.utility.City;
import ru.parfenov.utility.Temperature;

@AllArgsConstructor
@Getter
public class ResponseDTO2 {
    private City location;
    private Temperature current;
}
