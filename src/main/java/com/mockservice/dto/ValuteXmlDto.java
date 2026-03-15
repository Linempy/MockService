package com.mockservice.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * DTO с курсом валюты
 *
 * @author Linempy
 * @since 14.03.2026
 */
@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Информация о конкретной валюте")
public class ValuteXmlDto {
    @JacksonXmlProperty(isAttribute = true, localName = "ID")
    @Schema(description = "Идентификатор валюты в системе ЦБ РФ", example = "R01235")
    private String currencyId;

    @JacksonXmlProperty(localName = "NumCode")
    @Schema(description = "Трехзначный цифровой код валюты", example = "840")
    private String numCode;

    @JacksonXmlProperty(localName = "CharCode")
    @Schema(description = "Трехзначный буквенный код валюты", example = "USD")
    private String charCode;

    @JacksonXmlProperty(localName = "Nominal")
    @Schema(description = "Номинал (количество единиц валюты)", example = "1")
    private String nominal;

    @JacksonXmlProperty(localName = "Name")
    @Schema(description = "Наименование валюты на русском языке", example = "Доллар США")
    private String name;

    @JacksonXmlProperty(localName = "Value")
    @Schema(description = "Курс валюты в рублях", example = "30,9436")
    private String valueRate;

    @JacksonXmlProperty(localName = "VunitRate")
    @Schema(description = "Курс за одну единицу валюты", example = "30,9436")
    private String vunitRate;

    public void setNominal(Integer nominal) {
        this.nominal = String.valueOf(nominal);
    }

    public void setValueRate(BigDecimal value) {
        this.valueRate = value.toString().replace('.', ',');
    }

    public void setVunitRate(BigDecimal vunitRate) {
        if (vunitRate != null) {
            this.vunitRate = vunitRate.toString().replace('.', ',');
        }
    }
}