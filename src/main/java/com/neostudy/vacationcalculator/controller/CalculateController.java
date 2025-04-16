package com.neostudy.vacationcalculator.controller;

import com.neostudy.vacationcalculator.dto.CalculateVacationRequest;
import com.neostudy.vacationcalculator.dto.CalculateVacationResponse;
import com.neostudy.vacationcalculator.service.CalculateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/calculacte")
public class CalculateController {

    private final CalculateService calculateService;

    @ApiResponse(responseCode = "200", description = "Amount of vacation pay calculated success")
    @ApiResponse(responseCode = "400", description = "Bad request")
    @Operation(description = "Calculate vacation days")
    @GetMapping()
    public CalculateVacationResponse calculateVacation(@ParameterObject @Valid CalculateVacationRequest request) {
        return calculateService.calculateVacation(request);
    }
}
