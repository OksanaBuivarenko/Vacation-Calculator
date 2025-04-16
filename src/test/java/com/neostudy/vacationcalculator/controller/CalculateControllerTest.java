package com.neostudy.vacationcalculator.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class CalculateControllerTest {

    @LocalServerPort
    private Integer port;

    @Autowired
    MockMvc mockMvc;

    @Test
    void calculateVacationWhenStartVacationIsNullSuccess() throws Exception {
        this.mockMvc.perform(get("http://localhost:" + port + "/calculacte")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("averageSalary", "75600")
                        .param("countVacationDays", "14"))
                .andDo(print())
                .andExpectAll(status().isOk())
                .andExpect(jsonPath("$.amount").value("36122,87"));
    }

    @Test
    void calculateVacationWhenStartVacationIsNullFail() throws Exception {
        this.mockMvc.perform(get("http://localhost:" + port + "/calculacte")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("averageSalary", "0"))
                .andDo(print())
                .andExpectAll(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Not valid fields"))
                .andExpect(jsonPath("$.params.averageSalary")
                        .value("The average salary must be at least 1"))
                .andExpect(jsonPath("$.params.countVacationDays")
                        .value("must not be null"));
    }

    @Test
    void calculateVacationWhenStartVacationIsNotNullSuccess() throws Exception {
        this.mockMvc.perform(get("http://localhost:" + port + "/calculacte")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("averageSalary", "75600")
                        .param("countVacationDays", "14")
                        .param("startVacation", "01-09-2025"))
                .andDo(print())
                .andExpectAll(status().isOk())
                .andExpect(jsonPath("$.amount").value("36122,87"));
    }

    @Test
    void calculateVacationWhenStartVacationIsNotNullFail() throws Exception {
        this.mockMvc.perform(get("http://localhost:" + port + "/calculacte")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("averageSalary", "75600")
                        .param("countVacationDays", "14")
                        .param("startVacation", "01-05-2023"))
                .andDo(print())
                .andExpectAll(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Not valid fields"))
                .andExpect(jsonPath("$.params.startVacation").value("must be a future date"));
    }
}