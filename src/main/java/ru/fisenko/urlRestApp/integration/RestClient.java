package ru.fisenko.urlRestApp.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class RestClient {
    private RestTemplate restTemplate = new RestTemplate();
    @Value("${post.url}")
    String url_post;
    @Value("${csrf.url}")
    String url_csrf;

    //TODO доделать отправку sendPostRequest с csft токеном
/*    public String sendGetRequest() {
        String response = restTemplate.getForObject(url_csrf, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode obj = null;
        try {
            obj = mapper.readTree(response);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return obj.get("token").textValue();
    }*/

    public String[] sendPostRequest(List<String> urls) {
        return restTemplate.postForObject(url_post, urls, String[].class);
    }


}
