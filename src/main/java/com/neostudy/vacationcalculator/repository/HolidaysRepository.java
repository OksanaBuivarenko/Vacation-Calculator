package com.neostudy.vacationcalculator.repository;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
@Getter
public class HolidaysRepository {

    private final Set<LocalDate> holidays = new HashSet<>();

    public HolidaysRepository() {
        holidays.add(LocalDate.of(2024, 1, 1));
        holidays.add(LocalDate.of(2024, 1, 2));
        holidays.add(LocalDate.of(2024, 1, 3));
        holidays.add(LocalDate.of(2024, 1, 4));
        holidays.add(LocalDate.of(2024, 1, 5));
        holidays.add(LocalDate.of(2024, 1, 8));
        holidays.add(LocalDate.of(2024, 2, 23));
        holidays.add(LocalDate.of(2024, 3, 8));
        holidays.add(LocalDate.of(2024, 5, 1));
        holidays.add(LocalDate.of(2024, 5, 9));
        holidays.add(LocalDate.of(2024, 5, 10));
        holidays.add(LocalDate.of(2024, 6, 12));
        holidays.add(LocalDate.of(2024, 12, 30));
        holidays.add(LocalDate.of(2024, 12, 31));
        holidays.add(LocalDate.of(2025, 1, 1));
        holidays.add(LocalDate.of(2025, 1, 2));
        holidays.add(LocalDate.of(2025, 1, 3));
        holidays.add(LocalDate.of(2025, 1, 6));
        holidays.add(LocalDate.of(2025, 1, 7));
        holidays.add(LocalDate.of(2025, 1, 8));
        holidays.add(LocalDate.of(2025, 5, 1));
        holidays.add(LocalDate.of(2025, 5, 2));
        holidays.add(LocalDate.of(2025, 5, 8));
        holidays.add(LocalDate.of(2025, 5, 9));
        holidays.add(LocalDate.of(2025, 6, 12));
        holidays.add(LocalDate.of(2025, 6, 13));
        holidays.add(LocalDate.of(2025, 11, 3));
        holidays.add(LocalDate.of(2025, 11, 4));
        holidays.add(LocalDate.of(2025, 12, 31));
    }
}
