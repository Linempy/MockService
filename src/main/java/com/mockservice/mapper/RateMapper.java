package com.mockservice.mapper;

import com.mockservice.dto.ValCursXmlDto;
import com.mockservice.dto.ValuteXmlDto;
import com.mockservice.entity.ExchangeRate;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDate;
import java.util.List;

/**
 * Маппер для курса валют
 *
 * @author Linempy
 * @since 14.03.2026
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RateMapper {

    default ValCursXmlDto toXmlDto(List<ExchangeRate> rates, LocalDate date) {
        ValCursXmlDto result = new ValCursXmlDto();
        result.setDate(date);

        List<ValuteXmlDto> valutes = rates.stream()
                .map(this::toValuteDto)
                .toList();

        result.setValutes(valutes);
        return result;
    }

    ValuteXmlDto toValuteDto(ExchangeRate rate);
}