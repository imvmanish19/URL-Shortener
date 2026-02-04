package com.blinklink.urlshortener.domain.shorturl.exception;

public class ShortUrlNotFoundException extends RuntimeException {
    public ShortUrlNotFoundException(String code) {
        super("Short URL not found: " + code);
    }
}
