package com.blinklink.urlshortener.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortUrlJpaRepository
        extends JpaRepository<ShortUrlJpaEntity, String> {
}
