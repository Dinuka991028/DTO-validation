package com.example.validation_demo.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class EngineDTO {

    @NotBlank(message = "engineNo required")
    private String engineNo;

    @Min(value = 1, message = "hp must be >= 1")
    private Integer hp;
}
