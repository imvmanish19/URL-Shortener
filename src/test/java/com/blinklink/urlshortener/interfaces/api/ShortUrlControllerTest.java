package com.blinklink.urlshortener.interfaces.api;

import com.blinklink.urlshortener.application.shorturl.CreateShortUrlService;
import com.blinklink.urlshortener.application.shorturl.ResolveShortUrlService;
import com.blinklink.urlshortener.domain.shorturl.OriginalUrl;
import com.blinklink.urlshortener.domain.shorturl.ShortCode;
import com.blinklink.urlshortener.domain.shorturl.ShortUrl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ShortUrlController.class)
@AutoConfigureMockMvc
class ShortUrlControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CreateShortUrlService createService;

    @MockitoBean
    private ResolveShortUrlService resolveService;

    @Test
    void shouldCreateShortUrl() throws Exception {
        ShortUrl shortUrl = ShortUrl.create(
                new ShortCode("abc123"),
                new OriginalUrl("https://example.com")
        );

        when(createService.create(any()))
                .thenReturn(shortUrl);

        mockMvc.perform(
                        post("/api/short-urls")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                        { "originalUrl": "https://example.com" }
                    """)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("abc123"));
    }

    @Test
    void shouldRedirect() throws Exception {
        ShortUrl shortUrl = ShortUrl.create(
                new ShortCode("abc123"),
                new OriginalUrl("https://example.com")
        );

        when(resolveService.resolve("abc123"))
                .thenReturn(shortUrl);

        mockMvc.perform(get("/api/short-urls/abc123"))
                .andExpect(status().isFound())
                .andExpect(header().string("Location", "https://example.com"));
    }
}
