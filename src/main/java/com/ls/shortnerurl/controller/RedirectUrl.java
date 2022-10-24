package com.ls.shortnerurl.controller;


import com.ls.shortnerurl.service.UrlService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class RedirectUrl {


    @Autowired
    private UrlService urlService;

    @GetMapping("/{id}")
    @Operation(summary = "Redirect to the original URL")
    public ResponseEntity<String> getRedirect(@PathVariable String id){
        return ResponseEntity.status(301).header("Location", urlService.goTo(id)).body("");
    }

    @PostMapping("/url_shortener")
    @Operation(summary = "Post a new url to be shortened")
    public ResponseEntity<String> newShortUrl(@RequestParam String url){
        return ResponseEntity.status(HttpStatus.CREATED).body(urlService.newUrlShort(url));
    }
}

