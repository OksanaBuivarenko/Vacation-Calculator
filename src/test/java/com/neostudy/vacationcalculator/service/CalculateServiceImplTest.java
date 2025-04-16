package com.neostudy.vacationcalculator.service;

import com.neostudy.vacationcalculator.dto.CalculateVacationRequest;
import com.neostudy.vacationcalculator.dto.CalculateVacationResponse;
import com.neostudy.vacationcalculator.repository.HolidaysRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculateServiceImplTest {

    @Mock
    private HolidaysRepository holidaysRepository;

    @InjectMocks
    private CalculateServiceImpl calculateService;

    CalculateVacationRequest request;

    private Set<LocalDate> holidays;

    @BeforeEach
    void setUp() {
        request = CalculateVacationRequest.builder()
                .averageSalary(75600)
                .countVacationDays(14)
                .build();

        holidays = Set.of(
                LocalDate.of(2024, 1, 1),
                LocalDate.of(2024, 1, 2),
                LocalDate.of(2024, 1, 3),
                LocalDate.of(2024, 1, 4),
                LocalDate.of(2024, 1, 5),
                LocalDate.of(2024, 1, 8),
                LocalDate.of(2024, 2, 23),
                LocalDate.of(2024, 3, 8),
                LocalDate.of(2024, 5, 1),
                LocalDate.of(2024, 5, 9),
                LocalDate.of(2024, 5, 10),
                LocalDate.of(2024, 6, 12),
                LocalDate.of(2024, 12, 30),
                LocalDate.of(2024, 12, 31),
                LocalDate.of(2025, 1, 1),
                LocalDate.of(2025, 1, 2),
                LocalDate.of(2025, 1, 3),
                LocalDate.of(2025, 1, 6),
                LocalDate.of(2025, 1, 7),
                LocalDate.of(2025, 1, 8),
                LocalDate.of(2025, 5, 1),
                LocalDate.of(2025, 5, 2),
                LocalDate.of(2025, 5, 8),
                LocalDate.of(2025, 5, 9),
                LocalDate.of(2025, 6, 12),
                LocalDate.of(2025, 6, 13),
                LocalDate.of(2025, 11, 3),
                LocalDate.of(2025, 11, 4),
                LocalDate.of(2025, 12, 31)
        );
    }

    @AfterEach
    void tearDown() {
        request = null;
        holidays = null;
    }

    @Test
    void calculateVacationWhenStartVacationIsNull() {
        CalculateVacationResponse result = calculateService.calculateVacation(request);

        assertEquals("36122,87", result.getAmount());
    }

    @Test
    void calculateVacationWhenStartVacationIsNotNull() {
        request.setStartVacation(LocalDate.of(2025, 5, 1));
        when(holidaysRepository.getHolidays()).thenReturn(holidays);

        CalculateVacationResponse result = calculateService.calculateVacation(request);

        assertEquals("25802,05", result.getAmount());
    }

    @Test
    void getAverageWorkingDaysInMonthWhenStartVacationIsNull() {
        int result = calculateService.getCountVacationDaysWithHolidays(request);

        assertEquals(14, result);
    }

    @Test
    void getAverageWorkingDaysInMonthWhenStartVacationIsNotNull() {
        request.setStartVacation(LocalDate.of(2025, 5, 1));
        when(holidaysRepository.getHolidays()).thenReturn(holidays);

        int result = calculateService.getCountVacationDaysWithHolidays(request);

        assertEquals(10, result);
    }
}