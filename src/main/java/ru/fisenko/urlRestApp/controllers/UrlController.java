package ru.fisenko.urlRestApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fisenko.urlRestApp.services.UrlService;

@RestController
public class UrlController {
    private final UrlService urlService;
    @Autowired
    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/generate")
    public String newUrl (){
        return urlService.getUrl();
    }
}
