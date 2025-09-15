package com.example.validation_demo.controller;

import com.example.validation_demo.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@Validated // enables constraint validation on @PathVariable/@RequestParam
public class ValidationController {

    @PostMapping("/vessels")
    public ResponseEntity<?> createVessel(@Valid @RequestBody VesselDTO dto) {
        return ResponseEntity.ok(Map.of("message", "created", "vesselName", dto.getVesselName()));
    }

    // validate a list (wrap list in container DTO for reliable validation)
    @PostMapping("/vessels/bulk")
    public ResponseEntity<?> createBulk(@Valid @RequestBody VesselListDTO listDto) {
        return ResponseEntity.ok(Map.of("message", "bulk created", "count", listDto.getVessels().size()));
    }

    // path variable validation example
    @PutMapping("/vessels/{id}")
    public ResponseEntity<?> updateVessel(@PathVariable @Min(value = 1, message = "id must be ≥1") Long id,
                                          @Valid @RequestBody VesselDTO dto) {
        return ResponseEntity.ok(Map.of("message", "updated", "id", id));
    }

    // class-level validator demo
    @PostMapping("/daterange")
    public ResponseEntity<?> dateRange(@Valid @RequestBody DateRangeDTO dto) {
        return ResponseEntity.ok(Map.of("message", "ok"));
    }

    // serve validation constants to frontend
    @GetMapping("/validation-metadata")
    public Map<String, Object> validationMeta() {
        return Map.of("VESSEL_NAME_MAX", 100, "CPR_REGEX", "\\d{9}");
    }
}
