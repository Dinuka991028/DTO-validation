package com.example.validation_demo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

import static com.example.validation_demo.ValidationConstants.CPR_REGEX;

@Getter
@Setter
public class OwnerDTO {

    @NotBlank
    private String name;

    @Pattern(regexp = CPR_REGEX, message = "CPR must be 9 digits")
    private String cpr;

    @Email
    private String email;

    @Past(message = "dateOfBirth must be in the past")
    private LocalDate dateOfBirth;
}
