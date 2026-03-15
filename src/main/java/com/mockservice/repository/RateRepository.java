package com.mockservice.repository;

import com.mockservice.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * Репозиторий с курсом валют, использует сущность {@link ExchangeRate}
 *
 * @see ExchangeRate
 *
 * @author Linempy
 * @since 13.03.2026
 */
public interface RateRepository extends JpaRepository<ExchangeRate, Long> {

    List<ExchangeRate> findByDate(LocalDate date);
}