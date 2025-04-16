package com.neostudy.vacationcalculator.service;

import com.neostudy.vacationcalculator.dto.CalculateVacationRequest;
import com.neostudy.vacationcalculator.dto.CalculateVacationResponse;
import com.neostudy.vacationcalculator.repository.HolidaysRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CalculateServiceImpl implements CalculateService {

    private final HolidaysRepository holidaysRepository;

    @Override
    public CalculateVacationResponse calculateVacation(CalculateVacationRequest request) {
        double dailySalary = request.getAverageSalary() / 29.3;
        double amount = dailySalary * getCountVacationDaysWithHolidays(request);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return CalculateVacationResponse.builder().amount(decimalFormat.format(amount)).build();
    }

    public int getCountVacationDaysWithHolidays(CalculateVacationRequest request) {
        if (request.getStartVacation() == null) {
            return request.getCountVacationDays();
        }
        int vacationDays = request.getCountVacationDays();
        LocalDate startDate = request.getStartVacation();
        LocalDate endDate = request.getStartVacation().plusDays(request.getCountVacationDays());
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            if (dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY &&
                    holidaysRepository.getHolidays().contains(date)) {
                vacationDays--;
            }
        }
        return vacationDays;
    }
}
