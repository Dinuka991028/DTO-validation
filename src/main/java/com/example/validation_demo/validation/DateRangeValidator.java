package com.example.validation_demo.validation;

import com.example.validation_demo.dto.DateRangeDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateRangeValidator implements ConstraintValidator<ValidDateRange, DateRangeDTO> {

    @Override
    public boolean isValid(DateRangeDTO dto, ConstraintValidatorContext ctx) {
        if (dto == null) return true; // leave null checks to @NotNull on fields
        if (dto.getStartDate() == null || dto.getEndDate() == null) return true;
        return dto.getStartDate().isBefore(dto.getEndDate()) || dto.getStartDate().isEqual(dto.getEndDate());
    }
}
