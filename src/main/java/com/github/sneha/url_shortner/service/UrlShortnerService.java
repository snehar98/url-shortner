package com.github.sneha.url_shortner.service;
import com.github.sneha.url_shortner.model.Url;
import com.github.sneha.url_shortner.repository.UrlsRepository;
import com.github.sneha.url_shortner.utils.ShortUrlGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlShortnerService {

    @Autowired
    UrlsRepository urlsRepository;

    public String getShortUrl(String longUrl){
        Url urlEntity = new Url();
        urlEntity.setLongUrl(longUrl);
        urlEntity.setShortUrl(shortenUrl(longUrl));
        saveUrltoDB(urlEntity);
        return urlEntity.getShortUrl();
    }

    private String shortenUrl(String longUrl){
        String shortUrl= ShortUrlGenerator.generateShortUrl();
        return shortUrl;
    }

    private void saveUrltoDB(Url url){
        urlsRepository.save(url);
    }
}
