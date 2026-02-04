package com.blinklink.urlshortener.domain.shorturl.repository;

import com.blinklink.urlshortener.domain.shorturl.ShortCode;
import com.blinklink.urlshortener.domain.shorturl.ShortUrl;

import java.util.Optional;

public interface ShortUrlRepository {
    void save(ShortUrl shortUrl);
    Optional<ShortUrl> findByCode(ShortCode code);
}
