package com.example.validation_demo.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class VesselListDTO {
    @Valid
    @NotEmpty
    private List<VesselDTO> vessels;
}
