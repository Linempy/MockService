package com.mockservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.format.DateTimeParseException;

/**
 * Глобальный обработчик ошибок
 *
 * @author Linempy
 * @since 15.03.2026
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({
            DateTimeParseException.class,
            MethodArgumentTypeMismatchException.class,
            MissingServletRequestParameterException.class
    })
    public ResponseEntity<ErrorResponse> handleBadRequest(Exception ex) {
        String message = "Неверный формат даты. Используйте dd/MM/yyyy";

        if (ex instanceof MissingServletRequestParameterException) {
            message = "Отсутствует обязательный параметр date_req";
        }

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(400, message));
    }

    @ExceptionHandler(SimulatedServerErrorException.class)
    public ResponseEntity<ErrorResponse> handleSimulatedError(SimulatedServerErrorException ex) {
        return ResponseEntity
                .status(500)
                .body(new ErrorResponse(500, ex.getMessage()));
    }
}