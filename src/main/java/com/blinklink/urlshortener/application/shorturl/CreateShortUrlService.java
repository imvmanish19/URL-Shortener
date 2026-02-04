package com.blinklink.urlshortener.application.shorturl;

import com.blinklink.urlshortener.domain.shorturl.OriginalUrl;
import com.blinklink.urlshortener.domain.shorturl.ShortCode;
import com.blinklink.urlshortener.domain.shorturl.ShortUrl;
import com.blinklink.urlshortener.domain.shorturl.repository.ShortUrlRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateShortUrlService {

    private final ShortUrlRepository repository;

    public CreateShortUrlService(ShortUrlRepository repository) {
        this.repository = repository;
    }

    public ShortUrl create(String originalUrl) {
        var code = new ShortCode(UUID.randomUUID().toString().substring(0, 7));
        var url = new OriginalUrl(originalUrl);

        var shortUrl = ShortUrl.create(code, url);
        repository.save(shortUrl);
        return shortUrl;
    }
}
