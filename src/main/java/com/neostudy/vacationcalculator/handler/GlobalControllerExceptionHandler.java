package com.neostudy.vacationcalculator.handler;

import com.neostudy.vacationcalculator.dto.ErrorResponseWithParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErrorResponseWithParam> handleValidationExceptions(BindException ex) {
        Map<String, String> params = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            params.put(fieldName, errorMessage);
        });
        String error = "Not valid fields";
        log.error(error);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponseWithParam.builder()
                        .status(HttpStatus.BAD_REQUEST)
                        .error(error)
                        .params(params).build());
    }
}
