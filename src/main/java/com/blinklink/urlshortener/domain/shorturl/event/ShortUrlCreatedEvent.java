package com.blinklink.urlshortener.domain.shorturl.event;

import com.blinklink.urlshortener.domain.shorturl.ShortCode;

public record ShortUrlCreatedEvent(ShortCode code) {}
