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

        if (!originalUrl.matches("[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)")
            || originalUrl.matches(".*\\.+|\\..*")){
            throw new UrlNotFoundRuntimeException("Please, insert a valid URL.");
        }

        String shortId = RandomStringUtils.randomAlphanumeric(SHORT_URL_LENGTH);
        while (urlMapRepository.existsById(shortId)){
            shortId = RandomStringUtils.randomAlphanumeric(SHORT_URL_LENGTH);
        }

        if (!originalUrl.matches("https://.*")){
            originalUrl = "https://" + originalUrl;
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
