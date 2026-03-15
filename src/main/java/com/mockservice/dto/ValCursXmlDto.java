package com.mockservice.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Основное DTO ответа, содержащее список курса валют
 *
 * @author Linempy
 * @since 14.03.2026
 */
@Getter
@Setter
@JacksonXmlRootElement(localName = "ValCurs")
@Schema(description = "Корневой элемент ответа с курсами валют")
public class ValCursXmlDto {

    private static final String NAME = "Foreign Currency Market";
    private static final String PATTERN_DATE = "dd/MM/yyyy";

    @JacksonXmlProperty(isAttribute = true, localName = "Date")
    @Schema(description = "Дата, на которую запрошены курсы", example = "02/03/2002")
    private String date;

    @JacksonXmlProperty(isAttribute = true, localName = "name")
    @Schema(description = "Название источника данных")
    private String name = NAME;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Valute")
    private List<ValuteXmlDto> valutes;

    public void setDate(LocalDate date) {
        this.date = date.format(DateTimeFormatter.ofPattern(PATTERN_DATE));
    }
}