package com.blinklink.urlshortener.infrastructure.cache;

import java.io.Serializable;

public record ShortUrlCacheEntry(String code, String originalUrl)
        implements Serializable {}
