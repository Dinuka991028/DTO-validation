package com.example.validation_demo.dto;


import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

import static com.example.validation_demo.ValidationConstants.*;

@Data
public class VesselDTO {

    @NotBlank(message = "vesselName required")
    @Size(max = VESSEL_NAME_MAX, message = "vesselName max " + VESSEL_NAME_MAX)
    private String vesselName;

    @NotBlank
    private String vesselType;

    @Pattern(regexp = CPR_REGEX, message = "ownerCpr must be 9 digits")
    private String ownerCpr;

    @Email
    private String ownerEmail;

    @Min(value = 1, message = "passengers must be >=1")
    @Max(value = 500, message = "passengers must be <=500")
    private Integer noPassengers;

    @DecimalMin(value = "0.1", message = "grossTonnage must be > 0")
    private BigDecimal grossTonnage;

    // nested DTO validation
    @Valid
    @NotNull(message = "owner is required")
    private OwnerDTO owner;

    // collection validation (list must be present & each EngineDTO validated)
    @Valid
    @Size(min = 1, message = "at least one engine required")
    private List<EngineDTO> engines;

    // getters / setters
}
