package com.mockservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;


/**
 * Сущность курса валют
 *
 * @author Linempy
 * @since 14.03.2026
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "exchange_rate")
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rate_date", nullable = false)
    private LocalDate date;

    @Column(name = "currency_id", nullable = false)
    private String currencyId;

    @Column(name = "num_code")
    private String numCode;

    @Column(name = "char_code", nullable = false)
    private String charCode;

    @Column(name = "nominal", nullable = false)
    private Integer nominal;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "value_rate", nullable = false, precision = 10, scale = 4)
    private BigDecimal valueRate;

    @Column(name = "vunit_rate", precision = 10, scale = 4)
    private BigDecimal vunitRate;

}