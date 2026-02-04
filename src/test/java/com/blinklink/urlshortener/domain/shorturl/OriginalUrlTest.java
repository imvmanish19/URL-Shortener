package com.blinklink.urlshortener.domain.shorturl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class OriginalUrlTest {

    @Test
    void shouldAcceptValidUrl() {
        OriginalUrl url = new OriginalUrl("https://example.com");
        assertEquals("https://example.com", url.value());
    }

    @Test
    void shouldRejectInvalidUrl() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new OriginalUrl("not-a-url")
        );
    }
}
