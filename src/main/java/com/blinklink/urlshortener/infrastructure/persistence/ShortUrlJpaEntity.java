package com.blinklink.urlshortener.infrastructure.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "short_urls")
public class ShortUrlJpaEntity {

    @Id
    private String code;

    @Column(nullable = false, length = 2048)
    private String originalUrl;

    protected ShortUrlJpaEntity() {}

    public ShortUrlJpaEntity(String code, String originalUrl) {
        this.code = code;
        this.originalUrl = originalUrl;
    }

    public String getCode() { return code; }
    public String getOriginalUrl() { return originalUrl; }
}
