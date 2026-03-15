package com.mockservice.service;

import com.mockservice.dto.ValCursXmlDto;

import java.time.LocalDate;

/**
 * CbrService — интерфейс сервиса для получения курса валют
 *
 * @author Linempy
 * @since 13.03.2026
 */
public interface CbrService {

    /**
     * Метод для получения курса валют по дате
     *
     * @param date - дата
     * @return {@link ValCursXmlDto}
     */
    ValCursXmlDto getExchangeRateByDate(LocalDate date);
}