package com.neostudy.vacationcalculator.service;

import com.neostudy.vacationcalculator.dto.CalculateVacationRequest;
import com.neostudy.vacationcalculator.dto.CalculateVacationResponse;

public interface CalculateService {

    CalculateVacationResponse calculateVacation(CalculateVacationRequest request);
}
