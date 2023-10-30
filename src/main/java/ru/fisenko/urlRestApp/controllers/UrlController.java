package ru.fisenko.urlRestApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fisenko.urlRestApp.services.UrlService;

@RestController
@RequestMapping("/api")
public class UrlController {
    private UrlService urlService;
    @Autowired
    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/url")
    public String newUrl (){
        return urlService.getUrl();
    }




}
