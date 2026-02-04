package com.blinklink.urlshortener.domain.shorturl;

public final class ShortCode {

    private final String value;

    public ShortCode(String value) {
        if (!value.matches("^[a-zA-Z0-9]{6,8}$")) {
            throw new IllegalArgumentException("Invalid short code");
        }
        this.value = value;
    }

    public String value() {
        return value;
    }
}
