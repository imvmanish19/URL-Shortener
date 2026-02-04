package com.blinklink.urlshortener.domain.shorturl;

import com.blinklink.urlshortener.domain.shorturl.event.ShortUrlCreatedEvent;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ShortUrl {

    private final ShortCode code;
    private final OriginalUrl originalUrl;
    private final Instant createdAt;

    private final List<Object> domainEvents = new ArrayList<>();

    private ShortUrl(ShortCode code, OriginalUrl originalUrl) {
        this.code = code;
        this.originalUrl = originalUrl;
        this.createdAt = Instant.now();
        domainEvents.add(new ShortUrlCreatedEvent(code));
    }

    public static ShortUrl create(ShortCode code, OriginalUrl originalUrl) {
        return new ShortUrl(code, originalUrl);
    }

    public ShortCode code() {
        return code;
    }

    public OriginalUrl originalUrl() {
        return originalUrl;
    }

    public Instant createdAt() {
        return createdAt;
    }
}
