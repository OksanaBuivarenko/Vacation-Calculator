package com.neostudy.vacationcalculator.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class CalculateVacationRequest {

    @Schema(description = "Average salary", example = "76500")
    @Positive(message = "The average salary must be at least 1")
    @NotNull
    private Integer averageSalary;

    @Schema(description = "Count vacation days", example = "14")
    @Positive(message = "The number of vacation days must be at least 1")
    @NotNull
    private Integer countVacationDays;

    @Schema(description = "Start of vacation date", example = "01-09-2025")
    @Future
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate startVacation;
}
