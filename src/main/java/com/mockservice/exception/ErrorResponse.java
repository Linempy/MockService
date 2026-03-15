package com.mockservice.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Объект для ответа с ошибкой
 *
 * @author Linempy
 * @since 15.03.2026
 */
@Getter
@Setter
@AllArgsConstructor
@Schema(description = "Ответ с ошибкой")
public class ErrorResponse {

    @Schema(description = "Код ошибки", example = "400")
    private int code;

    @Schema(description = "Сообщение об ошибке", example = "Неверный формат даты")
    private String message;
}