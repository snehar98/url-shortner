package com.github.sneha.url_shortner.service;

import com.github.sneha.url_shortner.exception.InvalidUrlException;
import com.github.sneha.url_shortner.model.Url;
import com.github.sneha.url_shortner.repository.UrlsRepository;
import com.github.sneha.url_shortner.utils.ShortUrlGenerator;
import com.github.sneha.url_shortner.utils.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UrlShortnerService {

    @Autowired
    UrlsRepository urlsRepository;

    public String getShortUrl(String longUrl) {
        Url urlEntity = new Url();
        urlEntity.setLongUrl(longUrl);
        urlEntity.setShortUrl(shortenUrl(longUrl));
        log.info("Short Url - {} - Length - {} ",urlEntity.getShortUrl(),urlEntity.getShortUrl().length());
        saveUrltoDB(urlEntity);
        return urlEntity.getShortUrl();
    }

    private String shortenUrl(String longUrl) {
        String shortUrl = ShortUrlGenerator.generateShortUrl();
        return shortUrl;
    }

    private void saveUrltoDB(Url url) {
        urlsRepository.save(url);
    }
}
