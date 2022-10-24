package com.ls.shortnerurl.service;

import com.ls.shortnerurl.exceptions.UrlNotFoundRuntimeException;
import com.ls.shortnerurl.model.UrlMap;
import com.ls.shortnerurl.repository.UrlMapRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlService {

    final int SHORT_URL_LENGTH = 4;
    final String URL_BASE = "localhost:88/";

    @Autowired
    private UrlMapRepository urlMapRepository;

    public String newUrlShort(String originalUrl){
        String shortId = RandomStringUtils.randomAlphanumeric(SHORT_URL_LENGTH);
        while (urlMapRepository.existsById(shortId)){
            shortId = RandomStringUtils.randomAlphanumeric(SHORT_URL_LENGTH);
        }
        UrlMap urlMap = new UrlMap(shortId, originalUrl);
        urlMapRepository.save(urlMap);

        return URL_BASE+shortId;
    }

    public String goTo(String id) {
        Optional<UrlMap> optional = urlMapRepository.findById(id);
        if (optional.isEmpty()){
            throw new UrlNotFoundRuntimeException("Short URL not found!");
        }
        UrlMap urlMap = optional.get();
        return urlMap.getRedirectUrl();
    }
}
