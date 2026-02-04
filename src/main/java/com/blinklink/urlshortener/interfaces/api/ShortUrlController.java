package com.blinklink.urlshortener.interfaces.api;

import com.blinklink.urlshortener.application.shorturl.CreateShortUrlService;
import com.blinklink.urlshortener.application.shorturl.ResolveShortUrlService;
import com.blinklink.urlshortener.interfaces.api.dto.CreateShortUrlRequest;
import com.blinklink.urlshortener.interfaces.api.dto.CreateShortUrlResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/short-urls")
public class ShortUrlController {

    private final CreateShortUrlService createService;
    private final ResolveShortUrlService resolveService;

    public ShortUrlController(
            CreateShortUrlService createService,
            ResolveShortUrlService resolveService) {
        this.createService = createService;
        this.resolveService = resolveService;
    }

    @PostMapping
    public CreateShortUrlResponse create(@RequestBody CreateShortUrlRequest request) {
        var shortUrl = createService.create(request.originalUrl());
        return new CreateShortUrlResponse(shortUrl.code().value());
    }

    @GetMapping("/{code}")
    public void redirect(@PathVariable String code, HttpServletResponse response) {
        var shortUrl = resolveService.resolve(code);
        response.setStatus(302);
        response.setHeader("Location", shortUrl.originalUrl().value());
    }
}
