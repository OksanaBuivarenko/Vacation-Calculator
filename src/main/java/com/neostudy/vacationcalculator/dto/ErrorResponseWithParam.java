package com.neostudy.vacationcalculator.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Builder
@Getter
public class ErrorResponseWithParam {

    @Schema(example = "BAD_REQUEST")
    private HttpStatus status;

    @Schema(example = "Not valid fields")
    private String error;

    @Schema(example = "countVacationDays: The number of vacation days must be at least 1")
    private Map<String, String> params;
}
