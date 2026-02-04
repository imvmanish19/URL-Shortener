package com.blinklink.urlshortener.domain.shorturl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortUrlTest {

    @Test
    void shouldCreateShortUrlAggregate() {
        ShortUrl shortUrl = ShortUrl.create(
            new ShortCode("abc123"),
            new OriginalUrl("https://example.com")
        );

        assertEquals("abc123", shortUrl.code().value());
        assertEquals("https://example.com", shortUrl.originalUrl().value());
    }
}
