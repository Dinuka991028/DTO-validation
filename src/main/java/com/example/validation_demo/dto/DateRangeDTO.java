package com.example.validation_demo.dto;

import com.example.validation_demo.validation.ValidDateRange;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@ValidDateRange(message = "startDate must be before endDate")
public class DateRangeDTO {

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

}
