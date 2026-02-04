package com.blinklink.urlshortener.infrastructure.persistence;

import com.blinklink.urlshortener.domain.shorturl.OriginalUrl;
import com.blinklink.urlshortener.domain.shorturl.ShortCode;
import com.blinklink.urlshortener.domain.shorturl.ShortUrl;
import com.blinklink.urlshortener.domain.shorturl.repository.ShortUrlRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ShortUrlRepositoryImpl implements ShortUrlRepository {

    private final ShortUrlJpaRepository jpa;

    public ShortUrlRepositoryImpl(ShortUrlJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public void save(ShortUrl shortUrl) {
        jpa.save(new ShortUrlJpaEntity(
                shortUrl.code().value(),
                shortUrl.originalUrl().value(),
                shortUrl.createdAt()
        ));
    }

    @Override
    public Optional<ShortUrl> findByCode(ShortCode code) {
        return jpa.findById(code.value())
                .map(e -> ShortUrl.create(
                        new ShortCode(e.getCode()),
                        new OriginalUrl(e.getOriginalUrl())
                ));
    }
}
