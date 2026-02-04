package com.blinklink.urlshortener.domain.shorturl;

import java.net.URI;

public final class OriginalUrl {

    private final String value;

    public OriginalUrl(String value) {
        URI uri = URI.create(value);
        if (!uri.isAbsolute()) {
            throw new IllegalArgumentException("Invalid URL");
        }
        this.value = value;
    }

    public String value() {
        return value;
    }
}
