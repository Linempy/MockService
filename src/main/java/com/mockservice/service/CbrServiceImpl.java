package com.mockservice.service;

import com.mockservice.dto.ValCursXmlDto;
import com.mockservice.entity.ExchangeRate;
import com.mockservice.mapper.RateMapper;
import com.mockservice.repository.RateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Сервис для получения курса валют
 *
 * @author Linempy
 * @since 13.03.2026
 */
@Service
@RequiredArgsConstructor
public class CbrServiceImpl implements CbrService {

    private final RateRepository repository;
    private final RateMapper mapper;

    public ValCursXmlDto getExchangeRateByDate(LocalDate date) {
        List<ExchangeRate> result = repository.findByDate(date);
        return mapper.toXmlDto(result, date);
    }
}