package com.blinklink.urlshortener.infrastructure.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "short_urls")
public class ShortUrlJpaEntity {

    @Id
    private String code;

    @Column(nullable = false, length = 2048)
    private String originalUrl;

    private Instant createdAt;

    protected ShortUrlJpaEntity() {}

    public ShortUrlJpaEntity(String code, String originalUrl, Instant createdAt) {
        this.code = code;
        this.originalUrl = originalUrl;
        this.createdAt = createdAt;
    }

    public String getCode() { return code; }
    public String getOriginalUrl() { return originalUrl; }
}
