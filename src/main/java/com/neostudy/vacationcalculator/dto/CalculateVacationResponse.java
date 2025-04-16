package com.neostudy.vacationcalculator.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CalculateVacationResponse {

    @Schema(description = "Amount of vacation pay", example = "74500,00")
    private String amount;
}
