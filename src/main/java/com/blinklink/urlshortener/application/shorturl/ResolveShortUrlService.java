package com.blinklink.urlshortener.application.shorturl;

import com.blinklink.urlshortener.domain.shorturl.OriginalUrl;
import com.blinklink.urlshortener.domain.shorturl.ShortCode;
import com.blinklink.urlshortener.domain.shorturl.ShortUrl;
import com.blinklink.urlshortener.domain.shorturl.repository.ShortUrlRepository;
import com.blinklink.urlshortener.infrastructure.cache.ShortUrlCacheEntry;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ResolveShortUrlService {

    private final ShortUrlRepository repository;

    public ResolveShortUrlService(ShortUrlRepository repository) {
        this.repository = repository;
    }

    @Cacheable(value = "short-url", key = "#code")
    public ShortUrlCacheEntry resolveCached(String code) {

        ShortUrl shortUrl = repository.findByCode(new ShortCode(code))
                .orElseThrow(() -> new IllegalArgumentException("Not found"));

        return new ShortUrlCacheEntry(
                shortUrl.code().value(),
                shortUrl.originalUrl().value()
        );
    }

    public ShortUrl resolve(String code) {
        ShortUrlCacheEntry cached = resolveCached(code);

        return ShortUrl.create(
                new ShortCode(cached.code()),
                new OriginalUrl(cached.originalUrl())
        );
    }
}
