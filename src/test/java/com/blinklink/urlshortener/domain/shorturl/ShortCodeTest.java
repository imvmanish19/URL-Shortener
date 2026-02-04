package com.blinklink.urlshortener.domain.shorturl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShortCodeTest {

    @Test
    void shouldCreateValidShortCode() {
        ShortCode code = new ShortCode("aB9xPq1");
        assertEquals("aB9xPq1", code.value());
    }

    @Test
    void shouldRejectInvalidShortCode() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new ShortCode("ab@12")
        );
    }
}
