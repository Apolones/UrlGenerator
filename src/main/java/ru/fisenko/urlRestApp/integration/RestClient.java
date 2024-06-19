package ru.fisenko.urlRestApp.integration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class RestClient {
    private final RestTemplate restTemplate = new RestTemplate();
    @Value("${post.url}")
    String url_post;

    public String[] sendPostRequest(List<String> urls) {
        return restTemplate.postForObject(url_post, urls, String[].class);
    }
}
