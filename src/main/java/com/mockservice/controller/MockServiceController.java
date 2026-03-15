package com.mockservice.controller;

import com.mockservice.dto.ValCursXmlDto;
import com.mockservice.exception.SimulatedServerErrorException;
import com.mockservice.service.CbrService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * REST контроллер для имитации работы эндпоинта https://www.cbr.ru/scripts/XML_daily.asp
 * <p>
 * Предоставляет эндпоинт для получения курсов валют в формате, совместимом с API ЦБ РФ.
 *
 * @author Linempy
 * @since 13.03.2026
 */
@RestController
@RequiredArgsConstructor
@Tag(name = "Валютные курсы", description = "API для получения курсов валют, имитирующее ответы ЦБ РФ")
public class MockServiceController {

    private final CbrService service;

    @GetMapping(value = "/scripts/XML_daily.asp",
                produces = MediaType.APPLICATION_XML_VALUE)
    @Operation(
            summary = "Получить курсы валют на указанную дату",
            description = "Возвращает курсы валют в формате XML"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Курсы валют успешно получены",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_XML_VALUE,
                            schema = @Schema(implementation = ValCursXmlDto.class)
                    )
            ),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера", content = @Content),
            @ApiResponse(responseCode = "400", description = "Неверный формат даты", content = @Content),
    })
    public ResponseEntity<ValCursXmlDto> getExchangeRateByDate(
            @Parameter(
                    description = "Дата запроса в формате dd/MM/yyyy",
                    required = true,
                    example = "02/03/2002"
            )
            @RequestParam("date_req")
            @DateTimeFormat(pattern = "dd/MM/yyyy")
            LocalDate date,

            @Parameter(
                    description = "Параметр для симуляции ошибки сервера. Если передать status=500,"
                                  + " вернется пустой ответ с кодом 500"
            )
            @RequestParam(value = "status", required = false)
            Integer status) {

        if (status != null && status == 500) {
            throw new SimulatedServerErrorException("Симулированная ошибка 500");
        }

        ValCursXmlDto result = service.getExchangeRateByDate(date);
        return ResponseEntity.ok(result);
    }
}